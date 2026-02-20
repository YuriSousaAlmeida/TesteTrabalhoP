/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho.delivery.dominio.port;

import java.util.List;

/**
 *
 * @author Yuri
 */
public interface IProvedorDePrecos {
    public double buscaPreco(String nomeDoItem); 
    public List<String> buscaMassas();
    public List<String> buscaIngredientes();
    public List<String> buscaBebidas();
}
