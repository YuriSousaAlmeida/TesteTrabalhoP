package com.mycompany.trabalho.delivery.dominio.model.bebida;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;

/**
 *
 * @author lucas.lopes
 */
public class Bebida implements Item {
    private String nome;
    private double preco;
    
    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
