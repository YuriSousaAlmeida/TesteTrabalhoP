/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinal.Entity;

/**
 *
 * @author erko
 */



public class PedidoEntregue implements IPedidoStatus {
    @Override
    public void proximo(Pedido pedido) {
        // Estado final: operação ignorada ou excepção
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já entregue.");
    }

    @Override
    public String getDescricao() {
        return "ENTREGUE - Concluído com sucesso";
    }
}