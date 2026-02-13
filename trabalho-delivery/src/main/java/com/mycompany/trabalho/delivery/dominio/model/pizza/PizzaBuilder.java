/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public abstract class PizzaBuilder {
    protected PizzaComponente pizza;

    public abstract void prepararMassa();
    public abstract void adicionarMolho();
    public abstract void adicionarCobertura();

    public final PizzaComponente getPizza() {
        return pizza;
    }
}
