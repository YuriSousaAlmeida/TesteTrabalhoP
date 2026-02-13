/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;

/**
 *
 * @author André
 */
public abstract class PizzaComponente implements Item{
    protected String descricao;
    
    public PizzaComponente(String descricao) {
        this.descricao = descricao;
    }

    public abstract String getDescricao();
    public abstract double getPreco();
    public abstract PizzaComponente desfazer();

    @Override
    public String toString() {
        return "Pizza: " + getDescricao()
             + "\nPreço Total: R$ " + String.format("%.2f", getPreco());
    }
}

