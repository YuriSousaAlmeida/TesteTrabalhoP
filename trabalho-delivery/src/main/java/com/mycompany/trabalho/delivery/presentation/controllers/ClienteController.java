/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.dto.ClienteDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CadastrarCliente;
import javax.swing.JOptionPane;

public class ClienteController {
    
    private final CadastrarCliente cadastrarCliente;

    public ClienteController(CadastrarCliente cadastrar) {
        this.cadastrarCliente = cadastrar;
    }

    
    public void salvar(ClienteDTO dados) {
        try {
            cadastrarCliente.executar(dados);
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
}