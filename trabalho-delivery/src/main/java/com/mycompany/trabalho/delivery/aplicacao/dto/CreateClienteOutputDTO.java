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
    public String nome;
    public String email;
    public String cpf;
    public String cidade;
    public String bairro;
    public String rua;
    public String numero;

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