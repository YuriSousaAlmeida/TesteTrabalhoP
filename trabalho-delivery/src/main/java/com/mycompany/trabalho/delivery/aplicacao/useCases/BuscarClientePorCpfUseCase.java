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
public class BuscarClientePorCpfUseCase implements IBuscarClientePorCpfUseCase {
    private final IClienteRepository repositorio;

    public BuscarClientePorCpfUseCase(IClienteRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    public Cliente executar(String cpf) {
        Cliente cliente = repositorio.buscarClientePorCPF(cpf);
        return cliente; 
    }
}
