package com.mycompany.trabalho.delivery.dominio.model.pedido;

import dominio.model.cliente.Cliente;
import dominio.model.pedido.Item;
import java.util.List;

/**
 *
 * @author lucas.lopes
 */
public class Pedido {
    private Cliente cliente;
    private List<Item> itens;
    private IPedidoState estado;
    private double valorTotal;

    public Pedido(Cliente cliente, List<Item> itens, IPedidoState estado) {
        this.cliente = cliente;
       this.itens = itens;
        this.estado = estado;
        
        calcularTotal(); // sobrescreve this.valorTotal
    }
    
    public void avancarStatus() {
        estado.proximo(this);
    }
    
    public void cancelar() {
        estado.cancelar(this);
    }
    
    public void setEstado(IPedidoState novoEstado) {
        this.estado = novoEstado;
    }
    
    private void calcularTotal() {
        valorTotal = 0;
        
        for(Item item : itens) {
            valorTotal += item.getValor();
        }
    }
}
