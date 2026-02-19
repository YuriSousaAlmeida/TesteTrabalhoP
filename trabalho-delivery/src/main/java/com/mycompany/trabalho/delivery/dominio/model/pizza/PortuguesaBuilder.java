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
public class PortuguesaBuilder extends PizzaBuilder {
    private IProvedorDePrecos provedor;
    private AdicionadorDeIngrediente adicionarIngrediente;
    private AdicionadorDeMassa adicionarMassa;

    public PortuguesaBuilder(IProvedorDePrecos provedor, AdicionadorDeIngrediente adicionarIngrediente, AdicionadorDeMassa adicionarMassa) {
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
        adicionarIngrediente.adicionarIngrediente(pizza, "Presunto");
        adicionarIngrediente.adicionarIngrediente(pizza, "Ovo Cozido");
        adicionarIngrediente.adicionarIngrediente(pizza, "Ervilha");
        adicionarIngrediente.adicionarIngrediente(pizza, "Cebola");
        adicionarIngrediente.adicionarIngrediente(pizza, "Mussarela");
    }
}
