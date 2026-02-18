/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.infraestrutura.repositories;

/**
 *
 * @author Yuri
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.trabalho.delivery.dominio.port.IProvedorDePrecos;
import java.util.Map;
import java.io.InputStream;

public class ArquivoJsonPreco implements IProvedorDePrecos{
    private Map <String, Double> cardapio;
    
    ArquivoJsonPreco(){
        carregarPrecos();
    }
    
    private void carregarPrecos(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("precos.properties.json");
        
            if(inputStream==null){
            throw new RuntimeException("Arquivo de precos não foi encontrado!");
            }
        
            cardapio = mapper.readValue(inputStream, new TypeReference<Map<String, Double>>(){});
            
            System.out.println("Tabela de precos criada com sucesso: " + cardapio.size() + "itens encontrados");
            
            
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Não foi possível criar a lista de precos do arquivo JSON", e);
          }
        }
        
    @Override
    public double buscaPreco(String nomeDoItem){
        if(cardapio != null && cardapio.containsKey(nomeDoItem)){
            return cardapio.get(nomeDoItem);
        }
        System.err.println("Produto " + nomeDoItem + " não encontrado");
        return 0.0;
    }
    
}
