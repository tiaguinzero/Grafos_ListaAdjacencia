class ListaEncadeada {
    Voo primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    // Adiciona um novo voo à lista
    public void adicionarVoo(int indiceDestino, int numeroVoo) {
        Voo novoVoo = new Voo(indiceDestino, numeroVoo);
        novoVoo.proximo = primeiro;
        primeiro = novoVoo;
    }

    // Remove um voo pelo número
    public void removerVoo(int numeroVoo) {
        Voo atual = primeiro;
        Voo anterior = null;

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
