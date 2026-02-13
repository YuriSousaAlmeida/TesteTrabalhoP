/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.dto;

/**
 *
 * @author André
 */
public class ItemPedidoOutputDTO {
    public Integer idItem;
    public String descricao;
    public Integer quantidade;
    public Double valorCalculado;

    public ItemPedidoOutputDTO() {
    }

    public ItemPedidoOutputDTO(Integer idItem, String descricao, Integer quantidade, Double valorCalculado) {
        this.idItem = idItem;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorCalculado = valorCalculado;
    }
}
