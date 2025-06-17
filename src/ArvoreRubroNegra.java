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
    public void rotacaoEsquerda(NoRubroNegra x){
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
    public void rotacaoDireita(NoRubroNegra y){
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
        NoRubroNegra no = new NoRubroNegra(valor);
        no.esquerda = no.direita = no.pai = NIL;

        NoRubroNegra y = null;
        NoRubroNegra x = this.raiz;

        while(x != NIL) {
            y = x;
            if(no.valor < x.valor) {
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }

        no.pai = y;
        if(y == null){
            this.raiz = no;//se a árvore estiver vazia, o novo nó é a raiz
        } else if(no.valor < y.valor) {
            y.esquerda = no;//se o valor for menor, adiciona à esquerda
        } else {
            y.direita = no; //se o valor for maior, adiciona à direita
        }

        no.esquerda = NIL;
        no.direita = NIL;
        no.cor = Cor.VERMELHO;

        corrigirInsercao(no);
    }

}
