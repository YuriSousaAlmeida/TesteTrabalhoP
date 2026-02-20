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

    public QuatroQueijosBuilder(IProvedorDePrecos provedor) {
        this.provedor = provedor;
    }
    
    @Override
    public void prepararMassa() {
        String nome= "Massa Crocante";
        pizza= new MassaBase(nome, provedor.buscaPreco(nome));
    }
    @Override
    public void adicionarMolho() {
        String molho= "Molho Branco";
        pizza= new Ingrediente(pizza, molho, provedor.buscaPreco(molho));
    }
    @Override
    public void adicionarCobertura() {
        pizza= new Ingrediente(pizza, "Mussarela", provedor.buscaPreco("Mussarela"));
        pizza= new Ingrediente(pizza, "Provolone", provedor.buscaPreco("Provolone"));
        pizza= new Ingrediente(pizza, "Parmesão", provedor.buscaPreco("Parmesão"));
        pizza= new Ingrediente(pizza, "Gorgonzola", provedor.buscaPreco("Gorgonzola"));
    }
}
