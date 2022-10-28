package Classes;

public class Produto {

    private String nome;
    private Float valorUnitario;

    public Produto() {
    }

    public Produto(String nome, Float valorUnitario) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
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
}
