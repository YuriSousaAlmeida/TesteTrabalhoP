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
public class ItemPedidoPizzaInputDTO implements ItemPedidoInputDTO {
    public String sabor;
    public List<String> adicionais = new ArrayList<>();

    public ItemPedidoPizzaInputDTO() {
    }
}