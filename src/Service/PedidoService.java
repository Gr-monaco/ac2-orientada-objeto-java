package Service;

import Classes.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
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
    Cliente clienteEscolhido = clientes.get(opcao-1);
    pedido.setCliente(clienteEscolhido);

    System.out.println("Escolha um ano: ");
    int ano = Integer.parseInt(scanner.nextLine());
    System.out.println("Digite um mes: ");
    int mes = Integer.parseInt(scanner.nextLine());
    System.out.println("Digite um dia");
    int dia = Integer.parseInt(scanner.nextLine());

    Calendar calendar = Calendar.getInstance();
    // tem que ser mes-1 por causa de como é feito a estrutura
    calendar.set(ano, mes-1, dia);
    pedido.setData(calendar.getTime());

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

  public void pedidosEntreDatas(Scanner scanner, ArrayList<Pedido> bancoDeDadosDePedidos){
    System.out.println("Escolha a data inicial: ");
    System.out.println("DIA: ");
    int diaInicial = Integer.parseInt(scanner.nextLine());
    System.out.println("MES: ");
    int mesInicial = Integer.parseInt(scanner.nextLine());
    System.out.println("ANO: ");
    int anoInicial = Integer.parseInt(scanner.nextLine());

    System.out.println("Escolha a data final: ");
    int diaFinal = Integer.parseInt(scanner.nextLine());
    System.out.println("MES: ");
    int mesFinal = Integer.parseInt(scanner.nextLine());
    System.out.println("ANO: ");
    int anoFinal = Integer.parseInt(scanner.nextLine());

    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.set(anoInicial, mesInicial-1, diaInicial);
    cal2.set(anoFinal, mesFinal-1, diaFinal);

    for(int i = 0; i < bancoDeDadosDePedidos.size(); i++){
      if(bancoDeDadosDePedidos.get(i).getData().after(cal1.getTime()) && bancoDeDadosDePedidos.get(i).getData().before(cal2.getTime())){
        System.out.println("[ ("+ i +") " + bancoDeDadosDePedidos.get(i).toString()+" ]");
      }
    }
    System.out.println("Aperte qualquer tecla para continuar...");
    scanner.nextLine();

  }

  public void calcularValorTotalDePedidosAbertos(Scanner scanner, ArrayList<Pedido> bancoDeDadosDePedidos){
    double soma = bancoDeDadosDePedidos.stream().filter(pedido -> !pedido.getBaixaPagamento())
                                                .map(Pedido::getValorTotal)
                                                .reduce(0.0d, Double::sum);
    System.out.format("Valor total dos pedidos abertos: RS:%.2f\n", soma);
    System.out.println("Aperte uma tecla para continuar...");
    scanner.nextLine();
  }
}
