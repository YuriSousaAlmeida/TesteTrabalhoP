/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoProntoState;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;

/**
 *
 * @author André
 */
public class ProntificarPedidoUseCase {
    private final IPedidoRepository repositorio;

    public ProntificarPedidoUseCase(IPedidoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void executar(int idPedido) {
        
        Pedido pedido = repositorio.buscarPedidoPorId(idPedido);
        pedido.setEstado( new PedidoProntoState()); 

        repositorio.salvarPedido(pedido);
        
        System.out.println("Pedido " + idPedido + " ficou pronto.");
    }
}
