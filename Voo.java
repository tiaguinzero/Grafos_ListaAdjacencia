public class Voo {
    private String destino;   // Índice do aeroporto de destino
    private int numeroVoo; // Número do voo

    public Voo(String destino, int numeroVoo) {
        this.destino = destino;
        this.numeroVoo = numeroVoo;
    }

    public String getDestino() {
        return destino;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    @Override
    public String toString() {
        return "Voo: " + numeroVoo + ", Destino: " + destino;
    }
}