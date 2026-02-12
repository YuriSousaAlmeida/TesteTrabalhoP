package com.mycompany.trabalho.delivery.dominio.model.pedido;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import java.util.List;

/**
 * @author lucas.lopes
 */
public class Pedido {
    private Cliente cliente;
    private List<Item> itens;
    private IPedidoState estado;
    private double valorTotal;
    private ILogService logger;

    public Pedido(ILogService logger, Cliente cliente, List<Item> itens, IPedidoState estado) {
        this.logger = logger;
        this.cliente = cliente;
        this.itens = itens;
        this.estado = estado;
        
        calcularTotal(); 
    }
    
    public void avancarStatus() {
        logger.info("Iniciando transição de status do pedido. Valor total: R$ " + valorTotal);
        estado.proximo(this);
    }
    
    public void cancelar() {
        logger.info("Tentativa de cancelamento de pedido detectada.");
        estado.cancelar(this);
    }
    
    public void setEstado(IPedidoState novoEstado) {
        this.estado = novoEstado;
    }

    public ILogService getLogger() {
        return logger;
    }
    
    private void calcularTotal() {
        valorTotal = 0;
        for(Item item : itens) {
            valorTotal += item.getValor();
        }
    }
}