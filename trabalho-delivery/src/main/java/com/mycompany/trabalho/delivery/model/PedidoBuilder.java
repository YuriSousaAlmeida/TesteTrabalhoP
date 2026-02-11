package com.mycompany.trabalho.delivery.model;

import java.util.List;

/**
 *
 * @author lucas.lopes
 */
public class PedidoBuilder {
    private Cliente cliente;
    private List<Item> itens;
    private Pedido pedido;
    
    public PedidoBuilder(List<Item> itens) {
        this.itens = itens;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public void removerItem(Item item) {
        itens.remove(item);
    }
    
    public void limparPedido() {
        itens.clear();
    }
    
    public Pedido getPedido() {
        return new Pedido(cliente, itens, new PedidoPendente());
    }
}
