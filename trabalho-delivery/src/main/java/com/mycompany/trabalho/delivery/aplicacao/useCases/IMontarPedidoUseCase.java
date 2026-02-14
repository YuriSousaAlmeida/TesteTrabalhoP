/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho.delivery.aplicacao.useCases;

import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoBebidaInputDTO;
import com.mycompany.trabalho.delivery.aplicacao.dto.ItemPedidoPizzaInputDTO;
import java.util.List;

/**
 *
 * @author Selmo
 */
public interface IMontarPedidoUseCase {
    public void executar(String cpf, List<ItemPedidoPizzaInputDTO> itensPizzas, List<ItemPedidoBebidaInputDTO> itensBebidas);
}
