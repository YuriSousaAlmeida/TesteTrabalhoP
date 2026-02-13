/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.infraestrutura;

/**
 *
 * @author Yuri
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInitializer {

    public static void inicializar() {
        String sqlForeignKeys = "PRAGMA foreign_keys = ON;";

        String sqlClientes = """
            CREATE TABLE IF NOT EXISTS clientes(
             id INTEGER PRIMARY KEY AUTOINCREMENT,
             nome TEXT NOT NULL,
             cpf TEXT NOT NULL UNIQUE,
             email TEXT NOT NULL,
             cidade TEXT NOT NULL,
             bairro TEXT NOT NULL,
             rua TEXT NOT NULL,
             numero TEXT NOT NULL
            );
        """;

        String sqlPedidos = """
            CREATE TABLE IF NOT EXISTS pedidos (
             id INTEGER PRIMARY KEY AUTOINCREMENT,
             cliente_id INTEGER NOT NULL,
             valor_total REAL NOT NULL,
             status TEXT NOT NULL,
             data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
             FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
            );
        """;

        String sqlItensPedido = """
            CREATE TABLE IF NOT EXISTS itens_pedido (
             id INTEGER PRIMARY KEY AUTOINCREMENT,
             pedido_id INTEGER NOT NULL,
             tipo TEXT NOT NULL,       
             tamanho TEXT NOT NULL,    
             valor_base REAL NOT NULL, 
             descricao_visual TEXT,    
             FOREIGN KEY (pedido_id) REFERENCES pedidos(id) ON DELETE CASCADE
            );
        """;

        String sqlItensAdicionais = """
            CREATE TABLE IF NOT EXISTS itens_adicionais (
             id INTEGER PRIMARY KEY AUTOINCREMENT,
             item_pedido_id INTEGER NOT NULL,
             nome TEXT NOT NULL,       
             valor_adicional REAL NOT NULL,
             FOREIGN KEY (item_pedido_id) REFERENCES itens_pedido(id) ON DELETE CASCADE
            );
        """;

        try (Connection connection = ConexaoSingleton.getConexao();
             Statement statement = connection.createStatement()) {

            statement.execute(sqlForeignKeys);
            statement.execute(sqlClientes);
            statement.execute(sqlPedidos);
            statement.execute(sqlItensPedido);
            statement.execute(sqlItensAdicionais);

            System.out.println("Banco de dados e tabelas verificados/criados com sucesso.");

        } catch (SQLException e) {
            System.err.println("Falha ao inicializar o banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

//Testar aqui o banco na hora de criar tabelas
    
    public static void main(String[] args) {
        System.out.println("Iniciando teste do banco");

        inicializar();

        System.out.println("\nListando tabelas criadas no banco:");
        
        String sqlVerificacao = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%';";

        try(Connection connection = ConexaoSingleton.getConexao();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlVerificacao)) {

            int contador = 0;
            while(rs.next()){
                contador++;
                System.out.println("Tabela encontrada: " + rs.getString("name"));
            }

            if(contador == 0){
                System.out.println("Nenhuma tabela encontrada. Algo deu errado.");
            }else{
                System.out.println("Total de tabelas encontradas: " + contador);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        
        System.out.println("Fim do teste");
    }
}
