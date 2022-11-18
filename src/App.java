import java.util.ArrayList;
import java.util.Scanner;

import Classes.Cliente;
import Classes.Fornecedor;
import Classes.Pedido;
import Classes.Produto;
import Service.ClienteService;
import Service.FornecedorService;
import Service.PedidoService;
import Service.ProdutoService;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Fornecedor> bancoDeDadosDeFornecedores = new ArrayList<>();
        bancoDeDadosDeFornecedores.add(new Fornecedor("Pilhas Azul", "28.530.660/0001-01"));
        bancoDeDadosDeFornecedores.add(new Fornecedor("Engrenagens engenharia", "19.171.253/0001-56" ));

        ArrayList<Cliente> bancoDeDadosDeClientes = new ArrayList<>();
        ArrayList<Produto> bancoDeDadosDeProdutos = new ArrayList<>();
        Pedido pedido = new Pedido();
        bancoDeDadosDeProdutos.add(new Produto("Pilha Power",50f,"Pilhas super", bancoDeDadosDeFornecedores.get(0)));
        bancoDeDadosDeProdutos.add(new Produto("Engrenagem Grande", 25f, "Engrenagem de 25 partes", bancoDeDadosDeFornecedores.get(1)));

        boolean exit = Boolean.FALSE;
        FornecedorService fornecedorService = new FornecedorService();
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();
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
                    [2] - Cadastro de cliente
                    [3] - Cadastro de produto
                    [4] - Realizar pedido
                    [L1] - Lista fornecedores
                    [L2] - Lista clientes
                    [L3] - Lista produtos
                    [PN] - Produto por nome
                    [10] - Sai do Programa
                    Opcao:\s""");

            String escolha = scanner.nextLine().replaceAll("\\[", "").replaceAll("]", "");
            switch (escolha) {
                case "s" -> exit = Boolean.TRUE;
                case "1" -> {
                    //Talvez criar uma função no service que faz a adição
                    bancoDeDadosDeFornecedores.add(fornecedorService.criaFornecedor(scanner));
                }
                case "2" -> {
                    bancoDeDadosDeClientes.add(clienteService.escolherTipoDeCliente(scanner));
                }
                case "3" -> {
                    bancoDeDadosDeProdutos.add(produtoService.cadastrarProduto(scanner, bancoDeDadosDeFornecedores));
                }
                case "4" -> {
                    pedido = pedidoService.criaPedido(scanner, bancoDeDadosDeProdutos);
                }
                case "L1" -> {
                    fornecedorService.listaFornecedores(scanner, bancoDeDadosDeFornecedores);
                }
                case "L2" -> {
                    clienteService.listarClientes(scanner, bancoDeDadosDeClientes);
                }
                case "L3" -> {
                    produtoService.listarProdutos(scanner, bancoDeDadosDeProdutos);
                }
                case "PN" -> {
                    produtoService.buscarProdutoPorNome(scanner, bancoDeDadosDeProdutos);
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
