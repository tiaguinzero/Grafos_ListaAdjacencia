import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        try {
            grafo.adicionarAeroporto("SP", "88");
            grafo.adicionarAeroporto("RJ", "71");
            grafo.adicionarAeroporto("MG", "66");
            grafo.adicionarAeroporto("GO", "55");
            grafo.adicionarVoo("88", "71", 1);
            grafo.adicionarVoo("71", "66", 2);
            grafo.adicionarVoo("66", "55", 3);
            grafo.adicionarVoo("55", "66", 4);
        } catch (Exception e) {
            System.out.println("Erro ao inicializar aeroportos e voos: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n=======MENU=======");
            System.out.println("1. Adicionar aeroporto"); //
            System.out.println("2. Adicionar voo"); //
            System.out.println("3. Remover voo"); //
            System.out.println("4. Listar aeroportos"); //
            System.out.println("5. Listar voos de um aeroporto"); //
            System.out.println("6. Listar trajetos entre aeroportos"); //
            System.out.println("7. Sair"); //
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do aeroporto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o código do aeroporto: ");
                        String codigo = scanner.nextLine();
                        grafo.adicionarAeroporto(nome, codigo);
                        System.out.println("Aeroporto adicionado com sucesso!");
                        break;
                    case 2:
                        System.out.print("Digite o código do aeroporto de origem: ");
                        String codigoOrigem = scanner.nextLine();
                        System.out.print("Digite o código do aeroporto de destino: ");
                        String codigoDestino = scanner.nextLine();
                        System.out.print("Digite o número do voo: ");
                        int numeroVoo = scanner.nextInt();
                        grafo.adicionarVoo(codigoOrigem, codigoDestino, numeroVoo);
                        System.out.println("Voo adicionado com sucesso!");
                        break;

                    case 3:
                        System.out.print("Digite o código do aeroporto de origem: ");
                        String codigoOrigemRemover = scanner.nextLine();
                        System.out.print("Digite o número do voo a ser removido: ");
                        int numeroVooRemover = scanner.nextInt();
                        
                        try {
                            grafo.removerVoo(codigoOrigemRemover, numeroVooRemover);
                            System.out.println("Voo removido com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro ao remover voo: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("Lista de aeroportos:");
                        grafo.listarAeroportos();  // Chama o método listarAeroportos no grafo
                        break;

                    case 5:
                        System.out.print("Digite o código do aeroporto: ");
                        String codigoListar = scanner.nextLine();
                        Aeroporto aeroportoListar = grafo.encontrarAeroporto(codigoListar);
                        if (aeroportoListar != null) {
                            System.out.println("Voos do aeroporto " + aeroportoListar.getNome() + ":");
                            // Exiba os voos
                            aeroportoListar.getListaVoos().listar();
                        } else {
                            System.out.println("Aeroporto não encontrado.");
                        }
                        break;

                    case 6:
                        System.out.print("Digite o código do aeroporto de origem: ");
                        String codigoTrajetoOrigem = scanner.nextLine();
                        System.out.print("Digite o código do aeroporto de destino: ");
                        String codigoTrajetoDestino = scanner.nextLine();
                        grafo.listarTrajetos(codigoTrajetoOrigem, codigoTrajetoDestino);
                        break;

                    case 7:
                        System.out.println("Saindo...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
