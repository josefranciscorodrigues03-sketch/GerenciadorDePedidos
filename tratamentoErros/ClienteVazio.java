package tratamentoErros;

public class ClienteVazio extends RuntimeException {
    public ClienteVazio() {
        super("Cliente vazio");
    }
}
