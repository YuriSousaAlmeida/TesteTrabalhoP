/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoBebidaInputDTO;
import com.mycompany.trabalho.delivery.dominio.adapter.ConsoleLogAdapter;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoPendenteState;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoPizzaInputDTO;
import com.mycompany.trabalho.delivery.dominio.model.bebida.Bebida;
import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pizza.CalabresaBuilder;
import com.mycompany.trabalho.delivery.dominio.model.pizza.FrangoCatupiryBuilder;
import com.mycompany.trabalho.delivery.dominio.model.pizza.ModaDaCasaBuilder;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaBuilder;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaComponente;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PortuguesaBuilder;
import com.mycompany.trabalho.delivery.dominio.model.pizza.QuatroQueijosBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author André
 */
public class MontarPedidoUseCase {
    private final IPedidoRepository repositorioPedidos;
    private final IClienteRepository repositorioClientes;
    

    public MontarPedidoUseCase(IPedidoRepository repositorioPedidos, IClienteRepository repositorioClientes) {
       this.repositorioPedidos = repositorioPedidos;
       this.repositorioClientes = repositorioClientes;
    }
    
    public void executar(String cpf, List<ItemPedidoPizzaInputDTO> itensPizzas, List<ItemPedidoBebidaInputDTO> itensBebidas) {
        // TO DO verificar essa instancia concreta de ConsoleLogAdapter()
        //  verificar se pedido nao precisa ter um identificador e como fazer isso
        Cliente cliente = repositorioClientes.buscarClientePorCPF(cpf);
            if(cliente == null){
                repositorioClientes.salvarCliente(cliente);
            }
        
        List<Item> itensModelo = new ArrayList<>();
        
        Map<String, PizzaBuilder> mapaSabores = new HashMap<>();
        mapaSabores.put("calabresa", new CalabresaBuilder());
        mapaSabores.put("frangocatupiry", new FrangoCatupiryBuilder());
        mapaSabores.put("modadacasa", new ModaDaCasaBuilder());
        mapaSabores.put("portuguesa", new PortuguesaBuilder());
        mapaSabores.put("quatroqueijos", new QuatroQueijosBuilder());
        
        for(ItemPedidoPizzaInputDTO itemPizza : itensPizzas) {
            PizzaBuilder builder = mapaSabores.get(itemPizza.sabor);
            builder.prepararMassa();
            builder.adicionarMolho();
            builder.adicionarCobertura();
            PizzaComponente pizza = builder.getPizza();
            
            itensModelo.add(pizza);
        }
        
        for(ItemPedidoBebidaInputDTO itemBebida : itensBebidas) {
            Bebida bebida = new Bebida(itemBebida.nome, itemBebida.preco);
            
            itensModelo.add(bebida);
        }
            
        Pedido pedido = new Pedido(new ConsoleLogAdapter(), repositorioClientes.buscarClientePorCPF(cpf), itensModelo, new PedidoPendenteState());
        repositorioPedidos.salvarPedido(pedido);
        
        System.out.println("Pedido " + pedido + " foi criado com sucesso.");
    }
}
