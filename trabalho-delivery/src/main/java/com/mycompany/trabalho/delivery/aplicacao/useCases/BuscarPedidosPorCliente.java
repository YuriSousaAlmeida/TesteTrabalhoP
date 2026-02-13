package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import java.util.List;

/**
 *
 * @author lucas.lopes
 */
public class BuscarPedidosPorCliente {
    private final IPedidoRepository repositorio;
    
    public BuscarPedidosPorCliente(IPedidoRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    public List<Pedido> executar(String cpf) {
        return repositorio.buscarPedidosPorCpf(cpf);
    }
}
