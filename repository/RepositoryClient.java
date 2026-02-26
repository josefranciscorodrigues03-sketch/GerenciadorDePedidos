package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositoryClient {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    public void salvarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public void mostrarClientes(){
        for(int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
    }
    public Cliente clientePorId(String id) {
        Cliente clienteEncontrado = null;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (Objects.equals(cliente.getId(), id)) {
                clienteEncontrado = clientes.get(i);
                break;
            }
        }
        return clienteEncontrado;
    }
}
