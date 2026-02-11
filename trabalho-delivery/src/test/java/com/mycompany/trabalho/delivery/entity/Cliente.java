/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.entity;

/**
 *
 * @author erko
 */
public record Cliente (Long id, String nome, String email, String endereco){
    
    public Cliente {
        if (email == null || (!email.contains("@" ) && !email.contains(".com" ))) {
            throw new IllegalArgumentException("E-mail inválido!");
            
            
        }
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID deve ser um número positivo.");
        }

        // Validação do Nome
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        
        // Validação do Endereço
        if (endereco == null || endereco.length() < 5) {
            throw new IllegalArgumentException("Endereço muito curto ou inválido.");
        }
    }
    
}
