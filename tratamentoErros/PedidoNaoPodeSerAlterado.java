package tratamentoErros;

public class PedidoNaoPodeSerAlterado extends RuntimeException {
    public PedidoNaoPodeSerAlterado() {
        super("Pedido não pode ser alterado");
    }
}
