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
public class FrangoCatupiryBuilder extends PizzaBuilder {
    private IProvedorDePrecos provedor;
    private AdicionadorDeIngrediente adicionarIngrediente;
    private AdicionadorDeMassa adicionarMassa;
    
    public FrangoCatupiryBuilder(IProvedorDePrecos provedor, AdicionadorDeIngrediente adicionarIngrediente, AdicionadorDeMassa adicionarMassa) {
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
        adicionarIngrediente.adicionarIngrediente(pizza, "Frango Desfiado");
        adicionarIngrediente.adicionarIngrediente(pizza, "Catupiry Original");
        adicionarIngrediente.adicionarIngrediente(pizza, "Milho");
        adicionarIngrediente.adicionarIngrediente(pizza, "Orégano");
    }
}
