package Service;

import Classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoService {
  public Pedido criaPedido(Scanner scanner, ArrayList<Produto> produtos){
    System.out.println("Insira um CPF do cliente:");
    String cpf = scanner.nextLine();
    System.out.println("Insira um nome do cliente:");
    String nome = scanner.nextLine();

    ArrayList<Produto> produtosDoPedido = new ArrayList<>();

    System.out.println("Escolha um produto:");
    for(int i = 0; i < produtos.size(); i++){
      System.out.println("["+(i+1)+"] - " + produtos.get(i).getNome());
    }
    int continuar = 1;
    while(continuar == 1) {
      System.out.println("Escolha um numero: ");
      int escolha = Integer.parseInt(scanner.nextLine());
      System.out.println("Escolha a quantidade: ");
      int quantidade = scanner.nextInt();

      Produto novoProduto = produtos.get(escolha-1);
      novoProduto.setQuantidade(quantidade);

      produtosDoPedido.add(novoProduto);

      System.out.println("Deseja adicionar mais produtos?");
      System.out.println("1 - sim");
      System.out.println("2 - nao");
      continuar = scanner.nextInt();
    }

    return new Pedido(cpf, nome, produtosDoPedido);
  }
}
