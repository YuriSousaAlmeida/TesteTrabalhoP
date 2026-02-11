/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pedido;

/**
 *
 * @author erko
 */
public class PedidoCanceladoState implements IPedidoState {

    @Override
    public void proximo(Pedido pedido) {
        throw new IllegalStateException("Um pedido cancelado não pode avançar de estado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        // Já está cancelado
    }

    @Override
    public String getDescricao() {
        return "CANCELADO";
    }
}