/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public abstract class IngredienteDecorator extends PizzaComponente {

    protected PizzaComponente elementoDecorado;

    public IngredienteDecorator(PizzaComponente elementoDecorado, String descricao) {
        super(descricao);
        this.elementoDecorado = elementoDecorado;
    }
}
