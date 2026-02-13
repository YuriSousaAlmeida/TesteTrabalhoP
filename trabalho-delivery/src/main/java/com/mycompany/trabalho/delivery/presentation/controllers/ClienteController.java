/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CadastrarClienteUseCase;
import java.util.Optional;
import javax.swing.JOptionPane;

public class ClienteController {
    
    private final CadastrarClienteUseCase cadastrarCliente;

    public ClienteController(CadastrarClienteUseCase cadastrar) {
        this.cadastrarCliente = cadastrar;
    }

    
    public Optional<CreateClienteOutputDTO> salvar(CreateClienteInputDTO dados) {
        try {
            return cadastrarCliente.executar(dados);
        } catch (Exception e) {
            //log
            return null;
        }
    }
    
    
}