class MalhaAerea {
    Aeroporto[] aeroportos;
    int numAeroportos;

    public MalhaAerea(int capacidade) {
        aeroportos = new Aeroporto[capacidade];
        numAeroportos = 0;
    }

    // Cadastrar um novo aeroporto
    public void cadastrarAeroporto(String nome, String codigo) {
        aeroportos[numAeroportos] = new Aeroporto(nome, codigo);
        numAeroportos++;
    }

    // Encontrar o índice de um aeroporto pelo código
    public int buscarAeroportoPorCodigo(String codigo) {
        for (int i = 0; i < numAeroportos; i++) {
            if (aeroportos[i].codigo.equals(codigo)) {
                return i;
            }
        }
        return -1; //não encotrou
    }

    // Cadastrar um voo entre dois aeroportos
    public void cadastrarVoo(String codigoOrigem, String codigoDestino, int numeroVoo) {
        int indiceOrigem = buscarAeroportoPorCodigo(codigoOrigem);
        int indiceDestino = buscarAeroportoPorCodigo(codigoDestino);

        if (indiceOrigem != -1 && indiceDestino != -1) {
            aeroportos[indiceOrigem].voos.adicionarVoo(indiceDestino, numeroVoo);
        }
    }

    // Remover um voo pelo número
    public void removerVoo(String codigoOrigem, int numeroVoo) {
        int indiceOrigem = buscarAeroportoPorCodigo(codigoOrigem);

        if (indiceOrigem != -1) {
            aeroportos[indiceOrigem].voos.removerVoo(numeroVoo);
        }
    }

    // Listar todos os voos saindo de um aeroporto
    public void listarVoos(String codigoOrigem) {
        int indiceOrigem = buscarAeroportoPorCodigo(codigoOrigem);

        if (indiceOrigem != -1) {
            System.out.println("Voos saindo de " + aeroportos[indiceOrigem].nome + ":");
            aeroportos[indiceOrigem].voos.listarVoos(obterNomesAeroportos());
        }
    }

    // retorna um array para usar em outros métodos
    public String[] obterNomesAeroportos() {
        String[] nomes = new String[numAeroportos];
        for (int i = 0; i < numAeroportos; i++) {
            nomes[i] = aeroportos[i].nome;
        }
        return nomes;
    }

    // retorna uma array para o terminal
    public void exibirAeroportos() {
        System.out.println("=== Aeroportos Cadastrados ===");
        
        // Verifica se existem aeroportos cadastrados
        if (numAeroportos == 0) {
            System.out.println("Nenhum aeroporto cadastrado.");
            return;
        }
    
        // Percorre e exibe os aeroportos cadastrados
        for (int i = 0; i < numAeroportos; i++) {
            Aeroporto aeroporto = aeroportos[i];
            System.out.println(aeroporto.codigo + " - " + aeroporto.nome);
        }
    }
    

    // Listar trajetos possíveis de um aeroporto até outro (diretos ou indiretos)
    public void listarTrajetos(String codigoOrigem, String codigoDestino) {
    }
}
