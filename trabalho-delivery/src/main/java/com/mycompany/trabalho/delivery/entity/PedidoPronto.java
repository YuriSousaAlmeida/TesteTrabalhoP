/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinal.Entity;

/**
 *
 * @author erko
 */
 
public class PedidoPronto implements IPedidoStatus {
    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido pronto não pode ser cancelado.");
    }

    @Override
    public String getDescricao() {
        return "PRONTO - Aguardando estafeta ou recolha";
    }
}