/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author erko
 */
public class Pedido {
    private Long id;
    private Cliente cliente;
    private final List<ItemPedido> itens;
    private IPedidoStatus estado;
    private double valorTotal;

    // Construtor package-private para o Builder
    Pedido() {
        this.itens = new ArrayList<>();
        this.estado = new PedidoPendente();
    }

    public void avancarStatus() {
        estado.proximo(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    /**
     * Alterado para package-private. 
     * Apenas as classes de Estado no mesmo pacote podem alterar o estado.
     */
    void setEstado(IPedidoStatus novoEstado) {
        this.estado = novoEstado;
    }

    private void calcularTotal() {
        this.valorTotal = itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    // Getters protegidos
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itens); }
    public String getStatusDescricao() { return estado.getDescricao(); }
    public double getValorTotal() { return valorTotal; }
    
    /**
     * Atribuição de ID protegida (Package-private).
     * O mundo externo não pode alterar o ID da entidade arbitrariamente.
     */
    void setId(Long id) { 
        if (this.id != null) throw new IllegalStateException("ID já atribuído.");
        this.id = id; 
    }

    /**
     * Builder estático refatorado para ser Stateless e Thread-safe.
     */
    public static class Builder {
        private Cliente cliente;
        private final List<ItemPedido> itens = new ArrayList<>();

        public Builder paraCliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder comItem(Produto produto, int quantidade) {
            this.itens.add(new ItemPedido(produto, quantidade));
            return this;
        }

        public Pedido build() {
            if (this.cliente == null) throw new IllegalStateException("Cliente é obrigatório.");
            if (this.itens.isEmpty()) throw new IllegalStateException("O pedido deve ter pelo menos um item.");
            
            Pedido novoPedido = new Pedido();
            novoPedido.cliente = this.cliente;
            novoPedido.itens.addAll(this.itens);
            novoPedido.calcularTotal();
            return novoPedido;
        }
    }
}