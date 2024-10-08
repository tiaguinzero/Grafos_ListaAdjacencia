public class Voo {
    private int destino;   // Índice do aeroporto de destino
    private int numeroVoo; // Número do voo

    public Voo(int destino, int numeroVoo) {
        this.destino = destino;
        this.numeroVoo = numeroVoo;
    }

    public int getDestino() {
        return destino;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }
}
