/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pedido;

/**
 *
 * @author erko
 */
public class PedidoPendenteState implements IPedidoState {
    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoPreparandoState());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoCanceladoState());
    }

    @Override
    public String getDescricao() {
        return "PENDENTE - Aguardando confirmação do restaurante";
    }
}