import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Sistema de Gerenciamento de Malha Aérea =====");
            System.out.println("1. Adicionar Aeroporto"); //* 
            System.out.println("2. Adicionar Voo"); //* 
            System.out.println("3. Remover Voo"); //* 
            System.out.println("4. Listar Voos de um Aeroporto");
            System.out.println("5. Listar Todos os Aeroportos"); //*
            System.out.println("6. Listar Trajetos (Diretos e Indiretos) entre dois Aeroportos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    adicionarAeroporto(grafo, scanner);
                    break;
                case 2:
                    adicionarVoo(grafo, scanner);
                    break;
                case 3:
                    removerVoo(grafo, scanner);
                    break;
                case 4:
                    listarVoos(grafo, scanner);
                    break;
                case 5:
                    listarTodosAeroportos(grafo);
                    break;
                case 6:
                    listarTrajetos(grafo, scanner);
                    break;
                case 7:
                    running = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    // Função para adicionar um aeroporto
    private static void adicionarAeroporto(Grafo grafo, Scanner scanner) {
        System.out.print("Digite o nome do aeroporto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código do aeroporto: ");
        String codigo = scanner.nextLine();
        
        try {
            grafo.adicionarAeroporto(nome, codigo);
            System.out.println("Aeroporto " + nome + " adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar aeroporto: " + e.getMessage());
        }
    }

    // Função para adicionar um voo
    private static void adicionarVoo(Grafo grafo, Scanner scanner) {
        System.out.print("Digite o código do aeroporto de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Digite o código do aeroporto de destino: ");
        String destino = scanner.nextLine();
        System.out.print("Digite o número do voo: ");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        
        try {
            grafo.adicionarVoo(origem, destino, numeroVoo);
            System.out.println("Voo adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar voo: " + e.getMessage());
        }
    }

    // Função para remover um voo
    private static void removerVoo(Grafo grafo, Scanner scanner) {
        System.out.print("Digite o código do aeroporto de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Digite o número do voo a ser removido: ");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        
        try {
            grafo.removerVoo(origem, numeroVoo);
            System.out.println("Voo removido com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao remover voo: " + e.getMessage());
        }
    }

    // Função para listar voos de um aeroporto
    private static void listarVoos(Grafo grafo, Scanner scanner) {
        System.out.print("Digite o código do aeroporto: ");
        String codigo = scanner.nextLine();
        
        try {
            grafo.listarVoos(codigo);
        } catch (Exception e) {
            System.out.println("Erro ao listar voos: " + e.getMessage());
        }
    }

    // Função para listar todos os aeroportos
    private static void listarTodosAeroportos(Grafo grafo) {
        System.out.println("Lista de todos os aeroportos:");
        grafo.listarTodosAeroportos();
    }

    // Função para listar trajetos diretos e indiretos entre aeroportos
    private static void listarTrajetos(Grafo grafo, Scanner scanner) {
        System.out.print("Digite o código do aeroporto de origem: ");
        String origem = scanner.nextLine();
        System.out.print("Digite o código do aeroporto de destino: ");
        String destino = scanner.nextLine();
        
        try {
            grafo.listarTrajetos(origem, destino);
        } catch (Exception e) {
            System.out.println("Erro ao buscar trajetos: " + e.getMessage());
        }
    }
}
