package exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Sistema {
    // método para receber os dados do usuário

    private static Scanner entradaDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }
//metodo para receber os dados de cadastro do prato:

    public static Prato cadastrarPrato() {
        String nome = entradaDados("Por favor, digite o nome do prato:").nextLine();
        //String  ingrediente = entradaDados("Por favor, digite os ingredientes: ").nextLine();
        List<Ingrediente> ingredientes = new ArrayList<>();
        boolean continua = true;
        while (continua) {
            String nomeIngrediente = entradaDados("Por favor, digite os ingredientes: ").nextLine();
            if (!Objects.equals(nomeIngrediente, "")) { //não entendi, mas aceitei a sugestão do intellij e deu certo.
                ingredientes.add(new Ingrediente(nomeIngrediente));
            } else {
                continua = false;
            }
        }

        return ServicoPrato.cadastrarPrato(nome, ingredientes);
    }
//metodo para receber o nome do prato a ser excluído

    public static void excluirPrato() {
        String nomePratoExcluido = entradaDados("Por favor, digite o nome do prato a ser excluído:").nextLine();
        ServicoPrato.excluirPrato(nomePratoExcluido);
    }

//método para exibir as opções do menu

    public static void menu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("--------------Bem-vindo ao Restaurante Cataliza--------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("| 1 - Cadastrar Prato              |");
        System.out.println("| 2 - Listar os Pratos Cadastrados |");
        System.out.println("| 3 - Excluir um Prato             |");
        System.out.println("| 4 - Sair do Sistema              |");

    }

    //método para executar o programa completo:

    public static boolean executar() {
        boolean operarMenu = true;

        while (operarMenu) {
            menu();
            System.out.println("---------------------------------------------------");
            int escolhaUsuario = entradaDados("****** Selecione uma operação que deseja realizar ******").nextInt();
            if (escolhaUsuario == 1) {
                Prato prato = new Prato();
                prato = cadastrarPrato();
                System.out.println("\n");
                System.out.println("Prato cadastrado com sucesso!");
                System.out.println("---------------------------------------");
                System.out.println("\n");
            } else if (escolhaUsuario == 2) {
                System.out.println("---------------------------------------");
                System.out.println("Pratos Cadastrados: ");
                ServicoPrato.exibirPratos();
                System.out.println("---------------------------------------");
            } else if (escolhaUsuario == 3) {
                String pratoExcluido = entradaDados("Por favor, digite o nome do prato a ser excluído: ").nextLine();
                ServicoPrato.excluirPrato(pratoExcluido);
                System.out.println("Prato excluído com sucesso!");
                System.out.println("---------------------------------------");
            } else if (escolhaUsuario == 4) {
                System.out.println("Obrigado(a) e até logo!");
                operarMenu = false;
            } else {
                System.out.println("Opção inválida!");
            }

        }
        return operarMenu;

    }

}
