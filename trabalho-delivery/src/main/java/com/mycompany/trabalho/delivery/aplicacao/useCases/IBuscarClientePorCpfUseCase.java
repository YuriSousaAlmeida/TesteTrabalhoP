/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;

/**
 *
 * @author Selmo
 */
public interface IBuscarClientePorCpfUseCase {
    public Cliente executar(String cpf);
}
