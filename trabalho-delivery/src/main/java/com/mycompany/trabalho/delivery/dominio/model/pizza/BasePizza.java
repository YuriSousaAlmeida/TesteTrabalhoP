package com.mycompany.trabalho.delivery.dominio.model.pizza;

import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;


/**
 *
 * @author lucas.lopes
 */
public class BasePizza implements Pizza {
    
    
    //TRECHO FEITO POR LUCAS
//    @Override
//    public double getValor() {
//        // por apenas um tamanho de pizza. se tamanhos novos forem implementados, será em BasePizza
//        return 40;
//    }
//    
//    @Override
//    public String toString() {
//        return "Pizza média";
//    }
    
    //SUGESTAO DE ANDRÉ
    
    private final double precoBase = 20.0;
    private final ITamanhoStrategy tamanho;

   
    public BasePizza(ITamanhoStrategy tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public double getValor() {
        return tamanho.calcularValor(precoBase);
    }
    
    @Override
    public String toString() {
        return "Pizza " + tamanho.getDescricao();
    }
}
