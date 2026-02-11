package com.mycompany.trabalho.delivery.bebida;

import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pedido.Item;

/**
 *
 * @author JoaoVitor
 */

public class CocaCola implements Item {
    
    private final double precoBase = 8;
    private final ITamanhoStrategy tamanho;

   
    public CocaCola(ITamanhoStrategy tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public double getValor() {
        return tamanho.calcularValor(precoBase);
    }
    
    @Override
    public String toString() {
        return "Coca-Cola: " + tamanho.getDescricao();
    }
}
