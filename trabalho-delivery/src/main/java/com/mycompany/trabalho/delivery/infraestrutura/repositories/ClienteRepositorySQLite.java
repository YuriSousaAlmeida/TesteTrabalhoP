/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.delivery.infraestrutura.repositories;

/**
 *
 * @author Yuri
 */
import com.mycompany.trabalho.delivery.dominio.model.cliente.Cliente;
import com.mycompany.trabalho.delivery.dominio.model.shared.Endereco;
import com.mycompany.trabalho.delivery.dominio.port.IClienteRepository;
import com.mycompany.trabalho.delivery.infraestrutura.ConexaoSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteRepositorySQLite implements IClienteRepository {

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome, cpf, email, cidade, bairro, rua, numero) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conexao = ConexaoSingleton.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getCidade());
            statement.setString(5, cliente.getBairro());
            statement.setString(6, cliente.getRua());
            statement.setString(7, cliente.getNumero());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return cliente;
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
            throw new RuntimeException("Erro de banco de dados ao salvar cliente.", e);
        }
        return null;
    }

    @Override
    public Cliente buscarClientePorNome(String nome) {
        String sql = "SELECT * FROM clientes WHERE nome = ?";
        try (Connection conexao = ConexaoSingleton.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, nome);
            ResultSet rset = statement.executeQuery();
            
            if (rset.next()) {
                return mapearCliente(rset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente buscarClientePorCPF(String cpf) {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";
        try (Connection conexao = ConexaoSingleton.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, cpf);
            ResultSet rset = statement.executeQuery();
            
            if (rset.next()) {
                return mapearCliente(rset);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletarCliente(String nome) {
        String sql = "DELETE FROM clientes WHERE nome = ?";
        try(Connection conexao = ConexaoSingleton.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, nome);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Cliente mapearCliente(ResultSet rset) throws SQLException {
        String nome = rset.getString("nome");
        String cpf = rset.getString("cpf");
        String email = rset.getString("email");
        String cidade = rset.getString("cidade");
        String bairro = rset.getString("bairro");
        String rua = rset.getString("rua");
        String numero = rset.getString("numero");
        
        Endereco endereco = new Endereco(cidade, bairro, rua, numero);
        return new Cliente(nome, cpf, email, endereco);
    }
    
    public int buscarIdPorCpf(String cpf) {
        String sql = "SELECT id FROM clientes WHERE cpf = ?";
        try (Connection conexao = ConexaoSingleton.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, cpf);
            ResultSet rset = statement.executeQuery();
            if (rset.next()) return rset.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}