/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoPreparadoState;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;

/**
 *
 * @author André
 */
public class PrepararPedidoUseCase {
    private final IPedidoRepository repositorio;

    public PrepararPedidoUseCase(IPedidoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void executar(int idPedido) {
        
        Pedido pedido = repositorio.buscarPedidoPorId(idPedido);
        pedido.setEstado( new PedidoPreparadoState()); 

        repositorio.salvarPedido(pedido);
        
        System.out.println("Pedido " + idPedido + " foi preparado com sucesso.");
    }
}
