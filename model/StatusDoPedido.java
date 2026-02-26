package model;

public enum StatusDoPedido {
    PENDENTE("pendente"),
    CONCLUIDO("concluido"),
    CANCELADO("cancelado");

    private String descricao;

    StatusDoPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
