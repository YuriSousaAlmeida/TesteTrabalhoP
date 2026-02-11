package com.mycompany.trabalho.delivery.model;

/**
 *
 * @author lucas.lopes
 */
public class PizzaMussarelaDecorator extends PizzaIngredienteDecorator {
    
    public PizzaMussarelaDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public double getValor() {
        return 5 + super.getValor();
    }
    
    @Override
    public String toString() {
        return " + mussarela";
    }
}
