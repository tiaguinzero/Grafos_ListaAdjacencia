public class ListaEncadeada<T> {
    public No<T> inicio;

    // Classe interna para representar os nós da lista encadeada
    public static class No<T> {
        T dado;
        No<T> proximo;

        // Construtor para nós genéricos
        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    // Método para adicionar um elemento à lista encadeada
    public void adicionar(T dado) {
        No<T> novoNo = new No<>(dado);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Método para remover um elemento da lista
    public void remover(T dado) {
        if (inicio == null) return;

        if (inicio.dado.equals(dado)) {
            inicio = inicio.proximo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null && !atual.proximo.dado.equals(dado)) {
                atual = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo = atual.proximo.proximo;
            }
        }
    }

    // Método para listar todos os elementos da lista
    public void listar() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado.toString());
            atual = atual.proximo;
        }
    }
    public No<T> getInicio() {
        return inicio;
    }

}
