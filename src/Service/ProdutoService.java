package Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Classes.Fornecedor;
import Classes.Produto;

public class ProdutoService {
  public Produto cadastrarProduto(Scanner scanner, ArrayList<Fornecedor> listaDeFornecedores){
    System.out.println("Escreva um nome:");
    String nome = scanner.nextLine();
    System.out.println("Descrição:");
    String descricao = scanner.nextLine();
    System.out.println("Valor unitario:");
    //TODO: try catch
    Float valorUnitario = Float.parseFloat(scanner.nextLinelistagem()); // vai dar expection se não for float
    
    System.out.println("Escolha um fornecedor:");

    for(int i = 0; i < listaDeFornecedores.size(); i++){
      System.out.println("["+(i+1)+"] - " + listaDeFornecedores.get(i).getNome());
    }

    System.out.println("Escolha um numero: ");

    //TODO: try catch
    int escolha = Integer.parseInt(scanner.nextLine());

    Fornecedor fornecedorEscolhido = listaDeFornecedores.get(escolha-1);

    return new Produto(nome,valorUnitario,0, descricao, fornecedorEscolhido);
  }

  public void listarProdutos(Scanner scanner, ArrayList<Produto> listaDeProdutos){
    System.out.println("Produtos: ");
    for (Produto produto : listaDeProdutos) {
      System.out.println(produto.toString());
    }

    scanner.nextLine();
  }

  public Produto buscarProdutoPorNome(Scanner scanner, ArrayList<Produto> listaDeProdutos){
    System.out.println("Digite um nome: ");
    String nomeDoProduto  = scanner.nextLine();

    Produto produtoAchado = listaDeProdutos.stream()
    .filter(produto -> nomeDoProduto.equalsIgnoreCase(produto.getNome()))
    .findFirst()
    .orElse(null);

    if(Objects.nonNull(produtoAchado)){
      System.out.println(produtoAchado.toString());
    }else {
      System.out.println("Produto não encontrado");
    }
    
    scanner.nextLine();
    return produtoAchado;
  }
}
