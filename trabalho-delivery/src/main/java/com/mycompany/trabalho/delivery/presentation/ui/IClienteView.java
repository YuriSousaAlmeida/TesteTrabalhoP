/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho.delivery.presentation.ui;

import java.util.List;

/**
 *
 * @author erko
 */
public interface IClienteView {
    //metodos para presenter ler os dados datela. atualizar UI. identificar qual linha de cliente está selecionada
    String getNome();
    String getEmail();
    String getCidade();
    String getBairro();
    String getRua();
    String getNumero();
    
    
//    void atualizarTabela(List<ClientesColecaoView> clientes);
    void mostrarMensagem(String msg);
    void limparCampos();
    
    int getLinhaSelecionada();
}
