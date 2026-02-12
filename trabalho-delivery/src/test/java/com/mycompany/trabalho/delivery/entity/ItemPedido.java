///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.trabalhofinal.Entity;
//
///**
// *
// * @author erko
// */
//public class ItemPedido {
//    private final Produto produto;
//    private final int quantidade;
//    private final double precoUnitario;
//
//    public ItemPedido(Produto produto, int quantidade) {
//        if (quantidade <= 0) {
//            throw new IllegalArgumentException("A quantidade deve ser superior a zero.");
//        }
//        this.produto = produto;
//        this.quantidade = quantidade;
//        this.precoUnitario = produto.preco();
//    }
//
//    public double getSubtotal() {
//        return precoUnitario * quantidade;
//    }
//
//    public Produto getProduto() { return produto; }
//    public int getQuantidade() { return quantidade; }
//}
