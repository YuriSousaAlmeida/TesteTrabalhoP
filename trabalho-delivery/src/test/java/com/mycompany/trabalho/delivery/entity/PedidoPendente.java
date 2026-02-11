/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.entity;

/**
 *
 * @author erko
 */
public class PedidoPendente implements IPedidoStatus {
    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoPreparando());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoCancelado());
    }

    @Override
    public String getDescricao() {
        return "PENDENTE - Aguardando confirmação do restaurante";
    }
}