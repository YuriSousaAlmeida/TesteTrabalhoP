package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoBebidaInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoPizzaInputDTO;
import com.mycompany.trabalho.delivery.dominio.model.bebida.Bebida;
import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pizza.IPizzaFactory;
import com.mycompany.trabalho.delivery.dominio.model.pizza.Ingrediente;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaComponente;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;

import java.util.ArrayList;
import java.util.List;

public class MontarPedidoUseCase implements IMontarPedidoUseCase {
    
    private final IPedidoRepository repositorioPedidos;
    private final IClienteRepository repositorioClientes;
    private final IPizzaFactory pizzaFactory;
    private final IProvedorDePrecos provedorPrecos; // Adicionamos o provedor aqui

    // Atualize o construtor para receber o provedor de preços
    public MontarPedidoUseCase(IPedidoRepository repositorioPedidos, IClienteRepository repositorioClientes, IPizzaFactory pizzaFactory, IProvedorDePrecos provedorPrecos) {
        this.repositorioPedidos = repositorioPedidos;
        this.repositorioClientes = repositorioClientes;
        this.pizzaFactory = pizzaFactory;
        this.provedorPrecos = provedorPrecos;
    }

    @Override
    public void executar(String cpf, List<ItemPedidoPizzaInputDTO> itensPizzas, List<ItemPedidoBebidaInputDTO> itensBebidas) {
        
        Cliente cliente = repositorioClientes.buscarClientePorCPF(cpf);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        List<Item> itensModelo = new ArrayList<>();

       for (ItemPedidoPizzaInputDTO itemPizza : itensPizzas) {
            // 1. Cria a pizza base
            PizzaComponente pizza = pizzaFactory.criarPizza(itemPizza.getSabor());
            
            // 2. Aplica o padrão Decorator envolvendo a pizza com os ingredientes extras
            if (itemPizza.getAdicionais() != null) {
                for (String nomeAdicional : itemPizza.getAdicionais()) {
                    double precoAdicional = provedorPrecos.buscaPreco(nomeAdicional);
                    pizza = new Ingrediente(pizza, nomeAdicional, precoAdicional);
                }
            }
            
            itensModelo.add(pizza);
        }

        for (ItemPedidoBebidaInputDTO itemBebida : itensBebidas) {
            Bebida bebida = new Bebida(itemBebida.getNome(), itemBebida.getPreco());
            itensModelo.add(bebida);
        }
        
        Pedido pedido = new Pedido(cliente, itensModelo);
        repositorioPedidos.salvarPedido(pedido);
    }
}
