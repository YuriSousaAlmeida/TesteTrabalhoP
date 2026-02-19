/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */

import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;

public class CalabresaBuilder extends PizzaBuilder {
    private IProvedorDePrecos provedor;
    private AdicionadorDeIngrediente adicionarIngrediente;
    private AdicionadorDeMassa adicionarMassa;

    public CalabresaBuilder(IProvedorDePrecos provedor, AdicionadorDeIngrediente adicionarIngrediente, AdicionadorDeMassa adicionarMassa) {
        this.provedor = provedor;
        this.adicionarIngrediente = adicionarIngrediente;
        this.adicionarMassa=adicionarMassa;
    }

    @Override
    public void prepararMassa() {
        pizza = adicionarMassa.adicionarMassa("Massa Tradicional");
    }
    @Override
    public void adicionarMolho() {
        adicionarIngrediente.adicionarIngrediente(pizza, "Molho de Tomate");
    }
    @Override
    public void adicionarCobertura() {
        adicionarIngrediente.adicionarIngrediente(pizza, "Calabresa Fatiada");
        adicionarIngrediente.adicionarIngrediente(pizza, "Cebola");
        adicionarIngrediente.adicionarIngrediente(pizza, "Azeitonas");
    }
    
}
