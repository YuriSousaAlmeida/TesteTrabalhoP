/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;

/**
 *
 * @author Selmo
 */
public class AvancarEstadoPedidoUseCase implements IAvancarEstadoPedidoUseCase {
    private IPedidoRepository repositorio;
    public AvancarEstadoPedidoUseCase(IPedidoRepository repositorio){
        this.repositorio = repositorio;
    }
    
    public void executar(int idPedido){
        Pedido pedido = repositorio.buscarPedidoPorId(idPedido);
        pedido.avancarEstado();
        repositorio.salvarPedido(pedido);
    }
}
