package Service;

import Classes.Fornecedor;

import java.util.Scanner;

public class FornecedorService {

    public Fornecedor criaFornecedor() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um nome:");
        String nome = scanner.nextLine();
        System.out.println("Insira  CPNJ:");
        String CNPJ = scanner.nextLine();

        scanner.close();

        return new Fornecedor(nome, CNPJ);
    }
}
