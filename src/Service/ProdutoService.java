package Service;

import java.util.ArrayList;
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
    Float valorUnitario = Float.parseFloat(scanner.nextLine()); // vai dar expection se não for float
    
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
}
