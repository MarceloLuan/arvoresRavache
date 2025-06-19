public class ArvoreAVL {
    public NoAVL raiz;

    public int altura(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    //calcula o fator de balanceamento do nó
    private int fatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    //atualiza a altura do nó
    private void atualizarAltura(NoAVL no) {
        if (no != null) {
            no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
        }
    }

    //criando a rotação à direita
    private NoAVL rotacaoDireita(NoAVL y){
        NoAVL x = y.esquerda;
        NoAVL subArvoreDireitadeX = x.direita;

        x.direita = y;
        y.esquerda = subArvoreDireitadeX;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    //criando rotação à esquerda
    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL subArvoreEsquerdadeY = y.esquerda;

        y.esquerda = x;
        x.direita = subArvoreEsquerdadeY;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    //criando o método de rotação dupla esquerda-direita
    private NoAVL rotacaoEsquerdaDireita(NoAVL no) {
        no.esquerda = rotacaoEsquerda(no.esquerda);
        return rotacaoDireita(no);
    }

    //criando o método de rotação dupla direita-esquerda
    private NoAVL rotacaoDireitaEsquerda(NoAVL no) {
        no.direita = rotacaoDireita(no.direita);
        return rotacaoEsquerda(no);
    }

    //inserir um novo nó na árvore AVL
    public NoAVL inserir(NoAVL no, int valor){
        if(no == null){
            return new NoAVL(valor);
        }

        if(valor < no.valor){
            no.esquerda = inserir(no.esquerda, valor);
        } else if(valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }

        atualizarAltura(no);

        int fatorBalanceamento = fatorBalanceamento(no);

        if(fatorBalanceamento > 1 && valor < no.esquerda.valor){
            return rotacaoDireita(no);
        }
        if(fatorBalanceamento < -1 && valor > no.direita.valor){
            return rotacaoEsquerda(no);
        }
        if(fatorBalanceamento > 1 && valor > no.esquerda.valor){
            return rotacaoEsquerdaDireita(no);
        }
        if(fatorBalanceamento < -1 && valor < no.direita.valor){
            return rotacaoDireitaEsquerda(no);
        }

        return no;
    }

    //método para encontrar o nó com o valor mínimo na subárvore
    private NoAVL encontrarMinimo(NoAVL no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    //método para remover um nó da árvore AVL
    public NoAVL remover(NoAVL no, int valor) {
        if (no == null) {
            return no;
        }

        if (valor < no.valor) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = remover(no.direita, valor);
        } else {
            if (no.esquerda == null || no.direita == null) {
                NoAVL temp = (no.esquerda != null) ? no.esquerda : no.direita;
                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                NoAVL temp = encontrarMinimo(no.direita);
                no.valor = temp.valor;
                no.direita = remover(no.direita, temp.valor);
            }
        }

        atualizarAltura(no);

        int fatorBalanceamento = fatorBalanceamento(no);

        if (fatorBalanceamento > 1 && fatorBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        if (fatorBalanceamento < -1 && fatorBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        if (fatorBalanceamento > 1 && fatorBalanceamento(no.esquerda) < 0) {
            return rotacaoEsquerdaDireita(no);
        }
        if (fatorBalanceamento < -1 && fatorBalanceamento(no.direita) > 0) {
            return rotacaoDireitaEsquerda(no);
        }

        return no;
    }

    //método para imprimir a árvore em ordem
    public void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }


}
