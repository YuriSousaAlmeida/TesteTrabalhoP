/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.presentation.Presenter;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.PedidoDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.PedidoOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.IBuscarPedidosPorCpfUseCase;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import java.util.List;

/**
 *
 * @author Selmo
 */
public class PedidosPresenter {
    private IPedidoRepository repositorio;
    private IBuscarPedidosPorCpfUseCase buscarPedidos;
    
    
    public PedidosPresenter(IPedidoRepository repositorio){  //TODO verificar sse esse construytor sem buscarPedidos é necessário
        this.repositorio = repositorio;
    }

    public PedidosPresenter(IPedidoRepository repositorio, IBuscarPedidosPorCpfUseCase buscarPedidos) {
        this.repositorio = repositorio;
        this.buscarPedidos = buscarPedidos;
    }
    
    
    public List<PedidoOutputDTO> mostrarPedidos(String cpf){
        return buscarPedidos.executar(cpf);
    
    }
    
    
}
