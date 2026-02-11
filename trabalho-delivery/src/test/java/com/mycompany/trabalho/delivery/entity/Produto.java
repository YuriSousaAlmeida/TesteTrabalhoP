/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinal.Entity;

/**
 *
 * @author erko
 */

public record Produto(Long id, String nome, double preco, String descricao) {

    public Produto {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID do produto deve ser positivo.");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }

        if (descricao == null || descricao.length() < 10) {
            throw new IllegalArgumentException("A descrição deve ter pelo menos 10 caracteres.");
        }
    }
}