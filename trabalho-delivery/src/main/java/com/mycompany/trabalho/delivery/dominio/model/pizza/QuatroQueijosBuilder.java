/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;

/**
 *
 * @author André
 */
public class QuatroQueijosBuilder extends PizzaBuilder {
    private IProvedorDePrecos provedor;
    private AdicionadorDeIngrediente adicionarIngrediente;
    private AdicionadorDeMassa adicionarMassa;

    public QuatroQueijosBuilder(IProvedorDePrecos provedor, AdicionadorDeIngrediente adicionarIngrediente) {
        this.provedor = provedor;
        this.adicionarIngrediente = adicionarIngrediente;
    }
    
    @Override
    public void prepararMassa() {
        pizza = adicionarMassa.adicionarMassa("Massa Crocante");
    }
    @Override
    public void adicionarMolho() {
        adicionarIngrediente.adicionarIngrediente(pizza, "Molho Branco");
    }
    @Override
    public void adicionarCobertura() {
        adicionarIngrediente.adicionarIngrediente(pizza, "Mussarela");
        adicionarIngrediente.adicionarIngrediente(pizza, "Provolone");
        adicionarIngrediente.adicionarIngrediente(pizza, "Parmesão");
        adicionarIngrediente.adicionarIngrediente(pizza, "Gorgonzola");
    }
}
