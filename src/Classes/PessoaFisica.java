package Classes;

import java.util.Scanner;

public class PessoaFisica extends Cliente{
  private String CPF;

  public PessoaFisica(String nome, String email, String CPF) {
    super(nome, email);
    this.CPF = CPF;
  }

  public String getCPF() {
    return this.CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  @Override
  public void changeId(String id) {
    System.out.println("Insira o CPF: ");
    Scanner scanner = new Scanner(System.in);
    String CPF = scanner.nextLine();
    //TODO: Validador de CPF
    setCPF(CPF);
    scanner.close();
  }

  @Override
  public String toString() {
    return "[Nome: "+ this.getNome() + " email: " + this.getEmail() + " CPF: " + this.getCPF() +"]";
  }
}
