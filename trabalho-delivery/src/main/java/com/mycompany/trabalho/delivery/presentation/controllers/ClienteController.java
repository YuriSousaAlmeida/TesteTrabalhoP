/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/

package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.BuscarTodosOsClientesUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CadastrarClienteUseCase;
import com.mycompany.trabalho.delivery.presentation.ui.ClienteView;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;


public class ClienteController {

    private final CadastrarClienteUseCase cadastrarCliente;
    private final BuscarTodosOsClientesUseCase listarClientes;

    public ClienteController(
            CadastrarClienteUseCase cadastrarCliente,
            BuscarTodosOsClientesUseCase listarClientes
    ) {
        this.cadastrarCliente = cadastrarCliente;
        this.listarClientes = listarClientes;
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
}