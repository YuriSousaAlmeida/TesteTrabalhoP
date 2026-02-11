package com.mycompany.trabalho.delivery.model;

/**
 *
 * @author lucas.lopes
 */
public class Endereco {
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public Endereco(String cidade, String bairro, String rua, String numero) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }
}
