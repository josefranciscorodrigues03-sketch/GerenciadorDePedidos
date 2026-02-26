package tratamentoErros;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado() {
        super("Produto não encontrado");
    }
}
