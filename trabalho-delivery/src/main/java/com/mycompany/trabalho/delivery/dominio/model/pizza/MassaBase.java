/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public class MassaBase extends PizzaComponente {
    
    private double precoBase;

    public MassaBase(String descricao, double precoBase) {
        super(descricao);
        this.precoBase = precoBase;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return precoBase;
    }

    @Override
    public PizzaComponente desfazer() {
        return this;
    }
}