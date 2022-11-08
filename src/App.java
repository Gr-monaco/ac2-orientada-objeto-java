import java.util.ArrayList;
import java.util.Scanner;

import Classes.Fornecedor;
import Service.FornecedorService;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Fornecedor> bancoDeDadosDeFornecedores = new ArrayList<>();
        boolean exit = Boolean.FALSE;
        FornecedorService fornecedorService = new FornecedorService();
        Scanner scanner = new Scanner(System.in);
        while (!exit){

            //O codigo abaixo limpa o console
            //Incompativel com o Output do IntelliJ
            //https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000585870-Clear-IntelliJ-console-from-java
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.printf("%1s Menu %2s%n", "#".repeat(5), "#".repeat(5));
            System.out.print("""
                    [1] - Cadastra fornecedor
                    [10] - Sai do Programa
                    Opcao:\s""");

            String escolha = scanner.nextLine().replaceAll("\\[", "").replaceAll("]", "");
            switch (escolha) {
                case "s" -> exit = Boolean.TRUE;
                case "1" -> {
                    bancoDeDadosDeFornecedores.add(fornecedorService.criaFornecedor(scanner));
                }
                case "f" -> System.out.println("Fornecedor");
                default -> {
                    System.out.println("Escolha invalida\n" +
                            "Aperte qualquer tecla...");
                    scanner.nextLine();
                }
            }
        }
    }
}
