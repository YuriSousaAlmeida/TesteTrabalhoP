package dominio.model.pizza;

import dominio.model.pizza.Pizza;

/**
 *
 * @author lucas.lopes
 */
public class BasePizza implements Pizza {
    @Override
    public double getValor() {
        // por apenas um tamanho de pizza. se tamanhos novos forem implementados, será em BasePizza
        return 40;
    }
    
    @Override
    public String toString() {
        return "Pizza média";
    }
}
