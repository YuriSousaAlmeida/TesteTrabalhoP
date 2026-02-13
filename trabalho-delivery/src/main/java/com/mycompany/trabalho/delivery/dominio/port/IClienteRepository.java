/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.port;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import java.util.List;

/**
 *
 * @author André
 */
public interface IClienteRepository {
    public Cliente salvarCliente(Cliente cliente);
    public Cliente buscarClientePorNome(String nome);
    public void deletarCliente(String nome);
    public Cliente buscarClientePorCPF(String cpf);
    public List<Cliente> buscarTodos();
}
