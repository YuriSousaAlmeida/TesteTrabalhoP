package com.mycompany.trabalho.delivery.bebida;

import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;

/**
 *
 * @author JoaoVitor
 */

public class CocaColaTamanhoGrandeStrategy implements ITamanhoStrategy {
    
    @Override
    public double calcularValor(double valorBase) {
        return valorBase + 7.00;
    }
    
    @Override
    public String getDescricao() {
        return "2 L";
    }
}
