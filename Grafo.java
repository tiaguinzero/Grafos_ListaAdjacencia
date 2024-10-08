public class Grafo {
    private ListaEncadeada<Aeroporto> listaAeroportos; //armazena

    public Grafo() {
        this.listaAeroportos = new ListaEncadeada<>();
    }
    //adiciona aeroporto
    public void adicionarAeroporto(String nome, String codigo) throws Exception {
        if (nome == null || nome.isEmpty() || codigo == null || codigo.isEmpty()) {
            throw new Exception("Nome ou código de aeroporto inválido.");
        }
        if (encontrarAeroporto(codigo) != null) {
            throw new Exception("Aeroporto já existe.");
        }
        listaAeroportos.adicionar(new Aeroporto(nome, codigo));
    }

    //adiciona voo entre dois aeroportos 
    public void adicionarVoo(String codigoOrigem, String codigoDestino, int numeroVoo) throws Exception {
        Aeroporto origem = encontrarAeroporto(codigoOrigem);
        if (origem == null) {
            throw new Exception("Aeroporto de origem não encontrado.");
        }
        if (numeroVoo <= 0) {
            throw new Exception("Número do voo inválido.");
        }
        origem.getListaVoos().adicionar(new Voo(codigoDestino, numeroVoo));
    }

    public void removerVoo(String codigoOrigem, int numeroVoo) throws Exception {
        Aeroporto origem = encontrarAeroporto(codigoOrigem);
        if (origem == null) {
            throw new Exception("Aeroporto de origem não encontrado.");
        }
    
        ListaEncadeada<Voo> listaVoos = origem.getListaVoos();
        ListaEncadeada.No<Voo> atual = listaVoos.getInicio();
        boolean vooRemovido = false;
    
        while (atual != null) {
            if (atual.dado.getNumeroVoo() == numeroVoo) {
                listaVoos.remover(atual.dado);
                vooRemovido = true;
                break;
            }
            atual = atual.proximo;
        }
    
        if (vooRemovido) {
            System.out.println("Voo " + numeroVoo + " removido com sucesso.");
        } else {
            throw new Exception("Voo não encontrado.");
        }
    }

    public void listarAeroportos() {
        System.out.println("Aeroportos cadastrados:");
        ListaEncadeada.No<Aeroporto> atual = listaAeroportos.inicio;
        while (atual != null) {
            System.out.println("Nome: " + atual.dado.getNome() + ", Código: " + atual.dado.getCodigo());
            atual = atual.proximo;
        }
    }
    

    //lista trajetos do de um aeroporto
    public void listarTrajetos(String codigoOrigem, String codigoDestino) throws Exception {
        Aeroporto origem = encontrarAeroporto(codigoOrigem);
        Aeroporto destino = encontrarAeroporto(codigoDestino);

        if (origem == null || destino == null) {
            throw new Exception("Aeroporto de origem ou destino não encontrado.");
        }

        System.out.println("Trajetos de " + origem.getNome() + " para " + destino.getNome() + ":");
        buscarTrajeto(origem, destino, new ListaEncadeada<>(), 0);
    }

    // Método recursivo que busca trajetos diretos e indiretos entre aeroportos
    private void buscarTrajeto(Aeroporto origem, Aeroporto destino, ListaEncadeada<Aeroporto> caminho, int nivel) {
        // Adiciona o aeroporto atual ao caminho
        caminho.adicionar(origem);
        
        // Se o aeroporto de origem é o destino, imprime o caminho
        if (origem.equals(destino)) {
            imprimirCaminho(caminho, nivel);
        } else {
            // Obtém a lista de voos do aeroporto de origem
            ListaEncadeada<Voo> voos = origem.getListaVoos();
            ListaEncadeada.No<Voo> atualVoo = voos.getInicio();

            // Percorre todos os voos a partir da origem
            while (atualVoo != null) {
                // Encontra o próximo aeroporto no caminho usando o código do destino
                Aeroporto proxAeroporto = encontrarAeroporto(atualVoo.dado.getDestino()); // Corrigido para usar getDestino
                // Se o próximo aeroporto não estiver no caminho atual, continua a busca
                if (proxAeroporto != null && !existeNoCaminho(caminho, proxAeroporto)) {
                    buscarTrajeto(proxAeroporto, destino, caminho, nivel + 1);
                }
                atualVoo = atualVoo.proximo;
            }
        }
        // Remove o aeroporto atual ao voltar na recursão
        caminho.remover(origem);
    }

    // Método que verifica se um aeroporto já está no caminho (para evitar loops)
    private boolean existeNoCaminho(ListaEncadeada<Aeroporto> caminho, Aeroporto aeroporto) {
        ListaEncadeada.No<Aeroporto> atual = caminho.getInicio();
        // Percorre o caminho verificando se o aeroporto já foi visitado
        while (atual != null) {
            if (atual.dado.equals(aeroporto)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Método que imprime o caminho encontrado
    private void imprimirCaminho(ListaEncadeada<Aeroporto> caminho, int nivel) {
        StringBuilder sb = new StringBuilder("Caminho " + (nivel + 1) + ": ");
        ListaEncadeada.No<Aeroporto> atual = caminho.getInicio();
        // Concatena os nomes dos aeroportos no caminho
        while (atual != null) {
            sb.append(atual.dado.getNome()).append(" -> ");
            atual = atual.proximo;
        }
        // Remove a última seta "->" e imprime o caminho
        System.out.println(sb.substring(0, sb.length() - 4));
    }

    // Método para encontrar um aeroporto na lista usando o código
    public Aeroporto encontrarAeroporto(String codigo) {
        ListaEncadeada.No<Aeroporto> atual = listaAeroportos.inicio;
        // Percorre a lista de aeroportos até encontrar o que tem o código desejado
        while (atual != null) {
            if (atual.dado.getCodigo().equals(codigo)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null; // Retorna null se o aeroporto não for encontrado
    }
}
