package com.mycompany.trabalho.delivery;

import com.mycompany.trabalho.delivery.aplicacao.useCases.AvancarEstadoPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.BuscarTodosOsClientesUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CadastrarClienteUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CancelarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CriarPedidoUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.DeletarClienteUseCase;
import com.mycompany.trabalho.delivery.dominio.adapter.ConsoleLogAdapter;
import com.mycompany.trabalho.delivery.dominio.model.bebida.Bebida;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.model.pedido.PedidoBuilder;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.dominio.model.pizza.*;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;
import com.mycompany.trabalho.delivery.infraestrutura.logger.Logger;
import com.mycompany.trabalho.delivery.infraestrutura.logger.CSVMetodo;
import com.mycompany.trabalho.delivery.infraestrutura.repositories.ClienteRepositorySQLite;
import com.mycompany.trabalho.delivery.presentation.controllers.ClienteController;
import com.mycompany.trabalho.delivery.presentation.ui.ClienteView;
import com.mycompany.trabalho.delivery.infraestrutura.DbInitializer;
import com.mycompany.trabalho.delivery.infraestrutura.repositories.ArquivoJsonPreco;
import com.mycompany.trabalho.delivery.infraestrutura.repositories.PedidoRepositorySQLite;
import com.mycompany.trabalho.delivery.presentation.Presenter.ClientePresenter;
import com.mycompany.trabalho.delivery.presentation.Presenter.PedidosPresenter;
import com.mycompany.trabalho.delivery.presentation.controllers.PedidosController;
import com.mycompany.trabalho.delivery.presentation.services.NavegadorDeViews;
import com.mycompany.trabalho.delivery.presentation.ui.PedidosView;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoDelivery {

    public static void main(String[] args) {
        DbInitializer.inicializar();
        
        IClienteRepository clienteRepo = new ClienteRepositorySQLite(); 
        IPedidoRepository pedidoRepo = new PedidoRepositorySQLite();
        ILogService logService = new ConsoleLogAdapter();
        IProvedorDePrecos provedor = new ArquivoJsonPreco();
        IPizzaFactory pizzaFactory = new PizzaFactory(provedor);
       
        NavegadorDeViews navegador = new NavegadorDeViews(clienteRepo, pedidoRepo, logService, provedor, pizzaFactory);

        
        navegador.abrirClienteView();
//                
//        //declaração da view, controler e presenter de Clientes
//        IClienteRepository repositorioClientes = new ClienteRepositorySQLite(); 
//        CadastrarClienteUseCase cadastrarClienteUseCase = new CadastrarClienteUseCase(repositorioClientes);
// 
//        
//	
//        BuscarTodosOsClientesUseCase buscarClientes = new BuscarTodosOsClientesUseCase(repositorioClientes);
//        DeletarClienteUseCase deletarClientes = new DeletarClienteUseCase(repositorioClientes);
//        ClienteController controllerClintes = new ClienteController(cadastrarClienteUseCase, deletarClientes);
//        ClientePresenter presenterClientes = new ClientePresenter(buscarClientes);
//        
////        ClienteView viewCliente = new ClienteView(controllerClintes, presenterClientes);
//        
//        
//        //declaração da view, controler e presenter de Pedidos
//        IPedidoRepository repositorioPedidos= new PedidoRepositorySQLite();
//        
//        AvancarEstadoPedidoUseCase avancarEstado = new AvancarEstadoPedidoUseCase(repositorioPedidos);
//        
//        CancelarPedidoUseCase cancelarPedido = new CancelarPedidoUseCase(repositorioPedidos);
//        PedidosPresenter pedidosPresenter = new PedidosPresenter(repositorioPedidos);
//        CriarPedidoUseCase criarPedidos = new CriarPedidoUseCase(repositorioPedidos, repositorioClientes); //TODO verificar parametrização de logger depois, removi para fins de teste
//        
//        PedidosController pedidosControler = new PedidosController(avancarEstado, cancelarPedido, criarPedidos);
//                //avancarEstado, cancelarPedido);
////        PedidosView pedidosView = new PedidosView(viewCliente,pedidosControler,pedidosPresenter);
//        
//             //declaração de gerenciador de views
////        NavegadorDeViews gerenciadorDeViews = new NavegadorDeViews();  //TODO IMPORTANTE mudar construtor, esse é para testes, sem log
//        
//        
//        
//        

        
        
      
        
//        Logger.getInstancia().configurar(new CSVMetodo(';'));
//
//        ILogService logger = new ConsoleLogAdapter(); 
//        
//        logger.info("INICIANDO TESTE DE LOG EM ARQUIVO...");
//
//        Bebida coca = new Bebida("Coca-cola, latinha 350ml", 7.0);
//        
//        PizzaioloDiretor diretor = new PizzaioloDiretor();
//        PizzaComponente calabresa = diretor.build(new CalabresaBuilder());
//        List<Item> listaItens = new ArrayList<>();
//        listaItens.add(calabresa);
//        listaItens.add(coca);
//
//        PedidoBuilder builder = new PedidoBuilder(listaItens, logger);
//        Pedido meuPedido = builder.getPedido();
//
//        System.out.println("\n--- EXECUTANDO AÇÕES DE STATUS ---");
//        
//        logger.info("Alterando status do pedido para Preparando...");
//        meuPedido.avancarStatus(); 
//        
//        logger.info("Alterando status do pedido para Pronto...");
//        meuPedido.avancarStatus();
//
//        System.out.println("----------------------------------\n");
//
//        System.out.println("Resumo do Pedido:");
//        System.out.println("Itens: " + listaItens.size());
//        System.out.println("Descrição: " + calabresa.toString());
//        System.out.println("Valor Total: R$ " + (calabresa.getPreco() + coca.getPreco()));
//        
//        logger.info("Teste finalizado com sucesso.");
    }
}