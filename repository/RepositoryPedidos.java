package repository;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositoryPedidos {
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    public void salvarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public void mostrarPedidos(){
        for(int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i).getCliente().getNome() + " " + pedidos.get(i).valorTotal());
        }
    }
    public Pedido pedidoPorId(String id) {
        Pedido pedidoEncontrado = null;
        for(int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (Objects.equals(pedido.getId(), id)) {
                pedidoEncontrado = pedidos.get(i);
                break;
            }
        }
        return pedidoEncontrado;
    }
}
