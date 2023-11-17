package com.guilherme.daorepository.application;

import com.guilherme.daorepository.dao.ClienteDAOSQLite;
import com.guilherme.daorepository.entity.Cliente;


public class Main {

    public static void main(String[] args) {
        ClienteDAOSQLite clienteDAOSQLite = new ClienteDAOSQLite();
        
        Cliente cliente1 = new Cliente(1781, "Roberto", "roberto@gmail.com");
        Cliente cliente2 = new Cliente(1542, "Guilherme", "guilherme@gmail.com");
        Cliente cliente3 = new Cliente(8921, "Zé", "ze@gmail.com");

        
        clienteDAOSQLite.inserir(cliente1);
        clienteDAOSQLite.inserir(cliente2);
        clienteDAOSQLite.inserir(cliente3);
    }
}
