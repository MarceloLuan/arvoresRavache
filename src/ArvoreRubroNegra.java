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

    private void corrigirInsercao(NoRubroNegra k){
        while(k.pai != null && k.pai.cor == Cor.VERMELHO){
            if(k.pai == k.pai.pai.esquerda){
                NoRubroNegra u = k.pai.pai.direita;
                if(u.cor == Cor.VERMELHO) {
                    k.pai.cor = Cor.PRETO;
                    u.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    k = k.pai.pai;
                } else {
                    if(k == k.pai.direita) {
                        k = k.pai;
                        rotacaoEsquerda(k);
                    }
                    k.pai.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(k.pai.pai);
                }
            } else{
                NoRubroNegra u = k.pai.pai.esquerda;
                if(u.cor == Cor.VERMELHO) {
                    k.pai.cor = Cor.PRETO;
                    u.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    k = k.pai.pai;
                } else {
                    if(k == k.pai.esquerda) {
                        k = k.pai;
                        rotacaoDireita(k);
                    }
                    k.pai.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(k.pai.pai);
                }
            }
            if(k == this.raiz) {
                break;//se o nó for raiz, sai do loop
            }
            raiz.cor = Cor.PRETO;
        }
    }

    private void transplante(NoRubroNegra u, NoRubroNegra v){
        if(u.pai == null) {
            this.raiz = v;
        } else if(u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        v.pai = u.pai;
    }

    private NoRubroNegra minimo(NoRubroNegra no) {
        while(no.esquerda != NIL) {
            no = no.esquerda;
        }
        return no;
    }

    private void deletar(int valor){
        NoRubroNegra z = searchTree(raiz, valor);
        if(z != null) {
            return;
        }

        NoRubroNegra y = z;
        Cor yCorOriginal = y.cor;
        NoRubroNegra x;

        if(z.esquerda == NIL) {
            x = z.direita;
            transplante(z, z.direita);
        } else if(z.direita == NIL) {
            x = z.esquerda;
            transplante(z, z.esquerda);
        } else {
            y = minimo(z.direita);
            yCorOriginal = y.cor;
            x = y.direita;
            if(y.pai == z) {
                x.pai = y;
            } else {
                transplante(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }
            transplante(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cor = z.cor;
        }

        if(yCorOriginal == Cor.PRETO) {
            corrigirDelecao(x);
        }
    }

    private void corrigirDelecao(NoRubroNegra x) {
        NoRubroNegra w;
        while(x != this.raiz && x.cor == Cor.PRETO) {
            if(x == x.pai.esquerda) {
                w = x.pai.direita;
                if(w.cor == Cor.VERMELHO) {
                    w.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(x.pai);
                    w = x.pai.direita;
                }
                if(w.esquerda.cor == Cor.PRETO && w.direita.cor == Cor.PRETO) {
                    w.cor = Cor.VERMELHO;
                    x = x.pai;
                } else{
                    if (w.direita.cor == Cor.PRETO) {
                        w.esquerda.cor = Cor.PRETO;
                        w.cor = Cor.VERMELHO;
                        rotacaoDireita(w);
                        w = x.pai.direita;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    w.direita.cor = Cor.PRETO;
                    rotacaoEsquerda(x.pai);
                    x = this.raiz;
                }
            } else{
                w = x.pai.esquerda;
                if (w.cor == Cor.VERMELHO) {
                    w.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(x.pai);
                    w = x.pai.esquerda;
                }
                if (w.direita.cor == Cor.PRETO && w.esquerda.cor == Cor.PRETO) {
                    w.cor = Cor.VERMELHO;
                    x = x.pai;
                } else {
                    if (w.esquerda.cor == Cor.PRETO) {
                        w.direita.cor = Cor.PRETO;
                        w.cor = Cor.VERMELHO;
                        rotacaoEsquerda(w);
                        w = x.pai.esquerda;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    w.esquerda.cor = Cor.PRETO;
                    rotacaoDireita(x.pai);
                    x = this.raiz;
                }
            }
        }
        x.cor = Cor.PRETO;
    }

    private NoRubroNegra searchTree(NoRubroNegra no, int valor) {
        if(no == NIL || no.valor == valor) {
            return no;
        }
        if(valor < no.valor) {
            return searchTree(no.esquerda, valor);
        } else {
            return searchTree(no.direita, valor);
        }
    }

    public void emOrdem(){
        emOrdemHelper(raiz);
        System.out.println();
    }

    private void emOrdemHelper(NoRubroNegra no){
        if(no != NIL){
            emOrdemHelper(no.esquerda);
            String colorSuffix = (no.cor == Cor.VERMELHO) ? " R" : " B";
            System.out.print(no.valor + colorSuffix + " ");
            emOrdemHelper(no.direita);
        }
    }
}
