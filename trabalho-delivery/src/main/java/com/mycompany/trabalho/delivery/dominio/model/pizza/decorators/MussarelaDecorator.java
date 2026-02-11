package com.mycompany.trabalho.delivery.dominio.model.pizza.decorators;

import com.mycompany.trabalho.delivery.dominio.model.pizza.Pizza;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaIngredienteDecorator;

/**
 *
 * @author lucas.lopes
 */
public class MussarelaDecorator extends PizzaIngredienteDecorator {
    
    public MussarelaDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public double getValor() {
        return 5 + super.getValor();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", adicional de mussarela";
    }
}
