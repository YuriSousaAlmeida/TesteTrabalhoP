/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.dto;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.pedido.IPedidoState;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;
import java.util.List;

/**
 *
 * @author Selmo
 */
public class PedidoOutputDTO {
    private Cliente cliente;
    private List<Item> itens;
    private IPedidoState estado;
    private double valorTotal;
    private long id;

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }
    
    public IPedidoState getEstado() {
        return estado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public long getId() {
        return id;
    }
}
