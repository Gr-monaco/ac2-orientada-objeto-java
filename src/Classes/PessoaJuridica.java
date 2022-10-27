package Classes;

import java.util.Scanner;

public class PessoaJuridica extends Cliente{

    private String CNPJ;

    public PessoaJuridica(String nome, String email, String CNPJ) {
        super(nome, email);
        this.CNPJ = CNPJ;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public void changeId(String id) {
        System.out.println("Insira o CNPJ: ");
        Scanner scanner = new Scanner(System.in);
        String CNPJ = scanner.nextLine();
        setCNPJ(CNPJ);
        scanner.close();
    }
}
