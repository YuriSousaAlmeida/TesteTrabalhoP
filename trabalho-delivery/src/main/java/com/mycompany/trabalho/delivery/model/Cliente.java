package com.mycompany.trabalho.delivery.model;

/**
 *
 * @author lucas.lopes
 */
public class Cliente {
    private String nome;
    public String email;
    public Endereco endereco;
    
    public Cliente(String nome, String email, Endereco endereco) {
        // lidando com casos de erro
        if(nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        if(email == null) throw new IllegalArgumentException("Email não pode ser nulo.");
        if(endereco == null) throw new IllegalArgumentException("Endereço não pode ser nulo.");
        
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }
}
