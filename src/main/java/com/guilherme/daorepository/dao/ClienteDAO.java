package com.guilherme.daorepository.dao;

import com.guilherme.daorepository.entity.Cliente;
import java.util.List;

public interface ClienteDAO {
    void inserir(Cliente cliente);
    
//    Cliente buscarPorId(int id);
    
//    List<Cliente> listarTodos();
    
    void atualizar(Cliente cliente);
    
    void deletar(int id);
}
