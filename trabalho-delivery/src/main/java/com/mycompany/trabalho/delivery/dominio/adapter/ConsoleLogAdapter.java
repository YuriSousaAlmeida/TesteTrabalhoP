/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.adapter;

/**
 *
 * @author igor2
 */
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.infraestrutura.logger.Logger; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogAdapter implements ILogService {

    @Override
    public void info(String mensagem) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String logFormatado = "[INFO " + dtf.format(LocalDateTime.now()) + "]: " + mensagem;
        
        // 1. Grava no arquivo via infraestrutura
        Logger.getInstancia().registrar(logFormatado);
        
        // 2. Mantém a exibição no console (opcional)
        System.out.println(logFormatado);
    }

    @Override
    public void erro(String mensagem) {
        String logErro = "[ERRO]: " + mensagem;
        
        // 1. Grava no arquivo via infraestrutura
        Logger.getInstancia().registrar(logErro);
        
        // 2. Mantém a exibição no erro do sistema
        System.err.println(logErro);
    }
}
