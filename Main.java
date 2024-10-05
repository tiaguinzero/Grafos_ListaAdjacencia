import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MalhaAerea malha = new MalhaAerea(100);// Definindo capacidade inicial de 100 aeroportos

        // Aeroportos Iniciais
        malha.cadastrarAeroporto("Belo Horizonte", "88");
        malha.cadastrarAeroporto("Brasília", "67");
        malha.cadastrarAeroporto("Rio de Janeiro", "51");
        malha.cadastrarAeroporto("Salvador", "10");
        malha.cadastrarAeroporto("São Paulo", "95");

        while (true) {
            System.out.println("\n==== Menu de Opções ====");
            System.out.println("1. Cadastrar novo aeroporto");
            System.out.println("2. Cadastrar voo");
            System.out.println("3. Remover voo");
            System.out.println("4. Listar voos de um aeroporto");
            System.out.println("5. Listar trajetos entre aeroportos");
            System.out.println("6. Listas todos os aeroportos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    System.out.print("Nome do aeroporto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Código do aeroporto: ");
                    String codigo = scanner.nextLine();
                    malha.cadastrarAeroporto(nome, codigo);
                    System.out.println("Aeroporto cadastrado com sucesso.");
                    break;
                case 2:
                    System.out.print("Código do aeroporto de origem: ");
                    String origem = scanner.nextLine();
                    System.out.print("Código do aeroporto de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Número do voo: ");
                    int numeroVoo = scanner.nextInt();
                    malha.cadastrarVoo(origem, destino, numeroVoo);
                    System.out.println("Voo cadastrado com sucesso.");
                    break;
                case 3:
                    System.out.print("Código do aeroporto de origem: ");
                    origem = scanner.nextLine();
                    System.out.print("Número do voo: ");
                    numeroVoo = scanner.nextInt();
                    malha.removerVoo(origem, numeroVoo);
                    System.out.println("Voo removido com sucesso.");
                    break;
                case 4:
                    System.out.print("Código do aeroporto de origem: ");
                    origem = scanner.nextLine();
                    malha.listarVoos(origem);
                    break;
                case 5:
                    System.out.print("Código do aeroporto de origem: ");
                    origem = scanner.nextLine();
                    System.out.print("Código do aeroporto de destino: ");
                    destino = scanner.nextLine();
                    malha.listarTrajetos(origem, destino);
                    break;
                case 6:
                    malha.exibirAeroportos();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
