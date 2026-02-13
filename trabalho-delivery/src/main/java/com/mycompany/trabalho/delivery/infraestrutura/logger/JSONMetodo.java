/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.infraestrutura.logger;

/**
 *
 * @author igor2
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class JSONMetodo implements ILoggerMetodo {

    @Override
    public void registrar(String mensagem) {
        Path caminhoPath = Paths.get("log.json");
        
        if(!Files.exists(caminhoPath)) criarArquivo();
        
        String mensagemFormatada = "{\"mensagem\": \"" + mensagem + "\"}\n";
        
        try {
            Files.writeString(caminhoPath, mensagemFormatada, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void criarArquivo() {
        Path caminhoPath = Paths.get("log.json");
        
        if (!Files.exists(caminhoPath)) {
            try {
                Files.createFile(caminhoPath);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
