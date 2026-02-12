package com.mycompany.trabalho.delivery;

import com.mycompany.trabalho.delivery.dominio.adapter.ConsoleLogAdapter;
import com.mycompany.trabalho.delivery.dominio.model.bebida.CocaCola;
import com.mycompany.trabalho.delivery.dominio.model.bebida.CocaColaTamanhoPequenoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoBuilder;
import com.mycompany.trabalho.delivery.dominio.model.pizza.decorators.*;
import com.mycompany.trabalho.delivery.dominio.model.pizza.*;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author erko
 */
public class TrabalhoDelivery {

    public static void main(String[] args) {
        
        ILogService logger = new ConsoleLogAdapter();
        logger.info("Iniciando teste de fluxo de pedido com Clean Architecture...");

        ITamanhoStrategy tamanho = new PizzaTamanhoMedioStrategy();
        Pizza minhaPizza = new BasePizza(tamanho); 
        minhaPizza = new CalabresaDecorator(minhaPizza);  
        minhaPizza = new MussarelaDecorator(minhaPizza);

        ITamanhoStrategy tamanhoCoca = new CocaColaTamanhoPequenoStrategy();
        CocaCola coca = new CocaCola(tamanhoCoca);
        
        List<Item> listaItens = new ArrayList<>();
   
        PedidoBuilder builder = new PedidoBuilder(listaItens, logger);
        
        Pedido meuPedido = builder.getPedido();

        System.out.println("\n--- SAÍDA DO LOG ---");
        meuPedido.avancarStatus();
        System.out.println("--------------------\n");

        System.out.println("Descrição Pizza: " + minhaPizza.toString());
        System.out.println("Descrição Coca: " + coca.toString());
        System.out.println("Valor Final: " + (minhaPizza.getValor() + coca.getValor()));
    }
}