import java.util.Scanner;

import Classes.PessoaFisica;

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
}
