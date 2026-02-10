package com.mycompany.trabalho.delivery.model;

import java.util.List;

/**
 *
 * @author lucas.lopes
 */
public class Pedido {
    private Cliente cliente;
    private List<Produto> itens;
    private IPedidoStatus estado;
    private double valorTotal;

    public Pedido(Cliente cliente, List<Produto> itens, IPedidoStatus estado) {
        this.cliente = cliente;
        this.itens = itens;
        this.estado = estado;
        
        calcularTotal(); // sobreescreve this.valorTotal
    }
    
    public void avancarStatus() {
        estado.proximo(this);
    }
    
    public void cancelar() {
        estado.cancelar(this);
    }
    
    public void setEstado(IPedidoStatus novoEstado) {
        this.estado = novoEstado;
    }
    
    private void calcularTotal() {
        valorTotal = 0;
        
        for(Produto item : itens) {
            valorTotal += item.getValor();
        }
    }
}
