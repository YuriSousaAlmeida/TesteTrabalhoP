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

    public CalabresaBuilder(IProvedorDePrecos provedor) {
        this.provedor = provedor;
    }

    @Override
    public void prepararMassa() {
        String nome= "Massa Tradicional";
        pizza= new MassaBase(nome, provedor.buscaPreco(nome));
    }
    @Override
    public void adicionarMolho() {
        String molho= "Molho de Tomate";
        pizza= new Ingrediente(pizza, molho, provedor.buscaPreco(molho));
    }
    @Override
    public void adicionarCobertura() {
        pizza= new Ingrediente(pizza, "Calabresa Fatiada", provedor.buscaPreco("Calabresa Fatiada"));
        pizza= new Ingrediente(pizza, "Cebola", provedor.buscaPreco("Cebola"));
        pizza= new Ingrediente(pizza, "Azeitonas", provedor.buscaPreco("Azeitonas"));
    }
    
}
