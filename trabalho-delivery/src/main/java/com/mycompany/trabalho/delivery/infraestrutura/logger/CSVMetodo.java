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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CSVMetodo implements ILoggerMetodo {
    private char caractere;
    
    public CSVMetodo(char caractere) {
        this.caractere = caractere;
    }
    
    @Override
    public void registrar(String mensagem) {
        Path caminhoPath = Paths.get("log.csv");
        
        if(!Files.exists(caminhoPath)) criarArquivo();
        
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String mensagemFormatada = LocalDateTime.now().format(formatacao) + caractere + "\"" + mensagem + "\"\n";
        
        try {
            Files.writeString(caminhoPath, mensagemFormatada, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void criarArquivo() {
        Path caminhoPath = Paths.get("log.csv");
        
        if (!Files.exists(caminhoPath)) {
            try {
                Files.createFile(caminhoPath);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
