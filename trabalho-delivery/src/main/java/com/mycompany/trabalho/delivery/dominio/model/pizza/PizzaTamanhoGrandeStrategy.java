/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;

/**
 *
 * @author André
 */
public class PizzaTamanhoGrandeStrategy implements ITamanhoStrategy{
    @Override
    public double calcularValor(double valorBase) {
        return valorBase * 1.5; 
    }

    @Override
    public String getDescricao() {
        return "Grande";
    }
}
