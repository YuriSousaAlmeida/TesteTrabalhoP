package com.mycompany.trabalho.delivery.dominio.model.pedido;

import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.port.ILogService;
import com.mycompany.trabalho.delivery.dominio.adapter.ConsoleLogAdapter; // Importe o adaptador
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
    private long id;
    
    public Pedido(ILogService logger, Cliente cliente, List<Item> itens, IPedidoState estado) {
        this.logger = logger;
        this.cliente = cliente;
        this.itens = itens;
        this.estado = estado;
        calcularTotal(); 
    }

    //Construtor para testes 
    public Pedido(Cliente cliente, List<Item> itens, IPedidoState estado) { 
        this(new ConsoleLogAdapter(), cliente, itens, estado); 
    }

    public Pedido(Cliente cliente, List<Item> itens){
        this(new ConsoleLogAdapter(), cliente, itens, new PedidoPendenteState());
    }

    public Cliente getCliente(){
        return cliente;
    }

    public List<Item> getItens(){
        return itens;
    }

    public IPedidoState getEstado(){
        return estado;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    public long getId(){
        return id;
    }
    
    public void avancarEstado(){
        if(logger != null){ 
            logger.info("Iniciando transição de status do pedido. Valor total: R$ " + valorTotal);
        }
        estado.avancarEstado(this);
    }
    
    public void cancelar(){
        if(logger != null){
            logger.info("Tentativa de cancelamento de pedido detectada.");
        }
        estado.cancelar(this);
    }
    
    public void setEstado(IPedidoState novoEstado){
        this.estado = novoEstado;
    }

    public ILogService getLogger(){
        return logger;
    }
    
    private void calcularTotal(){
        valorTotal = 0;
        for(Item item : itens){
            valorTotal += item.getPreco();
        }
    }
}