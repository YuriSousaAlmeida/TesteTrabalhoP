/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public class QuatroQueijosBuilder extends PizzaBuilder {
    @Override
    public void prepararMassa() {
        pizza = new MassaBase("Massa Crocante", 28.00);
    }
    @Override
    public void adicionarMolho() {
        pizza = new Ingrediente(pizza, "Molho Branco", 4.00);
    }
    @Override
    public void adicionarCobertura() {
        pizza = new Ingrediente(pizza, "Mussarela", 8.00);
        pizza = new Ingrediente(pizza, "Provolone", 9.00);
        pizza = new Ingrediente(pizza, "Parmesão", 10.00);
        pizza = new Ingrediente(pizza, "Gorgonzola", 12.00);
    }
}
