/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.port;

import com.mycompany.trabalho.delivery.dominio.model.pedido.Pedido;
import java.util.List;

/**
 *
 * @author André
 */
public interface IPedidoRepository {
    public void salvarPedido(Pedido pedido);
    public Pedido buscarPedidoPorId(int id);
    public void deletarPedido(int id);
    public List<Pedido> buscarPedidosPorCpf(String cpf);
}
