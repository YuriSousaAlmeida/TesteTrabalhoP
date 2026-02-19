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
public class ModaDaCasaBuilder extends PizzaBuilder {
    private IProvedorDePrecos provedor;
    private AdicionadorDeIngrediente adicionarIngrediente;
    private AdicionadorDeMassa adicionarMassa;

    public ModaDaCasaBuilder(IProvedorDePrecos provedor, AdicionadorDeIngrediente adicionarIngrediente, AdicionadorDeMassa adicionarMassa) {
        this.provedor = provedor;
        this.adicionarIngrediente = adicionarIngrediente;
        this.adicionarMassa=adicionarMassa;
    }
    
    @Override
    public void prepararMassa() {
        pizza = adicionarMassa.adicionarMassa("Massa Pan (Grossa)");
    }
    @Override
    public void adicionarMolho() {
        adicionarIngrediente.adicionarIngrediente(pizza, "Molho Especial Picante");
    }
    @Override
    public void adicionarCobertura() {
        adicionarIngrediente.adicionarIngrediente(pizza, "Presunto Parma");
        adicionarIngrediente.adicionarIngrediente(pizza, "Bacon em Cubos");
        adicionarIngrediente.adicionarIngrediente(pizza, "Champignon");
        adicionarIngrediente.adicionarIngrediente(pizza, "Pimentão");
    }
}
