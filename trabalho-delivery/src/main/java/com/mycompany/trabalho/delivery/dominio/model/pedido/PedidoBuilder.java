package com.mycompany.trabalho.delivery.dominio.model.pedido;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import java.util.List;

/**
 * @author lucas.lopes
 */
public class PedidoBuilder {
    private Cliente cliente;
    private List<Item> itens;
    private ILogService logger;

    public PedidoBuilder(List<Item> itens, ILogService logger) {
        this.itens = itens;
        this.logger = logger;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public void removerItem(Item item) {
        itens.remove(item);
    }
    
    public void limparPedido() {
        itens.clear();
    }
    
    public Pedido getPedido() {
    // Log criação de pedido
    logger.info("Novo pedido criado para o cliente: " + cliente.getNome() + " com " + itens.size() + " itens.");
    return new Pedido(logger, cliente, itens, new PedidoPendenteState());
}
}