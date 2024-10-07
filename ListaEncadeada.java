class ListaEncadeada {
    Voo primeiro;
    int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
    }


    public Voo obterVooPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição fora dos limites da lista.");
        }

        Voo atual = primeiro;
        int contador = 0;

        // Percorre a lista até a posição desejada
        while (contador < posicao && atual != null) {
            atual = atual.proximo;
            contador++;
        }

        return atual; // Retorna o voo na posição
    }
    

    // Adiciona um novo voo à lista
    public void adicionarVoo(int indiceOrigem, int indiceDestino, int numeroVoo) {
        Voo novoVoo = new Voo(indiceOrigem, indiceDestino, numeroVoo);
        novoVoo.proximo = primeiro;
        primeiro = novoVoo;
        tamanho++;
    }

    // Remove um voo pelo número
    public void removerVoo(int numeroVoo) {
        Voo atual = primeiro;
        Voo anterior = null;
        tamanho--;
        while (atual != null) {
            if (atual.numeroVoo == numeroVoo) {
                if (anterior == null) {
                    primeiro = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    // Lista todos os voos
    public void listarVoos(String[] exibirAeroportos) {
        Voo atual = primeiro;
        while (atual != null) {
            System.out.println("Voo número " + atual.numeroVoo + " para " + exibirAeroportos[atual.indiceDestino]);
            atual = atual.proximo;
        }
    }
}
