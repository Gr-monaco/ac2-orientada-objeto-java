package Service;

import Classes.Fornecedor;

import java.util.Scanner;

public class FornecedorService {

    public Fornecedor criaFornecedor(){
        System.out.println("Insira  CPNJ:");
        Scanner scanner = new Scanner(System.in);
        String CNPJ = scanner.nextLine();
        return new Fornecedor();
    }
}
