package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositoryProduto {
    private List<Produto> produtos = new ArrayList<Produto>();
    public void salvarProduto(Produto produto) {
        produtos.add(produto);
    }
    public void mostrarProduto(){
        for(int i = 0; i < produtos.size(); i++) {
            System.out.println("Nome: " + produtos.get(i).getNome() + "\nValor: " + produtos.get(i).getPreco() +"\nid: " + produtos.get(i).getId());
        }
    }

    public Produto buscarProdutoPorId(String id) {
        Produto produtoEncontrado = null;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (Objects.equals(produto.getId(), id)) {
                produtoEncontrado = produtos.get(i);
                break;
            }
        }
        return produtoEncontrado;
    }

}
