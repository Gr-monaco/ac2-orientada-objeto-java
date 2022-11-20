package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private String cpf;
    private String nomeDoCliente;
    private Date data;
    private Double valorTotal;

    private List<ProdutoQuantidade> produtos;

    private Boolean baixaPagamento;

    public Pedido() {
    }

    public Pedido(String cpf, String nomeDoCliente, ArrayList<ProdutoQuantidade> produtos) {
        this.cpf = cpf;
        this.nomeDoCliente = nomeDoCliente;
        this.data = new Date();
        this.produtos = produtos;
        double somador = 0;
        for(ProdutoQuantidade produto: produtos) {
            somador = somador + (produto.getQuantidade() * produto.getValorUnitario());
        }
        this.valorTotal = somador;
        this.baixaPagamento = false;
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

    public void addProduto(ProdutoQuantidade novoProduto) {
        this.produtos.add(novoProduto);
    }

    public Boolean getBaixaPagamento() { return baixaPagamento; }

    public void setBaixaPagamento(Boolean baixaPagamento) {
        this.baixaPagamento = baixaPagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cpf='" + cpf + '\'' +
                ", nomeDoCliente='" + nomeDoCliente + '\'' +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
