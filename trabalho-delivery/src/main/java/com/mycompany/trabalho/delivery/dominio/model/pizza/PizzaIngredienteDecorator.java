package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author lucas.lopes
 */
public abstract class PizzaIngredienteDecorator implements Pizza {
    private Pizza pizza;
    
    public PizzaIngredienteDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public double getValor() {
        return pizza.getValor();
    }
}
