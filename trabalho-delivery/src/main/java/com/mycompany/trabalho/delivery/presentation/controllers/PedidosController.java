package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.dto.PedidoDTO;
import com.mycompany.trabalho.delivery.aplicacao.useCases.BuscarPedidosPorCliente;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CancelarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.EntregarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.PrepararPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.ProntificarPedidoUseCase;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.lopes
 */
public class PedidosController {
    private final EntregarPedidoUseCase entregarPedido;
    private final PrepararPedidoUseCase prepararPedido;
    private final ProntificarPedidoUseCase prontificarPedido;
    private final CancelarPedidoUseCase cancelarPedido;
    private final BuscarPedidosPorCliente buscarPedidos;

    public PedidosController(EntregarPedidoUseCase entregarPedido, PrepararPedidoUseCase prepararPedido, ProntificarPedidoUseCase prontificarPedido, CancelarPedidoUseCase cancelarPedido, BuscarPedidosPorCliente buscarPedidos) {
        this.entregarPedido = entregarPedido;
        this.prepararPedido = prepararPedido;
        this.prontificarPedido = prontificarPedido;
        this.cancelarPedido = cancelarPedido;
        this.buscarPedidos = buscarPedidos;
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
    
    public List<PedidoDTO> listarPedidos(String cpf) {
        List<Pedido> pedidos = buscarPedidos.executar(cpf);
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        
        for(Pedido pedido : pedidos) {
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.idPedido = pedido.getId();
            pedidoDTO.status = pedido.getEstado().getDescricao();
            
            pedidosDTO.add(pedidoDTO);
        }
        
        return pedidosDTO;
    }
}
