package com.mycompany.trabalho.delivery;

import com.mycompany.trabalho.delivery.dominio.adapter.ConsoleLogAdapter;
import com.mycompany.trabalho.delivery.dominio.model.bebida.CocaCola;
import com.mycompany.trabalho.delivery.dominio.model.bebida.CocaColaTamanhoPequenoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoBuilder;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.dominio.model.pizza.*;
import com.mycompany.trabalho.delivery.dominio.model.pizza.decorators.*;
import com.mycompany.trabalho.delivery.infraestrutura.logger.Logger;
import com.mycompany.trabalho.delivery.infraestrutura.logger.CSVMetodo;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoDelivery {

    public static void main(String[] args) {
        
        Logger.getInstancia().configurar(new CSVMetodo(';'));

        ILogService logger = new ConsoleLogAdapter(); 
        
        logger.info("INICIANDO TESTE DE LOG EM ARQUIVO...");

        ITamanhoStrategy tamanhoPizza = new PizzaTamanhoMedioStrategy();
        Pizza pizza = new BasePizza(tamanhoPizza); 
        //pizza = new CalabresaDecorator(pizza);  
        //pizza = new MussarelaDecorator(pizza);

        ITamanhoStrategy tamanhoCoca = new CocaColaTamanhoPequenoStrategy();
        CocaCola coca = new CocaCola(tamanhoCoca);
        
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(pizza);
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
        System.out.println("Descrição Pizza: " + pizza.toString());
        System.out.println("Valor Total: R$ " + (pizza.getValor() + coca.getValor()));
        
        logger.info("Teste finalizado com sucesso.");
    }
}