package com.mycompany.trabalho.delivery.dominio.model.pizza;


import com.mycompany.trabalho.delivery.dominio.model.pizza.PizzaComponente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author André
 */
public final class PizzaioloDiretor {

    public PizzaComponente build(PizzaBuilder builder) {
        builder.prepararMassa();
        builder.adicionarMolho();
        builder.adicionarCobertura();
        return builder.getPizza();
    }
}
