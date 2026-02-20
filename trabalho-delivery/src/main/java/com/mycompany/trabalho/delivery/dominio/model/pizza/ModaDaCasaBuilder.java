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

    public ModaDaCasaBuilder(IProvedorDePrecos provedor) {
        this.provedor = provedor;
    }
    
    @Override
    public void prepararMassa() {
        String nome= "Massa Pan (Grossa)";
        pizza= new MassaBase(nome, provedor.buscaPreco(nome));
    }
    @Override
    public void adicionarMolho() {
        String molho= "Molho Especial Picante";
        pizza= new Ingrediente(pizza, molho, provedor.buscaPreco(molho));
    }
    @Override
    public void adicionarCobertura() {
        pizza= new Ingrediente(pizza, "Presunto Parma", provedor.buscaPreco("Presunto Parma"));
        pizza= new Ingrediente(pizza, "Bacon em Cubos", provedor.buscaPreco("Bacon em Cubos"));
        pizza= new Ingrediente(pizza, "Champignon", provedor.buscaPreco("Champignon"));
        pizza= new Ingrediente(pizza, "Pimentão", provedor.buscaPreco("Pimentão"));
    }
}
