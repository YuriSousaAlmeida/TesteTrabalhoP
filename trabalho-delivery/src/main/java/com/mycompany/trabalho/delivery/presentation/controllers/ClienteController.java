/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/

package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.BuscarTodosOsClientesUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CadastrarClienteUseCase;
import com.mycompany.trabalho.delivery.presentation.ui.ClienteView;
import com.mycompany.trabalho.delivery.aplicacao.useCases.DeletarClienteUseCase;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;


public class ClienteController {

    private final CadastrarClienteUseCase cadastrarCliente;
    private final BuscarTodosOsClientesUseCase listarClientes;
    private final DeletarClienteUseCase deletarCliente;

    public ClienteController(
            CadastrarClienteUseCase cadastrarCliente,
            BuscarTodosOsClientesUseCase listarClientes,
            DeletarClienteUseCase deletarCliente
    ) {
        this.cadastrarCliente = cadastrarCliente;
        this.listarClientes = listarClientes;
        this.deletarCliente = deletarCliente;
    }

    public Optional<CreateClienteOutputDTO> salvar(CreateClienteInputDTO dados) {
        try {
            return cadastrarCliente.executar(dados);
        } catch (Exception e) {
            return Optional.empty(); 
        }
    }

    public List<CreateClienteOutputDTO> listarTodos() {
        return listarClientes.executar();
    }
    
    public void deletarCliente(String cpf){
        deletarCliente.executar(cpf);
    }
    
}