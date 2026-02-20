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
    
    public FrangoCatupiryBuilder(IProvedorDePrecos provedor) {
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
        pizza= new Ingrediente(pizza, "Frango Desfiado", provedor.buscaPreco("Frango Desfiado"));
        pizza= new Ingrediente(pizza, "Catupiry Original", provedor.buscaPreco("Catupiry Original"));
        pizza= new Ingrediente(pizza, "Milho", provedor.buscaPreco("Milho"));
        pizza= new Ingrediente(pizza, "Orégano", provedor.buscaPreco("Orégano"));
    }
}
