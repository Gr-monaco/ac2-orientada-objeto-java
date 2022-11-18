package Classes;

import java.util.Date;
import java.util.List;

public class Pedido {
    private String cpf;
    private String nomeDoCliente;
    private Long id;
    private Date data;
    private Double valorTotal;

    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(String cpf, String nomeDoCliente, Long id, Date data, Double valorTotal, List<Produto> produtos) {
        this.cpf = cpf;
        this.nomeDoCliente = nomeDoCliente;
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.produtos = produtos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void addProduto(Produto novoProduto) {
        this.produtos.add(novoProduto);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cpf='" + cpf + '\'' +
                ", nomeDoCliente='" + nomeDoCliente + '\'' +
                ", id=" + id +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
