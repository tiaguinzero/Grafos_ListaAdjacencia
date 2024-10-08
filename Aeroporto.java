public class Aeroporto {
    private String nome;
    private String codigo;
    private ListaEncadeada<Voo> listaVoos;

    public Aeroporto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaVoos = new ListaEncadeada<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public ListaEncadeada<Voo> getListaVoos() {
        return listaVoos;
    }

    @Override
    public String toString() {
        return "Aeroporto: " + nome + " (" + codigo + ")";
    }
}