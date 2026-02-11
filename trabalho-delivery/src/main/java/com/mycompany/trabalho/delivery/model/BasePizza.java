package com.mycompany.trabalho.delivery.model;

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
