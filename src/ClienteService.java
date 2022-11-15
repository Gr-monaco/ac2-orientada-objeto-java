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
    System.out.println("""
        [1] - Pessoa Física
        [2]  - Juridica
        """);
    String escolha = scanner.nextLine().replaceAll("\\[", "").replaceAll("]", "");  
    if(escolha=="1"){
      return this.criaClientePessoaFisica(scanner);
    } else if (escolha=="2"){
      return this.criaClientePessoaJuridica(scanner);
    }else{ //Isso vai fazer o menu aparecer de novo caso não escolha uma
           //opção valida, não é mto elegante mas deve funcionar
      return this.escolherTipoDeCliente(scanner);
    }
  }
}
