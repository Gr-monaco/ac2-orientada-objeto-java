import java.util.Scanner;

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
}
