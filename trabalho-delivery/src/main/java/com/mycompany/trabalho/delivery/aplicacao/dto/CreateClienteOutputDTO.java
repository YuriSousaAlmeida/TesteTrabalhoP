/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.dto;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;

/**
 *
 * @author André
 */
public class CreateClienteOutputDTO {
    private String nome;
    private String email;
    private String cpf;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public CreateClienteOutputDTO() {}
    
    public void toMapByInputDto(Cliente input){
        this.nome = input.getNome();
        this.email = input.getEmail();
        this.cpf = input.getCpf();
        this.cidade = input.getCidade();
        this.bairro = input.getBairro();
        this.rua = input.getRua();
        this.numero = input.getNumero();
    }
    
    public String getEnderecoFormatado() {
        return this.rua + ", " + this.numero + " - " + this.bairro + " - " + this.cidade;
    }
}