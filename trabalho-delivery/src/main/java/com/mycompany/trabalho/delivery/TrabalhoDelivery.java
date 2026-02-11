/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho.delivery;

import com.mycompany.trabalho.delivery.bebida.CocaCola;
import com.mycompany.trabalho.delivery.bebida.CocaColaTamanhoGrandeStrategy;
import com.mycompany.trabalho.delivery.bebida.CocaColaTamanhoPequenoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pedido.ITamanhoStrategy;
import com.mycompany.trabalho.delivery.dominio.model.pizza.decorators.*;
import com.mycompany.trabalho.delivery.dominio.model.pizza.*;

/**
 *
 * @author erko
 */
public class TrabalhoDelivery {
public static void main(String[] args) {
    
        ITamanhoStrategy tamanho = new PizzaTamanhoMedioStrategy();
        Pizza minhaPizza = new BasePizza(tamanho); 
        
        minhaPizza = new CalabresaDecorator(minhaPizza);  
        minhaPizza = new MussarelaDecorator(minhaPizza);
        minhaPizza = new PresuntoDecorator(minhaPizza);
        minhaPizza = new CogumelosDecorator(minhaPizza);
        
        ITamanhoStrategy tamanhoCoca = new CocaColaTamanhoPequenoStrategy();
        CocaCola coca = new CocaCola(tamanhoCoca);
        
        double valorFinal = minhaPizza.getValor() + coca.getValor();

        System.out.println("Descrição: " + minhaPizza.toString());
        System.out.println("Descrição: " + coca.toString());
        System.out.println("Valor Final: " + valorFinal);
    }
}
