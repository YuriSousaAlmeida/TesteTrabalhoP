/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.presentation.Presenter;

import com.mycompany.trabalho.delivery.aplicacao.dto.CreateClienteOutputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.PedidoDTO;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;
import java.util.List;

/**
 *
 * @author Selmo
 */
public class PedidosPresenter {
    private IPedidoRepository repositorio;
    
    public PedidosPresenter(IPedidoRepository repositorio){
        this.repositorio = repositorio;
    }
    //public List<PedidoDTO> mostrarPedidos(){}
}
