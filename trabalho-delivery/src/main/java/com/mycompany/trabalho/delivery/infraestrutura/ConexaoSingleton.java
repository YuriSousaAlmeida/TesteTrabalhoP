/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.infraestrutura;
import com.mycompany.trabalho.delivery.infraestrutura.logger.Logger;
/**
 *
 * @author Yuri
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoSingleton {
    private static Connection conexao;
    
    private ConexaoSingleton(){
        
    }
    
    public static Connection getConexao(){
        try{
            if(conexao==null || conexao.isClosed()){
                Properties properties = carregarConfiguracoes();
                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");
                if(password==null) password="";
                
                conexao=DriverManager.getConnection(url, user, password);
                Logger.getInstancia().registrar("[DB INFO] Nova conexão com a base de dados estabelecida.");                
            }
        }catch(SQLException e){
            Logger.getInstancia().registrar("[DB ERRO] Falha ao conectar na base de dados: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar no banco de dados", e);
        }
        return conexao;
    }
    
    private static Properties carregarConfiguracoes(){
        Properties properties = new Properties();
        
        try(InputStream input = ConexaoSingleton.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input==null){
                throw new RuntimeException("Erro: application.properties nao encontrado");
            }
            
            properties.load(input);
        } catch (IOException e){
            throw new RuntimeException("Erro ao ler o arquivo de configurações", e);
        }
        
        return properties;
    }
    
    public static void main(String[] args) {
        System.out.println("Teste de conexao");

        try {
            Connection conexao = ConexaoSingleton.getConexao();

            if(conexao != null || conexao.isClosed()){
                System.out.println("A conexão foi estabelecida");
            }else{
                System.err.println("Não foi possível estabelecer a conexao");
            }

        }catch (Exception e){
            System.err.println("Falha ao conectar:");
            e.printStackTrace();
        }

        System.out.println("Teste finalizado");
    }
    
}
