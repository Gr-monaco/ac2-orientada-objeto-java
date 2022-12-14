package Service;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Cliente;
import Classes.PessoaFisica;
import Classes.PessoaJuridica;

public class ClienteService {
  public PessoaFisica criaClientePessoaFisica(Scanner scanner){
    System.out.println("Insira um nome:");
    String nome = scanner.nextLine();
    System.out.println("Insira um email:");
    String email = scanner.nextLine(); 
    System.out.println("Insira um CPF:");
    String cpf = scanner.nextLine();

    return new PessoaFisica(nome, email, cpf);

  }

  public PessoaJuridica criaClientePessoaJuridica(Scanner scanner){
    System.out.println("Insira um nome:");
    String nome = scanner.nextLine();
    System.out.println("Insira um email:");
    String email = scanner.nextLine(); 
    System.out.println("Insira um CNPJ:");
    String cnpj = scanner.nextLine();

    return new PessoaJuridica(nome, email, cnpj);
  }

  public Cliente escolherTipoDeCliente(Scanner scanner){
    System.out.println(
        "[1] - Pessoa Física\n" +
        "[2]  - Juridica\n"
        );
    String escolha = scanner.nextLine().replaceAll("\\[", "").replaceAll("]", "");  
    if(escolha.equals("1")){
      return this.criaClientePessoaFisica(scanner);
    } else if (escolha.equals("2")){
      return this.criaClientePessoaJuridica(scanner);
    }else{ //Isso vai fazer o menu aparecer de novo caso não escolha uma
           //opção valida, não é mto elegante mas deve funcionar
      return this.escolherTipoDeCliente(scanner);
    }
  }

  public void listarClientes(Scanner scanner, ArrayList<Cliente> listaDeClientes){
    System.out.println("Clientes: ");
    for(Cliente cliente : listaDeClientes){
      System.out.println(cliente.toString());
    }
    
    scanner.nextLine();
  }
}
