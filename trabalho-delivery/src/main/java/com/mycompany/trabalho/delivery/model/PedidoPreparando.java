/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.model;

/**
 *
 * @author erko
 */
public class PedidoPreparando implements IPedidoStatus {
    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoPronto());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido em preparação não pode ser cancelado.");
    }

    @Override
    public String getDescricao() {
        return "PREPARANDO - O pedido está a ser cozinhado";
    }
}