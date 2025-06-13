public class ArvoreRubroNegra {
    public NoRubroNegra raiz;

    public ArvoreRubroNegra() {
        this.raiz = null;
    }

    //criando rotação à direita para rubro negra
    public NoRubroNegra rotacaoEsquerda(NoRubroNegra no){
        NoRubroNegra y = no.direita;
        no.direita = y.esquerda;
        if (y.esquerda != null) {
            y.esquerda.pai = no;
        }

        y.pai = no.pai;

        if (no.pai == null) {
            this.raiz = y;//se o nó for raiz, atualiza a raiz
        } else if (no == no.pai.esquerda) {
            no.pai.esquerda = y;//se o nó for filho esquerdo, atualiza o filho esquerdo do pai
        } else {
            no.pai.direita = y;// se o nó for filho direito, atualiza o filho direito do pai
        }
        y.esquerda = no;
        no.pai = y;

        return y;
    }

    //método rotação direita rubro negra
    public NoRubroNegra rotacaoDireita(NoRubroNegra no){
        NoRubroNegra y = no.esquerda;
        no.esquerda = y.direita;
        if (y.direita != null) {
            y.direita.pai = no;
        }

        y.pai = no.pai;

        if (no.pai == null) {
            this.raiz = y;//se o nó for raiz, atualiza a raiz
        } else if (no == no.pai.direita) {
            no.pai.direita = y;//se o nó for filho direito, atualiza o filho direito do pai
        } else {
            no.pai.esquerda = y;//se o nó for filho esquerdo, atualiza o filho esquerdo do pai
        }
        y.direita = no;
        no.pai = y;

        return y;
    }

}
