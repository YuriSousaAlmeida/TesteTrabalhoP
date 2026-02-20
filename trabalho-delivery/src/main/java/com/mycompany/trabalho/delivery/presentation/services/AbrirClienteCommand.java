/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.presentation.services;

import com.mycompany.trabalho.delivery.aplicacao.useCases.BuscarTodosOsClientesUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.CadastrarClienteUseCase;
import com.mycompany.trabalho.delivery.aplicacao.useCases.DeletarClienteUseCase;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.presentation.Presenter.ClientePresenter;
import com.mycompany.trabalho.delivery.presentation.controllers.ClienteController;
import com.mycompany.trabalho.delivery.presentation.ui.ClienteView;

/**
 *
 * @author erko
 */
public class AbrirClienteCommand implements INavegacaoCommand{
    private final IClienteRepository clienteRepo;
    private final ILogService logService;
    private final NavegadorDeViews navegador;
    
    
    public AbrirClienteCommand(IClienteRepository clienteRepo, ILogService logService, NavegadorDeViews navegador) {
        this.clienteRepo = clienteRepo;
        this.logService = logService;
        this.navegador = navegador;
        
        
        
    }
    
    
    @Override
    public void executar() {
        //instanciação dos Use Cases (Application Layer)
        BuscarTodosOsClientesUseCase buscarTodosUC = new BuscarTodosOsClientesUseCase(clienteRepo);
        
        
        CadastrarClienteUseCase cadastrarUC = new CadastrarClienteUseCase(clienteRepo);
        DeletarClienteUseCase deletarUC = new DeletarClienteUseCase(clienteRepo);

        //instanciação do Controller e Presenter (camada presenter)
        
        ClienteController controller = new ClienteController(cadastrarUC, deletarUC);
        
        //clientePresenter espera IBuscarTodosOsClientesUseCase
        ClientePresenter presenter = new ClientePresenter(buscarTodosUC);
               

        //injeção na View e exibição (Camada UI )
        ClienteView view = new ClienteView(controller, presenter, navegador);
        view.setVisible(true);
    }
}
