/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza.decorators;

import com.mycompany.trabalho.delivery.dominio.model.pizza.Pizza;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaIngredienteDecorator;

/**
 *
 * @author André
 */
public class BaconDecorator extends PizzaIngredienteDecorator {
    
    public BaconDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public double getValor() {
        return 10 + super.getValor();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", adional de bacon";
    }
}
