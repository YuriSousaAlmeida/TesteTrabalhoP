/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/

package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.ICadastrarClienteUseCase;
import com.mycompany.trabalho.delivery.presentation.ui.ClienteView;
import com.mycompany.trabalho.delivery.aplicacao.useCases.IDeletarClienteUseCase;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;


public class ClienteController {

    private final ICadastrarClienteUseCase cadastrarCliente;
    private final IDeletarClienteUseCase deletarCliente;

    public ClienteController(
            ICadastrarClienteUseCase cadastrarCliente,
            IDeletarClienteUseCase deletarCliente
    ) {
        this.cadastrarCliente = cadastrarCliente;
        this.deletarCliente = deletarCliente;
    }

    public Optional<CreateClienteOutputDTO> salvar(CreateClienteInputDTO dados) {
        try {
            return cadastrarCliente.executar(dados);
        } catch (Exception e) {
            return Optional.empty(); 
        }
    }
    
    public void deletarCliente(String cpf){
        deletarCliente.executar(cpf);
    }
    
}