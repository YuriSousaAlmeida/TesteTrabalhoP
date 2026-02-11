package com.mycompany.trabalho.delivery.bebida;

import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;

/**
 *
 * @author JoaoVitor
 */

public class CocaColaTamanhoMedioStrategy implements ITamanhoStrategy {
    
    @Override
    public double calcularValor(double valorBase) {
        return valorBase + 4.00;
    }
    
    @Override
    public String getDescricao() {
        return "1,5 L";
    }
}
