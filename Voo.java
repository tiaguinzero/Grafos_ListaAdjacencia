class Voo {
    int indiceDestino;  // Índice do aeroporto destino
    int numeroVoo;  // Número do voo
    Voo proximo;  // Próximo voo na lista encadeada

    public Voo(int indiceDestino, int numeroVoo) {
        this.indiceDestino = indiceDestino;
        this.numeroVoo = numeroVoo;
        this.proximo = null;
    }
}
