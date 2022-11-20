import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import Classes.*;
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
        bancoDeDadosDeClientes.add(new PessoaFisica("Arthur","arthur@gmail.com","113.985.990-00" ));
        bancoDeDadosDeClientes.add(new PessoaJuridica("Auto Peças", "pecasAuto@gmail.com", "66.018.594/0001-76"));

        ArrayList<Produto> bancoDeDadosDeProdutos = new ArrayList<>();
        bancoDeDadosDeProdutos.add(new Produto("Pilha Power",50f, "Pilhas super", bancoDeDadosDeFornecedores.get(0)));
        bancoDeDadosDeProdutos.add(new Produto("Engrenagem Grande", 25f, "Engrenagem de 25 partes", bancoDeDadosDeFornecedores.get(1)));

        ArrayList<Pedido> bancoDeDadosDePedidos = new ArrayList<>();
        ArrayList<ProdutoQuantidade> produtosPedido1 = new ArrayList<>();
        produtosPedido1.add(new ProdutoQuantidade("Pilha Power",50f, "Pilhas super", bancoDeDadosDeFornecedores.get(0), 5));
        produtosPedido1.add(new ProdutoQuantidade("Engrenagem Grande", 25f, "Engrenagem de 25 partes", bancoDeDadosDeFornecedores.get(1), 5));
        ArrayList<ProdutoQuantidade> produtosPedido2 = new ArrayList<>();
        produtosPedido2.add(new ProdutoQuantidade("Engrenagem Grande", 25f, "Engrenagem de 25 partes", bancoDeDadosDeFornecedores.get(1), 2));

        Calendar cal1 = Calendar.getInstance();
        cal1.set(2022, Calendar.DECEMBER,10);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2022, Calendar.DECEMBER,15);

        bancoDeDadosDePedidos.add(new Pedido(bancoDeDadosDeClientes.get(0), produtosPedido1, cal1.getTime()));
        bancoDeDadosDePedidos.add(new Pedido(bancoDeDadosDeClientes.get(1), produtosPedido2, cal2.getTime()));


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
            System.out.print("\n" +
                    "[1] - Cadastra fornecedor\n" +
                    "[2] - Cadastro de cliente\n" +
                    "[3] - Cadastro de produto\n" +
                    "[4] - Realizar pedido\n" +
                    "[5] - Baixa de pedido\n" +
                    "[6] - Busca pedido\n" +
                    "[L1] - Lista fornecedores\n" +
                    "[L2] - Lista clientes\n" +
                    "[L3] - Lista produtos\n" +
                    "[L4] - Lista pedidos\n" +
                    "[L5] - Lista pagos\n" +
                    "[P1] - Busca entre datas\n" +
                    "[10] - Sai do Programa\n" +
                    "Opcao:\n");

            String escolha = scanner.nextLine().replaceAll("\\[", "").replaceAll("]", "");
            switch (escolha) {
                case "s" : {
                    exit = Boolean.TRUE;
                    break;
                }
                case "1" : {
                    //Talvez criar uma função no service que faz a adição
                    bancoDeDadosDeFornecedores.add(fornecedorService.criaFornecedor(scanner));
                    break;
                }
                case "2" : {
                    bancoDeDadosDeClientes.add(clienteService.escolherTipoDeCliente(scanner));
                    break;
                }
                case "3" : {
                    bancoDeDadosDeProdutos.add(produtoService.cadastrarProduto(scanner, bancoDeDadosDeFornecedores));
                    break;
                }
                case "4" : {
                    bancoDeDadosDePedidos.add(pedidoService.criaPedido(scanner, bancoDeDadosDeProdutos, bancoDeDadosDeClientes));
                    break;
                }
                case "5" : {
                    pedidoService.baixarPedido(scanner, bancoDeDadosDePedidos);
                    break;
                }
                case "6" : {
                    pedidoService.buscarPedido(scanner, bancoDeDadosDePedidos);
                    break;
                }
                case "L1" : {
                    fornecedorService.listaFornecedores(scanner, bancoDeDadosDeFornecedores);
                    break;
                }
                case "L2" : {
                    clienteService.listarClientes(scanner, bancoDeDadosDeClientes);
                    break;
                }
                case "L3" : {
                    produtoService.listarProdutos(scanner, bancoDeDadosDeProdutos);
                    break;
                }
                case "L4" : {
                    pedidoService.listarPedidos(scanner, bancoDeDadosDePedidos);
                    break;
                }
                case "L5" : {
                    pedidoService.buscaPagos(scanner, bancoDeDadosDePedidos);
                    break;
                }
                case "P1" : {
                    pedidoService.pedidosEntreDatas(scanner, bancoDeDadosDePedidos);
                    break;
                }
                default : {
                    System.out.println("Escolha invalida\n" +
                            "Aperte qualquer tecla...");
                    scanner.nextLine();
                }
                case "10" : {
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                }
            }
        }
    }
}
