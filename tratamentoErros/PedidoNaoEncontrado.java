package tratamentoErros;

public class PedidoNaoEncontrado extends RuntimeException {
    public PedidoNaoEncontrado() {
        super("Pedido não encontrado");
    }
}
