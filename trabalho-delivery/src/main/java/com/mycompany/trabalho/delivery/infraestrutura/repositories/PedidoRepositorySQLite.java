/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.infraestrutura.repositories;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import com.mycompany.trabalho.delivery.dominio.port.IPedidoRepository;

/**
 *
 * @author Yuri
 */

public class PedidoRepositorySQLite implements IPedidoRepository {

    @Override
    public void salvarPedido(Pedido pedido) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void deletarPedido(int id) {
        throw new UnsupportedOperationException("");    }

}
