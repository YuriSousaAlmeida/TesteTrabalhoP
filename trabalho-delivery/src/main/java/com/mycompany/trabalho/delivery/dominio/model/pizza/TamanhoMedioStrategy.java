/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author André
 */
public class TamanhoMedioStrategy implements ITamanhoStrategy{
    
    @Override
    public double calcularValor(double valorBase) {
        return valorBase * 1.3; 
    }

    @Override
    public String getDescricao() {
        return "Média";
    }
}