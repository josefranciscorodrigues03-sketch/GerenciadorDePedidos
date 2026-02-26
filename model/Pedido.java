package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private Cliente cliente;
    private LocalDateTime data;
    private StatusDoPedido status;

    protected List<Produto> produtos = new ArrayList<Produto>();
    public void mostrarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i).getNome());
        }
    }
    public Double valorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < produtos.size(); i++) {
             valorTotal += produtos.get(i).getPreco();
        }
        return valorTotal;
    }

    public Pedido(String id, Cliente cliente, LocalDateTime data, StatusDoPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.status = status;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    public void excluirProduto(Produto produto) {
        produtos.remove(produto);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }
}
