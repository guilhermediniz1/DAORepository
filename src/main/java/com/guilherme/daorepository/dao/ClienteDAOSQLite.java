package com.guilherme.daorepository.dao;

import com.guilherme.daorepository.entity.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAOSQLite implements ClienteDAO {
    private Connection connection;

    public ClienteDAOSQLite() {
        try {   
            connection = DriverManager.getConnection("jdbc:sqlite:database");
            System.out.println("A conexão com o SQLite foi estabelecida.");
            
            criarTabelaClientes();
        } catch (SQLException ex) {
            System.out.println("Erro ao estabelecer conexão com o SQLite: " + ex.getMessage());
        }
    }
    
    private void criarTabelaClientes() {
        String sql = """
                     CREATE TABLE IF NOT EXISTS clientes (
                      id integer PRIMARY KEY,
                      name text NOT NULL,
                      email text NOT NULL
                     );
                     """;
        
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Tabela clientes criada com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao criar a tabela de clientes: " + ex.getMessage());
        } 
    }
    
    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes(id, name, email) VALUES(?, ?)";
    
           try {
               PreparedStatement pstmt = connection.prepareStatement(sql);
               pstmt.setInt(1, cliente.getId());
               pstmt.setString(2, cliente.getNome());
               pstmt.setString(3, cliente.getEmail());
               pstmt.executeUpdate();
               
               System.out.printf("Cliente %s inserido com successo", cliente.getId());
           } catch (SQLException ex) {
               System.out.println("Erro ao inserir novo cliente na tabela: " + ex.getMessage());
           }
    };
    
//    @Override
//    public Cliente buscarPorId(int id) {
//    };
//    
//    @Override
//    public List<Cliente> listarTodos() {
//        
//    };
    
    @Override
    public void atualizar(Cliente cliente) {};
    
    @Override
    public void deletar(int id) {};
}
