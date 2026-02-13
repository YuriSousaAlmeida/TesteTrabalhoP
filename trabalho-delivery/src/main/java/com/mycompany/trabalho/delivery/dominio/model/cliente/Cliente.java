package com.mycompany.trabalho.delivery.dominio.model.cliente;

import com.mycompany.trabalho.delivery.dominio.model.shared.Endereco;

/**
 *
 * @author lucas.lopes
 */
public class Cliente {
    private String nome;
    private String email;
    private Endereco endereco;
    private String cpf;
    
    public Cliente(String nome,String cpf, String email, Endereco endereco){
        // lidando com casos de erro
        if(nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        if(email == null) throw new IllegalArgumentException("Email não pode ser nulo.");
        if(endereco == null) throw new IllegalArgumentException("Endereço não pode ser nulo.");
        if(cpf == null) throw new IllegalArgumentException("CPF não pode ser nulo.");
        
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    
    public String getCidade() {
        return endereco.getCidade();
    }

    public String getBairro() {
        return endereco.getBairro();
    }

    public String getRua() {
        return endereco.getRua();
    }

    public String getNumero() {
        return endereco.getNumero();
    }

    public String getEmail() {
        return email;
    }
    
}
