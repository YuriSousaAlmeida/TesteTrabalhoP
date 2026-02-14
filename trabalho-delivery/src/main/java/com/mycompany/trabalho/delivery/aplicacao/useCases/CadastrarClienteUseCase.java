/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.shared.Endereco;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import java.util.Optional;

/**
 *
 * @author André
 */
public class CadastrarClienteUseCase implements ICadastrarClienteUseCase{
    private final IClienteRepository repositorio;

    public CadastrarClienteUseCase(IClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Optional<CreateClienteOutputDTO> executar(CreateClienteInputDTO dto) {
        Endereco endereco = new Endereco(dto.getCidade(), dto.getBairro(), dto.getRua(), dto.getNumero());
        Cliente cliente = new Cliente(dto.getNome(), dto.getCpf(), dto.getEmail(), endereco);
      
       
        BuscarClientePorCpfUseCase verificar = new BuscarClientePorCpfUseCase(repositorio);
        
        if (verificar.executar(cliente.getCpf()) != null) {
            throw new RuntimeException("O Cliente já existe!");
        }
        Cliente clienteSalvo = repositorio.salvarCliente(cliente);
        System.out.println("Cliente " + clienteSalvo.getNome() + " foi cadastrado com sucesso.");
        
        CreateClienteOutputDTO result = new CreateClienteOutputDTO();
        result.toMapByInputDto(clienteSalvo);
        return Optional.of(result);
    }
}
