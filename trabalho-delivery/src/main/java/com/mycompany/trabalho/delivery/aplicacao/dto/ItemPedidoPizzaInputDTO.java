/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author André
 */
public class ItemPedidoPizzaInputDTO {
    private String sabor;
    private List<String> adicionais = new ArrayList<>();

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public List<String> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<String> adicionais) {
        this.adicionais = adicionais;
    }

    public ItemPedidoPizzaInputDTO() {
    }
}