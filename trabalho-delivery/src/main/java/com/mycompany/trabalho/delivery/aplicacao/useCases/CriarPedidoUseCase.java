/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoPreparadoState;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class CriarPedidoUseCase implements ICriarPedidoUseCase {
    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final ILogService logger; 

    public CriarPedidoUseCase(IPedidoRepository pedidoRepository, IClienteRepository clienteRepository , ILogService logger ) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.logger = logger;
    }

    public CriarPedidoUseCase(IPedidoRepository pedidoRepository, IClienteRepository clienteRepository) {//TODO construtor sem logger para fins de testes
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.logger= null; //TODO logger como nulo para testar, remover esse construtor depois
    }
    
    

    @Override
    public void executar(String cpf) {
        //recupera o cliente
        Cliente cliente = clienteRepository.buscarClientePorCPF(cpf);
        
        //cria a Pedido com lista de itens vazia e estado inicial "Preparando"

       Pedido novoPedido = new Pedido(cliente, new ArrayList<Item>(), new PedidoPreparadoState()); //TODO fiz um construtor sem logger para fins de testes, arrumar depois com os parametros comentados abaixo
//       (logger, cliente, new ArrayList<>(), new PedidoPreparadoState()); // isso são os parametro antigos com o logger, 
        
       //Cliente cliente, List<Item> itens, IPedidoState estado, double valorTotal, long id
       
        pedidoRepository.salvarPedido(novoPedido);
    }
}
