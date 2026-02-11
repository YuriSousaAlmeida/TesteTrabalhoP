package com.mycompany.trabalho.delivery.bebida;

import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;

/**
 *
 * @author JoaoVitor
 */

public class CocaColaTamanhoPequenoStrategy implements ITamanhoStrategy {
    
    @Override
    public double calcularValor(double valorBase) {
        return valorBase;
    }
    
    @Override
    public String getDescricao() {
        return "Lata 375 ml";
    }
}
