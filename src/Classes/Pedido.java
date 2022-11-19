package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private String cpf;
    private String nomeDoCliente;
    private Date data;
    private double valorTotal;

    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(String cpf, String nomeDoCliente, ArrayList<Produto> produtos) {
        this.cpf = cpf;
        this.nomeDoCliente = nomeDoCliente;
        this.data = new Date();
        this.produtos = produtos;
        double somador = 0;
        for(Produto produto: produtos) {
            somador = somador + (produto.getQuantidade() * produto.getValorUnitario());
        }
        this.valorTotal = somador;
        this.pago = false;
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

    public void addProduto(Produto novoProduto) {
        this.produtos.add(novoProduto);
    }

    public Pedido(boolean pago) {
        this.pago = pago;
    }

    private boolean pago;

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
