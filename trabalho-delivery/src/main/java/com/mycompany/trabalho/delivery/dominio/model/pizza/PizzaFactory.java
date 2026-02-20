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
            case "calabresa":
                builder = new CalabresaBuilder(provedorPrecos);
                break;
            case "modadacasa":
                builder = new ModaDaCasaBuilder(provedorPrecos);
                break;
            case "portuguesa":
                builder = new PortuguesaBuilder(provedorPrecos);
                break;
            case "quatroqueijos":
                builder = new QuatroQueijosBuilder(provedorPrecos);
                break;
            case "frangocatupiry":
                builder = new FrangoCatupiryBuilder(provedorPrecos);
                break;
            default:
                throw new IllegalArgumentException("Sabor de pizza indisponível no cardápio: " + sabor);
        }

        PizzaioloDiretor diretor = new PizzaioloDiretor();
        return diretor.build(builder);
    }
}
