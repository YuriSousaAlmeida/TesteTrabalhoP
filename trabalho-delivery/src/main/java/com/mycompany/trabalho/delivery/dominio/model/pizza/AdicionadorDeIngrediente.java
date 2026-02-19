/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author Yuri
 */
import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;

public class AdicionadorDeIngrediente {
    private IProvedorDePrecos provedor;
    
    AdicionadorDeIngrediente(IProvedorDePrecos provedor){
        this.provedor=provedor;
    }
    
    public Ingrediente adicionarIngrediente(PizzaComponente pizza, String nomeDoItem){
        double preco=provedor.buscaPreco(nomeDoItem);
        
        return new Ingrediente(pizza, nomeDoItem, preco);
    }
    
}
