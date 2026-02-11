package com.mycompany.trabalho.delivery.dominio.model.pizza.decorators;

import com.mycompany.trabalho.delivery.dominio.model.pizza.Pizza;
import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaIngredienteDecorator;

/**
 *
 * @author lucas.lopes
 */
public class CalabresaDecorator extends PizzaIngredienteDecorator {
    
    public CalabresaDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public double getValor() {
        return 10 + super.getValor();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", adional de calabresa";
    }
}
