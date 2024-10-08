public class ListaEncadeada {
    public No inicio; // Alterado para public

    // Classe interna para representar os nós da lista encadeada
    public class No { // Alterado para public
        Aeroporto aeroporto; // Para aeroportos
        Voo voo;             // Para voos
        No proximo;

        // Construtor para aeroportos
        public No(Aeroporto aeroporto) {
            this.aeroporto = aeroporto;
            this.proximo = null;
        }

        // Construtor para voos
        public No(Voo voo) {
            this.voo = voo;
            this.proximo = null;
        }
    }

    // Método para adicionar um aeroporto à lista encadeada
    public void adicionarAeroporto(String nome, String codigo) {
        Aeroporto novoAeroporto = new Aeroporto(nome, codigo);
        No novoNo = new No(novoAeroporto);
        
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Método para remover um aeroporto da lista
    public void removerAeroporto(String codigo) {
        if (inicio == null) return;

        if (inicio.aeroporto.getCodigo().equals(codigo)) {
            inicio = inicio.proximo;
        } else {
            No atual = inicio;
            while (atual.proximo != null && !atual.proximo.aeroporto.getCodigo().equals(codigo)) {
                atual = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo = atual.proximo.proximo;
            }
        }
    }

    // Método para listar todos os aeroportos
    public void listarAeroportos() {
        No atual = inicio;
        while (atual != null) {
            System.out.println("Aeroporto: " + atual.aeroporto.getNome() + " (" + atual.aeroporto.getCodigo() + ")");
            atual = atual.proximo;
        }
    }

    // Método para adicionar um voo à lista encadeada
    public void adicionarVoo(int destino, int numeroVoo) {
        Voo novoVoo = new Voo(destino, numeroVoo);
        No novoNo = new No(novoVoo);
        
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Método para remover um voo da lista baseado no número do voo
    public void removerVoo(int numeroVoo) {
        if (inicio == null) return;

        if (inicio.voo.getNumeroVoo() == numeroVoo) {
            inicio = inicio.proximo;
        } else {
            No atual = inicio;
            while (atual.proximo != null && atual.proximo.voo.getNumeroVoo() != numeroVoo) {
                atual = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo = atual.proximo.proximo;
            }
        }
    }

    // Método para listar todos os voos
    public void listarVoos() {
        No atual = inicio;
        while (atual != null) {
            System.out.println("Voo: " + atual.voo.getNumeroVoo() + ", Destino: " + atual.voo.getDestino());
            atual = atual.proximo;
        }
    }
}
