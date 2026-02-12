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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogAdapter implements ILogService {
    @Override
    public void info(String mensagem) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("[INFO " + dtf.format(LocalDateTime.now()) + "]: " + mensagem);
    }

    @Override
    public void erro(String mensagem) {
        System.err.println("[ERRO]: " + mensagem);
    }
}