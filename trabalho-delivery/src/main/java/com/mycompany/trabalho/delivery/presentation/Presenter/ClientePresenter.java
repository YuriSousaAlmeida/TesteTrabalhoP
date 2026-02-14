/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.presentation.Presenter;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.IBuscarTodosOsClientesUseCase;
import java.util.List;

/**
 *
 * @author Selmo
 */
public class ClientePresenter {
    private IBuscarTodosOsClientesUseCase listarClientes;
    
    public ClientePresenter(IBuscarTodosOsClientesUseCase listarClientes){
        this.listarClientes = listarClientes;
    }
    public List<CreateClienteOutputDTO> listarTodos() {
        return listarClientes.executar();
    }
}
