import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean exit = Boolean.FALSE;
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
