package com.mycompany.trabalho.delivery.aplicacao.dto;

/**
 *
 * @author lucas.lopes
 */
public class PedidoDTO {

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private Long idPedido;
    private String status;
}
