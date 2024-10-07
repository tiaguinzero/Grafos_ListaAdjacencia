class Aeroporto {
    String nome;
    int codigo;
    ListaEncadeada voosChegando;  
    ListaEncadeada voosPartindo; // Lista de voos que saem deste aeroporto
    public Aeroporto(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.voosChegando = new ListaEncadeada();
        this.voosPartindo = new ListaEncadeada();
    }

    public Aeroporto(int codigo) {
        this.codigo = codigo;
        this.voosChegando = new ListaEncadeada();
        this.voosPartindo = new ListaEncadeada();
    }
}
