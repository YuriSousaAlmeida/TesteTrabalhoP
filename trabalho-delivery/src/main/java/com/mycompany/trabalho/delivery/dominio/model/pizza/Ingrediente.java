/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public class Ingrediente extends IngredienteDecorator {
    
    private double precoIngrediente;

    public Ingrediente(PizzaComponente elementoDecorado, String descricao, double precoIngrediente) {
        super(elementoDecorado, descricao);
        this.precoIngrediente = precoIngrediente;
    }

    @Override
    public String getDescricao() {
        return this.elementoDecorado.getDescricao() + ", " + descricao;
    }

    @Override
    public double getPreco() {
        return this.elementoDecorado.getPreco() + this.precoIngrediente;
    }

    @Override
    public PizzaComponente desfazer() {
        return elementoDecorado;
    }
}
