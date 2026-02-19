/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.model.pizza;

/**
 *
 * @author Yuri
 */
import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;
 
public class AdicionadorDeMassa {
    private IProvedorDePrecos provedor;
    
    AdicionadorDeMassa(IProvedorDePrecos provedor){
        this.provedor=provedor;
    }
    
    public MassaBase adicionarMassa(String nomeDoItem){
        double preco=provedor.buscaPreco(nomeDoItem);
        
        return new MassaBase(nomeDoItem, preco);
    }
}
