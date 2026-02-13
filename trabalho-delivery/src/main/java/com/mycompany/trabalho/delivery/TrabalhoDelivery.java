package com.mycompany.trabalho.delivery;

import com.mycompany.trabalho.delivery.dominio.adapter.ConsoleLogAdapter;
import com.mycompany.trabalho.delivery.dominio.model.bebida.Bebida;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoBuilder;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.dominio.model.pizza.*;
import com.mycompany.trabalho.delivery.infraestrutura.logger.Logger;
import com.mycompany.trabalho.delivery.infraestrutura.logger.CSVMetodo;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoDelivery {

    public static void main(String[] args) {
        
        Logger.getInstancia().configurar(new CSVMetodo(';'));

        ILogService logger = new ConsoleLogAdapter(); 
        
        logger.info("INICIANDO TESTE DE LOG EM ARQUIVO...");

        Bebida coca = new Bebida("Coca-cola, latinha 350ml", 7.0);
        
        PizzaioloDiretor diretor = new PizzaioloDiretor();
        PizzaComponente calabresa = diretor.build(new CalabresaBuilder());
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(calabresa);
        listaItens.add(coca);

        PedidoBuilder builder = new PedidoBuilder(listaItens, logger);
        Pedido meuPedido = builder.getPedido();

        System.out.println("\n--- EXECUTANDO AÇÕES DE STATUS ---");
        
        logger.info("Alterando status do pedido para Preparando...");
        meuPedido.avancarStatus(); 
        
        logger.info("Alterando status do pedido para Pronto...");
        meuPedido.avancarStatus();

        System.out.println("----------------------------------\n");

        System.out.println("Resumo do Pedido:");
        System.out.println("Itens: " + listaItens.size());
        System.out.println("Descrição: " + calabresa.toString());
        System.out.println("Valor Total: R$ " + (calabresa.getPreco() + coca.getPreco()));
        
        logger.info("Teste finalizado com sucesso.");
    }
}