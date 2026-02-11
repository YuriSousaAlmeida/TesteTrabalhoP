package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author lucas.lopes
 */
public class PizzaCalabresaDecorator extends PizzaIngredienteDecorator {
    
    public PizzaCalabresaDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public double getValor() {
        return 10 + super.getValor();
    }
    
    @Override
    public String toString() {
        return " + calabresa";
    }
}
