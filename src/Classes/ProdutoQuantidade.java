package Classes;

import Classes.Pedido;

public class ProdutoQuantidade extends Produto{

    private int quantidade;

    public ProdutoQuantidade(String nome, Float valorUnitario, String descricao, Fornecedor fornecedor, int quantidade) {
        super(nome, valorUnitario, descricao, fornecedor);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + getNome() + ", valorUnitario=" + getValorUnitario() + ", descricao=" + getDescricao()
                + ", fornecedor=" + getFornecedor().toString() + "]";
    }
}
