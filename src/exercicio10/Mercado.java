package exercicio10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("--------------Bem-vindo ao Market Cataliza--------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("****** Selecione uma operação que deseja realizar ******");
        System.out.println("|   Opção 1 - Cadastrar   |");
        System.out.println("|   Opção 2 - Listar      |");
        System.out.println("|   Opção 3 - Comprar     |");
        System.out.println("|   Opção 4 - Excluir     |");
        System.out.println("|   Opção 5 - Sair        |");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                comprarProdutos();
                break;
            case 4:
                excluirProdutos();
            case 5:
                System.out.println("Volte sempre!");
                System.exit(0);

            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }
    }

    private static void cadastrarProdutos() {
        System.out.println("Nome do Produto: ");
        String nome = entrada.next();

        System.out.println("Preço do Produto: ");
        Double preco = entrada.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + " cadastrado com sucesso!");
        menu();
    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de Produtos!  \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }
        menu();
    }

    private static void comprarProdutos(){
        if (produtos.size() > 0){
            System.out.println("Código do produto: \n");

            System.out.println("--------------Produtos Disponíveis--------------");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }
            int id = Integer.parseInt(entrada.next());
            boolean sePresente = false;

            for(Produto p : produtos) {
                if(p.getId() == id){
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);
                        carrinho.put(p, qtd +1); // checando se o produto já está no carrinho, incrementa quantidade
                    }catch (NullPointerException e){
                        //se o produto for o primeiro no carrinho
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getNome() + "adicionado ao carrinho");
                    sePresente = true;

                    if(sePresente) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para SIM ou 0 para finalizar a compra. \n");
                        int opcao = Integer.parseInt(entrada.next());

                        if (opcao == 1){
                            comprarProdutos();
                        }else {
                            finalizarCompra();
                        }
                    }
                } else {
                    System.out.println("Produto não encontrado");
                    menu();
                }
            }
        }else {
            System.out.println("Não existem produtos cadastrados");
            menu();
        }
    }
    private static void excluirProdutos() {
        System.out.println("-----Produtos no seu carrinho! -----");
        if (carrinho.size() > 0){
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        }else {
                System.out.println("Carrinho vazio!");
        }
            menu();

    }

    private static void finalizarCompra(){
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos: ");

        for(Produto p : carrinho.keySet()){
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quantidade: " + qtd);
            System.out.println("-------------------");
        }
        System.out.println("O Valor da sua compra é: " + Utilitario.doubleToString(valorDaCompra));
        carrinho.clear();
        System.out.println("Obrigado pela preferência");
        menu();
    }
}
