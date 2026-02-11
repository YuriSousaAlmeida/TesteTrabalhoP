/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pedido;

/**
 *
 * @author erko
 */
public class PedidoPreparandoState implements IPedidoState {
    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoProntoState());
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