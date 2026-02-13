/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public class CalabresaBuilder extends PizzaBuilder {
    @Override
    public void prepararMassa() {
        pizza = new MassaBase("Massa Tradicional", 25.00);
    }
    @Override
    public void adicionarMolho() {
        pizza = new Ingrediente(pizza, "Molho de Tomate", 2.00);
    }
    @Override
    public void adicionarCobertura() {
        pizza = new Ingrediente(pizza, "Calabresa Fatiada", 12.00);
        pizza = new Ingrediente(pizza, "Cebola", 2.00);
        pizza = new Ingrediente(pizza, "Azeitonas", 1.50);
    }
}
