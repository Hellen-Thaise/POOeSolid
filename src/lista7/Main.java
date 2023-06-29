package lista7;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        private static Scanner input = new Scanner(System.in);
        private static ArrayList<Pais> paises = new ArrayList<Pais>();

    public static void main(String[] args) {

            int opcao;
            do
            {
                opcao = menu();
                switch(opcao)
                {
                    case 1:
                        incluiPais();
                        break;
                    case 2:
                        paisesVizinhos();
                        break;
                    case 3:
                        densidadePopulacional();
                        break;
                    case 4:
                        sair();
                        break;

                }
            }while(opcao != 4);
        }

        private static int menu(){
            System.out.println();
            System.out.println("+============================+");
            System.out.println("|        O P Ç Õ E S         |");
            System.out.println("+============================+");
            System.out.println("| 1. Incluir País            |");
            System.out.println("| 2. Países são Vizinhos?    |");
            System.out.println("| 3. Densidade Populacional  |");
            System.out.println("| 4. Encerrar o Programa     |");

            System.out.println("+============================+");

            int opcao;
            do {
                try {
                    System.out.print("Digite a sua opção (1 a 4): ");
                    opcao = input.nextInt();
                }
                catch(Exception e)
                {
                    input.nextLine();
                    opcao = 0;
                }
            }while (opcao < 1 || opcao > 5);

            return opcao;
        }

        static void incluiPais()
        {
            Pais novo;
            String codigoISO;
            String nome;
            double tamanhoPopulacao;
            double dimensao;

            while(true) {
                System.out.println();
                System.out.println("----------------");
                System.out.println("Inclusão de País:");
                System.out.print("   Código ISO (ou 'Fim' para encerrar o programa): ");
                codigoISO = input.next();

                if (codigoISO.equalsIgnoreCase("fim"))
                    break;

                // verificar se país já foi inserido na lista
                if (buscaPais (codigoISO) != null) {
                    System.out.println("ERRO: País já cadastrado.");
                    continue;
                }
                System.out.print("   Nome.....: ");
                do {
                    nome = input.nextLine();
                }while (nome.isEmpty());


                do
                {
                    try{
                        System.out.print("   População: ");
                        tamanhoPopulacao = input.nextLong();
                    }
                    catch (Exception e) {
                        System.out.println(" Favor digitar um número inteiro.");
                        tamanhoPopulacao = -1;
                        input.nextLine();
                    }
                }while (tamanhoPopulacao < 0);

                System.out.print("   Área.....: ");
                dimensao = input.nextLong();

                novo = new Pais (codigoISO, nome, tamanhoPopulacao, dimensao);
                paises.add(novo);
            }
        }

        // verificar se país já foi inserido na lista
        private static Pais buscaPais (String codigo) {
            for (Pais p: paises) {
                if (p.getCodigoISO().equalsIgnoreCase(codigo)) {
                    return p;
                }
            }
            return null;
        }

        private static void paisesVizinhos()
        {
            String codigo;
            int i;
            boolean bFim = false;
            Pais p, p1 = null, p2 = null;

            while (true) {
                System.out.println();
                System.out.println("----------------");
                System.out.println("Indica se dois países são vizinhos:");

                i = 0;
                while (i < 2) {
                    System.out.print("   Código ISO do " + (i + 1) + "o. País(ou 'Fim' para encerrar): ");
                    codigo = input.next();
                    if (codigo.equalsIgnoreCase("fim"))
                    {
                        bFim = true;
                        break;
                    }

                    // verificar se país já foi inserido na lista
                    p = buscaPais (codigo);
                    if (p == null) {
                        System.out.println("ERRO: País não encontrado.");
                        continue;
                    }

                    if (i == 0)
                        p1 = p;
                    else
                        p2 = p;
                    ++i;
                }
                if (bFim)
                    break;

                // verifica se paises sao vizinhos
                System.out.print (p1.getCodigoISO() + " e " + p2.getCodigoISO());
                if (p1.seVizinho (p2))
                    System.out.println (" são vizinhos!");
                else
                    System.out.println (" não são vizinhos!");

            }
        }

        private static void densidadePopulacional()
        {
            String codigo;

            while (true) {
                System.out.println();
                System.out.println("----------------");
                System.out.println("Densidade Populacional:");

                System.out.print("   Código ISO do País(ou 'Fim' para encerrar): ");
                codigo = input.next();
                if (codigo.equalsIgnoreCase("fim"))
                    break;

                // verificar se país já foi inserido na lista
                Pais p = buscaPais (codigo);
                if (p == null) {
                    System.out.println("ERRO: País não encontrado.");
                    continue;
                }

                // mostra a densidade populacional do país
                System.out.println ("Densidade Populacional: " +
                        NumberFormat.getNumberInstance().format(p.densidade()) +
                        " habitantes / Km2");

            }
        }
        public static void sair(){
                System.out.println("Obrigado(a) e até logo!");

        }

}
