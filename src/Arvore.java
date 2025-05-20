public class Arvore {
    //criando uma classe que representa arvore
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    //método para contar os nós total da árvore
    public int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }


}
