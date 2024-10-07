class Voo {
    int indiceOrigem;
    int indiceDestino;  // Índice do aeroporto destino
    int numeroVoo;  // Número do voo
    Voo proximo;  // Próximo voo na lista encadeada

    public Voo(int indiceOrigem, int indiceDestino, int numeroVoo) {
        this.indiceOrigem = indiceOrigem;
        this.indiceDestino = indiceDestino;
        this.numeroVoo = numeroVoo;
        this.proximo = null;
    }
}
