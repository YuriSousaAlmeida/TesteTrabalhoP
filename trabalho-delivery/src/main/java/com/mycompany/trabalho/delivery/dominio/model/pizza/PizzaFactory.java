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
public class PizzaFactory implements IPizzaFactory {
    
    private final IProvedorDePrecos provedorPrecos;

    public PizzaFactory(IProvedorDePrecos provedorPrecos) {
        this.provedorPrecos = provedorPrecos;
    }

    @Override
    public PizzaComponente criarPizza(String sabor) {
        PizzaBuilder builder;
        
        switch (sabor.toLowerCase()) {
            case "Pizza Calabresa":
                builder = new CalabresaBuilder(provedorPrecos);
                break;
            case "Pizza Moda da Casa":
                builder = new ModaDaCasaBuilder(provedorPrecos);
                break;
            case "Pizza Portuguesa":
                builder = new PortuguesaBuilder(provedorPrecos);
                break;
            case "Pizza Quatro Queijos":
                builder = new QuatroQueijosBuilder(provedorPrecos);
                break;
            case "Pizza Frango com Catupiry":
                builder = new FrangoCatupiryBuilder(provedorPrecos);
                break;
            default:
                throw new IllegalArgumentException("Sabor de pizza indisponível no cardápio: " + sabor);
        }

        PizzaioloDiretor diretor = new PizzaioloDiretor();
        return diretor.build(builder);
    }
}
