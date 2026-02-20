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

    public PortuguesaBuilder(IProvedorDePrecos provedor) {
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
        pizza= new Ingrediente(pizza, "Presunto", provedor.buscaPreco("Presunto"));
        pizza= new Ingrediente(pizza, "Ovo Cozido", provedor.buscaPreco("Ovo Cozido"));
        pizza= new Ingrediente(pizza, "Ervilha", provedor.buscaPreco("Ervilha"));
        pizza= new Ingrediente(pizza, "Cebola", provedor.buscaPreco("Cebola"));
        pizza= new Ingrediente(pizza, "Mussarela", provedor.buscaPreco("Mussarela"));
    }
}
