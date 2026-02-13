/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public class ModaDaCasaBuilder extends PizzaBuilder {
    @Override
    public void prepararMassa() {
        pizza = new MassaBase("Massa Pan (Grossa)", 30.00);
    }
    @Override
    public void adicionarMolho() {
        pizza = new Ingrediente(pizza, "Molho Especial Picante", 5.00);
    }
    @Override
    public void adicionarCobertura() {
        pizza = new Ingrediente(pizza, "Presunto Parma", 15.00);
        pizza = new Ingrediente(pizza, "Bacon em Cubos", 10.00);
        pizza = new Ingrediente(pizza, "Champignon", 8.00);
        pizza = new Ingrediente(pizza, "Pimentão", 3.00);
    }
}
