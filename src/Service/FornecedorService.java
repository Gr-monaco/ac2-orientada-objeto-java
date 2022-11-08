package Service;

import Classes.Fornecedor;

import java.util.ArrayList;
import java.util.Scanner;

public class FornecedorService {

    public Fornecedor criaFornecedor(Scanner scanner) {        
        System.out.println("Insira um nome:");
        String nome = scanner.nextLine();
        System.out.println("Insira  CPNJ:");
        String CNPJ = scanner.nextLine();

        return new Fornecedor(nome, CNPJ);
    }

    public void listaFornecedores(Scanner scanner, ArrayList<Fornecedor> listaDeFornecedores){
        System.out.println("Fornecedores: ");
        for (Fornecedor fornecedor : listaDeFornecedores) {
            System.out.println("[Nome: "+fornecedor.getNome()+" CNPJ: "+fornecedor.getCNPJ()+"]");
        }
        
        scanner.nextLine();
    }
}
