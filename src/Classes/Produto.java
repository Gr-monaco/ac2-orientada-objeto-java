package Classes;

public class Produto {

    private String nome;
    private Float valorUnitario;
    private String descricao;
    private int quantidade;

    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(String nome, Float valorUnitario, String descricao, Fornecedor fornecedor) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {return quantidade;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", valorUnitario=" + valorUnitario + ", descricao=" + descricao
                + ", fornecedor=" + fornecedor.toString() + "]";
    }
}
