package com.mycompany.trabalho.delivery.dominio.model.shared;

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

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }
    
}
