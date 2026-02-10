/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.model;

/**
 *
 * @author erko
 */

public interface IPedidoStatus {
    void proximo(Pedido pedido);
    void cancelar(Pedido pedido);
    String getDescricao();
}