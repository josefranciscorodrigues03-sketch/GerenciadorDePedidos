package service;

import model.Cliente;
import model.Pedido;
import model.Produto;
import model.StatusDoPedido;
import repository.*;
import tratamentoErros.ClienteVazio;
import tratamentoErros.PedidoNaoEncontrado;
import tratamentoErros.PedidoNaoPodeSerAlterado;
import tratamentoErros.ProdutoNaoEncontrado;

import java.time.LocalDateTime;
import java.util.UUID;

public class Service {

    RepositoryClient repositoryClient;
    RepositoryPedidos repositoryPedidos;
    RepositoryProduto repositoryProduto;

    public Service() {
        this.repositoryClient = new RepositoryClient();
        this.repositoryPedidos = new RepositoryPedidos();
        this.repositoryProduto = new RepositoryProduto();
    }

    public String cadastrarProduto(String nome, Double preco) {
        String id = UUID.randomUUID().toString();
        Produto produto = new Produto(id, nome, preco);
        repositoryProduto.salvarProduto(produto);
        return id;
    }

    public String cadastrarUsuario(String nome, String email) {
        String id = UUID.randomUUID().toString();
        Cliente cliente = new Cliente(id, nome, email);
        repositoryClient.salvarCliente(cliente);
        return id;
    }

    public String criarPedido(String clienteID, LocalDateTime data) {
        Cliente cliente = buscarClientePorId(clienteID);
        String id = UUID.randomUUID().toString();
        Pedido pedido = new Pedido(id, cliente, data, StatusDoPedido.PENDENTE);
        repositoryPedidos.salvarPedido(pedido);
        return id;
    }

    public void adicionarProdutoAoPedido(String pedidoID, String produtoID) {
        Pedido pedido = buscarPedidoPorId(pedidoID);
        Produto produto = buscarProdutoPorId(produtoID);

        if (pedido.getStatus() != StatusDoPedido.PENDENTE) {
            throw new PedidoNaoPodeSerAlterado();
        }

        pedido.adicionarProduto(produto);
    }

    public void listarPedidos() {
        repositoryPedidos.mostrarPedidos();
    }

    public Produto buscarProdutoPorId(String id) {
        Produto produto = repositoryProduto.buscarProdutoPorId(id);
        if (produto == null) {
            throw new ProdutoNaoEncontrado();
        }
        return produto;
    }

    public Pedido buscarPedidoPorId(String id) {
        Pedido pedido = repositoryPedidos.pedidoPorId(id);
        if (pedido == null) {
            throw new PedidoNaoEncontrado();
        }
        return pedido;
    }

    public Cliente buscarClientePorId(String id) {
        Cliente cliente = repositoryClient.clientePorId(id);
        if (cliente == null) {
            throw new ClienteVazio();
        }
        return cliente;
    }

    public void statusDoPedidoConcluido(String pedidoID) {
        Pedido pedido = buscarPedidoPorId(pedidoID);

        if (pedido.getStatus() == StatusDoPedido.CANCELADO) {
            throw new PedidoNaoPodeSerAlterado();
        }

        pedido.setStatus(StatusDoPedido.CONCLUIDO);
    }

    public void statusDoPedidoCancelado(String pedidoID) {
        Pedido pedido = buscarPedidoPorId(pedidoID);
        pedido.setStatus(StatusDoPedido.CANCELADO);
    }
    public void mostrarProdutos() {
        repositoryProduto.mostrarProduto();
    }
}
