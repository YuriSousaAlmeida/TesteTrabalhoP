/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pedido;

/**
 *
 * @author erko
 */
public class PedidoEntregueState implements IPedidoState {
    @Override
    public void avancarEstado(Pedido pedido) {
        pedido.getLogger().erro("Operação bloqueada: Tentativa de avançar o status de um pedido que já está ENTREGUE.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.getLogger().erro("Operação bloqueada: Tentativa de CANCELAR um pedido que já foi ENTREGUE.");
        throw new IllegalStateException("Pedido já entregue.");
    }

    @Override
    public String getDescricao() {
        return "ENTREGUE - Concluído com sucesso";
    }
}