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
    private String cpf;
    private List<Item> itens;
    private IPedidoState estado;
    private double valorTotal;
    private long id;

    public String getCpf() {
        return cpf;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setEstado(IPedidoState estado) {
        this.estado = estado;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setId(long id) {
        this.id = id;
    }
}
