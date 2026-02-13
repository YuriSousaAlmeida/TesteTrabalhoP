/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import java.util.List;

/**
 *
 * @author André
 */
public class BuscarTodosOsClientesUseCase {
    private final IClienteRepository repositorio;

    public BuscarTodosOsClientesUseCase(IClienteRepository repositorio) {
        this.repositorio = repositorio;
    }
    public List<Cliente> executar() {
        List<Cliente> lista = repositorio.buscarTodos();
        return lista; 
    }
}
