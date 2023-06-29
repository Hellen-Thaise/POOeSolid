package exercicio2;

import java.util.Scanner;

public class Sistema {
    //método para a entrada de dados

    private static Scanner entradaDados(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);

    }

    //método para receber a entrada de dados no cadastro de candidatos:
    public static Candidato adicionarCandidato() {
        String nome = entradaDados("Por favor digite o nome do candidato: ").nextLine();
        String numeroMatricula = entradaDados("Por favor, digite o número de matrícula do candidato: ").nextLine();
        double nota = entradaDados("Por favor, digite a nota do candidato: ").nextDouble();
        return ServicoCandidato.adicionarCandidato(nome, numeroMatricula, nota);
    }


    //método para receber a entrada de dados do método excluirCandidato
    public static void excluirCandidato() {
        String numeroMatricula = entradaDados("Por favor, digite o número de matrícula do candidato que deseja excluir: ").nextLine();
        ServicoCandidato.excluirCandidato(numeroMatricula);
    }


    //método para exibir as opções do menu
    public static void menu() {
        System.out.println("\n ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" *** Bem-vindo ao Sistema de Gerenciamento de Candidatos *** ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\n ");
        System.out.println("| 1 - Adicionar Candidatos          |");
        System.out.println("| 2 - Exibir candidatos cadastrados |");
        System.out.println("| 3 - Excluir um candidato          |");
        System.out.println("| 4 - Sair do Sistema               |");
    }
    //método para executar o programa completo

    public static boolean executar() {
        boolean operarMenu = true;
        while (operarMenu) {
            menu();
            int escolhaUsuario = entradaDados(" ***** Selecione uma opção que deseja realizar: *****").nextInt();
            if (escolhaUsuario == 1) {
                Candidato candidato = new Candidato();
                candidato = adicionarCandidato();
            } else if (escolhaUsuario == 2) {
                System.out.println("------------------------");
                System.out.println("Candidatos cadastrados: ");
                System.out.println("------------------------");
                ServicoCandidato.listarCandidatos();
            } else if (escolhaUsuario == 3) {
                String numeroMatricula = entradaDados("Por favor digite o número de matrícula do candidato:").nextLine();
                ServicoCandidato.excluirCandidato(numeroMatricula);
                System.out.println("Candidato excluído com sucesso!");
            } else if (escolhaUsuario == 4) {
                System.out.println("Obrigado(a), até logo!");
                operarMenu = false;
            } else {
                System.out.println("Opção inválida! Tente outra vez");
            }
        }
        return operarMenu;
    }
}
