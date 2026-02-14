package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.useCases.IBuscarPedidosPorCliente;
import com.mycompany.trabalho.delivery.aplicacao.useCases.ICancelarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.IAvancarEstadoPedidoUseCase;

/**
 *
 * @author lucas.lopes
 */
public class PedidosController {
    private final IAvancarEstadoPedidoUseCase avancarEstado;
    private final ICancelarPedidoUseCase cancelarPedido;

    public PedidosController(IAvancarEstadoPedidoUseCase avancarEstado, ICancelarPedidoUseCase cancelarPedido) {
        this.avancarEstado = avancarEstado;
        this.cancelarPedido = cancelarPedido;
    }
    
    public void avancarEstado(int idPedido){
        avancarEstado.executar(idPedido);
    }
    
    public void cancelarPedido(int idPedido) {
        cancelarPedido.executar(idPedido);
    }
    
//    public List<PedidoDTO> listarPedidos(String cpf) {
//        List<Pedido> pedidos = buscarPedidos.executar(cpf);
//        List<PedidoDTO> pedidosDTO = new ArrayList<>();
//        
//        for(Pedido pedido : pedidos) {
//            PedidoDTO pedidoDTO = new PedidoDTO();
//            pedidoDTO.setIdPedido(pedido.getId()) ;
//            pedidoDTO.setStatus(pedido.getEstado().getDescricao());
//            
//            pedidosDTO.add(pedidoDTO);
//        }
//        
//        return pedidosDTO;
//    }
}
