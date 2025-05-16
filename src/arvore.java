public class arvore {
    //criando uma classe que representa arvore
    private no raiz;

    public arvore() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        no novoNo = new no(valor);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            no atual = raiz;
            no pai = null;
            while (atual != null) {
                pai = atual;
                if (valor < atual.getValor()) {
                    atual = atual.getProximo();
                } else {
                    break;
                }
            }
            if (valor < pai.getValor()) {
                pai.setProximo(novoNo);
            } else {
                pai.setProximo(novoNo);
            }
        }
    }
}
