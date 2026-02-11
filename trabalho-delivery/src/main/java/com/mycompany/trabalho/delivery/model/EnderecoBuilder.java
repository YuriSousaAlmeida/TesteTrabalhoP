package com.mycompany.trabalho.delivery.model;

/**
 *
 * @author lucas.lopes
 */
public class EnderecoBuilder {
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Endereco getEndereco() {
        return new Endereco(cidade, bairro, rua, numero);
    }
}
