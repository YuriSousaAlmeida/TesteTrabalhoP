package com.mycompany.trabalho.delivery.presentation.controllers;

import com.mycompany.trabalho.delivery.aplicacao.useCases.AvancarEstadoPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CancelarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CriarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.ICancelarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.IAvancarEstadoPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.IBuscarPedidosPorCpfUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.ICriarPedidoUseCase;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import com.mycompany.trabalho.delivery.infraestrutura.logger.Logger;
import com.mycompany.trabalho.delivery.infraestrutura.repositories.ClienteRepositorySQLite;
import com.mycompany.trabalho.delivery.infraestrutura.repositories.PedidoRepositorySQLite;

/**
 *
 * @author lucas.lopes
 */
public class PedidosController{
    private final IAvancarEstadoPedidoUseCase avancarEstado;
    private final ICancelarPedidoUseCase cancelarPedido;
    private final ICriarPedidoUseCase criarPedido;

    
//    private final IPedidoRepository repositorio;
//    private final IClienteRepository cRepositorio;
//    private final ILogService logger;

    public PedidosController(IAvancarEstadoPedidoUseCase avancarEstado, 
                                ICancelarPedidoUseCase cancelarPedido,
                                ICriarPedidoUseCase criarPedido) {
        this.avancarEstado = avancarEstado;
        this.cancelarPedido = cancelarPedido;
        
        this.criarPedido = criarPedido;
        
        
    }

//    public PedidosController() {
//        this.repositorio = new PedidoRepositorySQLite();
//        this.avancarEstado = new AvancarEstadoPedidoUseCase(repositorio );
//        this.cancelarPedido = new CancelarPedidoUseCase(repositorio);
//        this.cRepositorio = new ClienteRepositorySQLite();
//        this.logger = new 
//       
//    }
    
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
