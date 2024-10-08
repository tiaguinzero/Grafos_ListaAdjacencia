public class Grafo {
    private ListaEncadeada listaAeroportos;

    public Grafo() {
        this.listaAeroportos = new ListaEncadeada();
    }

    // Adiciona um novo aeroporto ao grafo
    public void adicionarAeroporto(String nome, String codigo) throws Exception {
        if (nome == null || nome.isEmpty() || codigo == null || codigo.isEmpty()) {
            throw new Exception("Nome ou código de aeroporto inválido.");
        }
        if (encontrarAeroporto(codigo) != null) {
            throw new Exception("Aeroporto já existe.");
        }
        listaAeroportos.adicionarAeroporto(nome, codigo);
    }

    // Adiciona um voo entre dois aeroportos
    public void adicionarVoo(String codigoOrigem, String codigoDestino, int numeroVoo) throws Exception {
        Aeroporto origem = encontrarAeroporto(codigoOrigem);
        Aeroporto destino = encontrarAeroporto(codigoDestino);

        if (origem == null || destino == null) {
            throw new Exception("Aeroporto de origem ou destino não encontrado.");
        }
        if (numeroVoo <= 0) {
            throw new Exception("Número do voo inválido.");
        }
        origem.getListaVoos().adicionarVoo(obterIndiceAeroporto(destino.getCodigo()), numeroVoo);
    }

    // Remove um voo de um aeroporto
    public void removerVoo(String codigoOrigem, int numeroVoo) throws Exception {
        Aeroporto origem = encontrarAeroporto(codigoOrigem);
        if (origem == null) {
            throw new Exception("Aeroporto de origem não encontrado.");
        }
        origem.getListaVoos().removerVoo(numeroVoo);
    }

    // Lista todos os voos de um aeroporto
    public void listarVoos(String codigoAeroporto) throws Exception {
        Aeroporto aeroporto = encontrarAeroporto(codigoAeroporto);
        if (aeroporto == null) {
            throw new Exception("Aeroporto não encontrado.");
        }
        aeroporto.getListaVoos().listarVoos();
    }

    // Lista todos os aeroportos
    public void listarTodosAeroportos() {
        listaAeroportos.listarAeroportos();
    }

    // Lista trajetos entre dois aeroportos, incluindo voos diretos e indiretos
    public void listarTrajetos(String codigoOrigem, String codigoDestino) throws Exception {
        Aeroporto origem = encontrarAeroporto(codigoOrigem);
        Aeroporto destino = encontrarAeroporto(codigoDestino);

        if (origem == null || destino == null) {
            throw new Exception("Aeroporto de origem ou destino não encontrado.");
        }

        System.out.println("Trajetos de " + origem.getNome() + " para " + destino.getNome() + ":");
        if (!buscarTrajeto(origem, destino)) {
            throw new Exception("Nenhum trajeto disponível.");
        }
    }

    // Método auxiliar para buscar trajetos entre dois aeroportos
    private boolean buscarTrajeto(Aeroporto origem, Aeroporto destino) {
        ListaEncadeada voos = origem.getListaVoos();
        ListaEncadeada.No atual = voos.inicio;

        while (atual != null) {
            Aeroporto proxAeroporto = encontrarAeroportoPorIndice(atual.voo.getDestino());
            if (proxAeroporto == destino || buscarTrajeto(proxAeroporto, destino)) {
                System.out.println("Voo direto de " + origem.getNome() + " para " + proxAeroporto.getNome());
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Encontra um aeroporto pelo código
    private Aeroporto encontrarAeroporto(String codigo) {
        ListaEncadeada.No atual = listaAeroportos.inicio;
        while (atual != null) {
            if (atual.aeroporto.getCodigo().equals(codigo)) {
                return atual.aeroporto;
            }
            atual = atual.proximo;
        }
        return null;
    }

    // Encontra um aeroporto pelo índice
    private Aeroporto encontrarAeroportoPorIndice(int indice) {
        int count = 0;
        ListaEncadeada.No atual = listaAeroportos.inicio;
        while (atual != null) {
            if (count == indice) {
                return atual.aeroporto;
            }
            count++;
            atual = atual.proximo;
        }
        return null;
    }

    // Obtém o índice de um aeroporto pelo código
    private int obterIndiceAeroporto(String codigo) {
        int indice = 0;
        ListaEncadeada.No atual = listaAeroportos.inicio;
        while (atual != null) {
            if (atual.aeroporto.getCodigo().equals(codigo)) {
                return indice;
            }
            indice++;
            atual = atual.proximo;
        }
        return -1;
    }
}
