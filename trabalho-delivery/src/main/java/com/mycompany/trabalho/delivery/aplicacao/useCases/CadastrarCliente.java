/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;

/**
 *
 * @author André
 */
public class CadastrarCliente {
    private final IClienteRepository repositorio;

    public CadastrarCliente(IClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void executar(Cliente cliente) {
        repositorio.salvarCliente(cliente);
        
        System.out.println("Cliente " + cliente.getNome() + " foi cadastrado com sucesso.");
    }
}
