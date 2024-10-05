class Aeroporto {
    String nome;
    String codigo;
    ListaEncadeada voos;  // Lista de voos que saem deste aeroporto

    public Aeroporto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.voos = new ListaEncadeada();
    }
}
