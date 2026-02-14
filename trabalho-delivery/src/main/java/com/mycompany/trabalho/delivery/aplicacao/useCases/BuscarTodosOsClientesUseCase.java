/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
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
    public List<CreateClienteOutputDTO> executar() {

        List<Cliente> clientes = repositorio.buscarTodos();

        return clientes.stream().map(cliente -> {

            CreateClienteOutputDTO dto = new CreateClienteOutputDTO();
            dto.setNome(cliente.getNome());
            dto.setEmail(cliente.getEmail());
            dto.setCidade(cliente.getCidade());
            dto.setBairro(cliente.getBairro());
            dto.setRua(cliente.getRua());
            dto.setNumero(cliente.getNumero());
            dto.setCpf(cliente.getCpf());

            return dto;

        }).toList();
    }
}
