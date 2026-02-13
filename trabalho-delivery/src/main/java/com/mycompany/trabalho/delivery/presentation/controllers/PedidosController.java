package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.useCases.CancelarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.EntregarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.PrepararPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.ProntificarPedidoUseCase;

/**
 *
 * @author lucas.lopes
 */
public class PedidosController {
    private final EntregarPedidoUseCase entregarPedido;
    private final PrepararPedidoUseCase prepararPedido;
    private final ProntificarPedidoUseCase prontificarPedido;
    private final CancelarPedidoUseCase cancelarPedido;

    public PedidosController(EntregarPedidoUseCase entregarPedido, PrepararPedidoUseCase prepararPedido, ProntificarPedidoUseCase prontificarPedido, CancelarPedidoUseCase cancelarPedido) {
        this.entregarPedido = entregarPedido;
        this.prepararPedido = prepararPedido;
        this.prontificarPedido = prontificarPedido;
        this.cancelarPedido = cancelarPedido;
    }
    
    public void prepararPedido(int idPedido) {
        prepararPedido.executar(idPedido);
    }
    
    public void prontificarPedido(int idPedido) {
        prontificarPedido.executar(idPedido);
    }
    
    public void entregarPedido(int idPedido) {
        entregarPedido.executar(idPedido);
    }
    
    public void cancelarPedido(int idPedido) {
        cancelarPedido.executar(idPedido);
    }
}
