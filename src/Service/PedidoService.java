package Service;

import Classes.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidoService {
  public Pedido criaPedido(Scanner scanner, ArrayList<Produto> produtos, ArrayList<Cliente> clientes){
    Pedido pedido = new Pedido();

    System.out.println("Escolha um cliente: ");
    int contador = 1;
    for(Cliente cliente : clientes){
      System.out.println("[("+contador+" "+ cliente.toString()+" ]");
      contador++;
    }

    int opcao = Integer.parseInt(scanner.nextLine());
    Cliente clienteEscolhido = clientes.get(opcao);
    pedido.setCliente(clienteEscolhido);


    ArrayList<ProdutoQuantidade> produtosDoPedido = new ArrayList<>();


    int continuar = 1;
    while(continuar == 1) {
      System.out.println("Escolha um produto:");
      for(int i = 0; i < produtos.size(); i++){
        System.out.println("["+(i+1)+"] - " + produtos.get(i).getNome());
      }
      System.out.println("Escolha um numero: ");
      int escolha = Integer.parseInt(scanner.nextLine());
      System.out.println("Escolha a quantidade: ");
      int quantidade = Integer.parseInt(scanner.nextLine());

      Produto novoProduto = produtos.get(escolha-1);
      ProdutoQuantidade novoProdutoPedido = new ProdutoQuantidade(novoProduto.getNome(),novoProduto.getValorUnitario(),
                                                        novoProduto.getDescricao(), novoProduto.getFornecedor(),
                                                        quantidade);
      //novoProduto.setQuantidade(quantidade);

      produtosDoPedido.add(novoProdutoPedido);

      System.out.println("Deseja adicionar mais produtos?");
      System.out.println("1 - sim");
      System.out.println("2 - nao");
      continuar = Integer.parseInt(scanner.nextLine());
    }
    pedido.setProdutos(produtosDoPedido);
    return pedido;
  }
  public Pedido baixarPedido(Scanner scanner, ArrayList<Pedido> bancoDeDadosDePedidos) {
    System.out.println("Insira o pedido que deseja realizar a baixa: ");
    for(int i = 0; i < bancoDeDadosDePedidos.size(); i++) {
      if (!bancoDeDadosDePedidos.get(i).getBaixaPagamento()) {
        System.out.println("[ID ("+i+") -  "+ bancoDeDadosDePedidos.get(i).getCliente().getNome()+" - R$"+ bancoDeDadosDePedidos.get(i).getValorTotal()+"]");
      }
    }
    int baixa = Integer.parseInt(scanner.nextLine());
    bancoDeDadosDePedidos.get(baixa).setBaixaPagamento(true);
    System.out.println("Baixa do pedido realizaada com sucesso");
    scanner.nextLine();
    return bancoDeDadosDePedidos.get(baixa);
  }

  public Pedido buscarPedido(Scanner scanner, ArrayList<Pedido> bancoDeDadosDePedidos){
    System.out.println("Insira o ID do pedido que deseja buscar");
    int opcao = Integer.parseInt(scanner.nextLine());

    try {
      Pedido pedido = bancoDeDadosDePedidos.get(opcao);
      System.out.println("Cliente: " +pedido.getCliente() + " Valor total: "+ pedido.getValorTotal());
      for (ProdutoQuantidade produtos: pedido.getProdutos()) {
        System.out.println("PRODUTO: " + produtos.getNome() + " QUANTIDADE: "+produtos.getQuantidade());
      }
      System.out.println("DATA: "+ pedido.getData());
      System.out.println("STATUS: "+ (pedido.getBaixaPagamento() ? "PAGO" : "ABERTO"));
    }catch (Exception exception){
      System.out.println("Sem pedido com este ID");
    }
    System.out.println("Digite qualquer tecla para continuar...");
    scanner.nextLine();
    return new Pedido();
  }

  public void listarPedidos(Scanner scanner, ArrayList<Pedido> bancoDeDadosDePedidos){
    for(int i = 0; i < bancoDeDadosDePedidos.size(); i++){
      System.out.println("[ ("+ i +") " + bancoDeDadosDePedidos.get(i).toString()+" ]");
    }
    System.out.println("Digite qualquer tecla para continuar");
    scanner.nextLine();
  }
}
