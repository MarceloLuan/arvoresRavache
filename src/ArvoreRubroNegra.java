public class ArvoreRubroNegra {
    private NoRubroNegra raiz;
    private final NoRubroNegra NIL;

    public ArvoreRubroNegra() {
        NIL = new NoRubroNegra(-1);
        NIL.cor = Cor.PRETO;
        NIL.esquerda = NIL.direita = NIL.pai = null;
        raiz = NIL;
    }

    //criando rotação à direita para rubro negra
    public NoRubroNegra rotacaoEsquerda(NoRubroNegra x){
        NoRubroNegra y = x.direita;
        x.direita = y.esquerda;
        if(y.esquerda != NIL) {
            y.esquerda.pai = x;
        }

        y.pai = x.pai;

        if(x.pai == null) {
            this.raiz = y; //se o nó for raiz, atualiza a raiz
        } else if(x == x.pai.esquerda) {
            x.pai.esquerda = y; //se o nó for filho esquerdo, atualiza o filho esquerdo do pai
        } else {
            x.pai.direita = y; //se o nó for filho direito, atualiza o filho direito do pai
        }

        y.esquerda = x;
        x.pai = y;
    }

    //método rotação direita rubro negra
    public NoRubroNegra rotacaoDireita(NoRubroNegra y){
        NoRubroNegra x = y.esquerda;
        y.esquerda = x.direita;

        if(x.esquerda != NIL) {
            x.direita.pai = y;
        }

        x.pai = y.pai;

        if(y.pai == null) {
            this.raiz = x; //se o nó for raiz, atualiza a raiz
        } else if(y == y.pai.direita) {
            y.pai.direita = x; //se o nó for filho direito, atualiza o filho direito do pai
        } else {
            y.pai.esquerda = x; //se o nó for filho esquerdo, atualiza o filho esquerdo do pai
        }

        x.direita = y;
        y.pai = x;
    }

    //método de inserção rubro negra
    public void inserir(int valor){
        NoRubroNegra novoNo = new NoRubroNegra(valor);
        if(this.raiz == null) {
            this.raiz = novoNo;
            this.raiz.cor = NoRubroNegra.cor.preto;
            return;
        }
        NoRubroNegra pai = null;
        NoRubroNegra atual = this.raiz;


    }

}
