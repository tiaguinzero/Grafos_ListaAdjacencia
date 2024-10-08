public class Aeroporto {
    private String nome;
    private String codigo;
    private ListaEncadeada listaVoos;

    public Aeroporto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaVoos = new ListaEncadeada();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public ListaEncadeada getListaVoos() {
        return listaVoos;
    }
}
