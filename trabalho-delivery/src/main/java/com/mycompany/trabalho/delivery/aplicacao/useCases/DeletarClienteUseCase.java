/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;

/**
 *
 * @author erko
 */
public class DeletarClienteUseCase {
    private final IClienteRepository repositorio;

    public DeletarClienteUseCase(IClienteRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    public void  executar(String cpf) {
        
       
        BuscarClientePorCpfUseCase verificar = new BuscarClientePorCpfUseCase(repositorio);
        
        
        if (verificar.executar(cpf) != null) {
            repositorio.deletarCliente(cpf);
            System.out.println("Cliente foi excluido com sucesso.");
        }
        else{
            System.out.println("Não tem esse cliente no banco");
        }
        
    }
    
}
