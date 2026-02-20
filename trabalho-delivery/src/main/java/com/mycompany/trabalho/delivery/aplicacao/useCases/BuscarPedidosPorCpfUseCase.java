package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.PedidoOutputDTO;
import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import java.util.List;

/**
 *
 * @author lucas.lopes
 */
public class BuscarPedidosPorCpfUseCase implements IBuscarPedidosPorCpfUseCase {
    private final IPedidoRepository repositorio;
    
    public BuscarPedidosPorCpfUseCase(IPedidoRepository repositorio) {
        this.repositorio = repositorio;      
    }
    
    public List<PedidoOutputDTO> executar(String cpf) {

        
        
        List<Pedido> pedidosDoCliente = repositorio.buscarPedidosPorCpf(cpf);
        
        
        
      

        return pedidosDoCliente.stream().map(pedido -> {
            
            PedidoOutputDTO dto = new PedidoOutputDTO();
            dto.setCpf(cpf);
            dto.setItens(pedido.getItens());
            dto.setEstado(pedido.getEstado());
            dto.setValorTotal(pedido.getValorTotal());
            dto.setId(pedido.getId());
            

            return dto;

        }).toList();
        
    }
}
