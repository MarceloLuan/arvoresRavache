public class ArvoreAVL {
    public NoAVL raiz;

    public int altura(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    //calcula o fator de balanceamento do nó
    public int fatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    //atualiza a altura do nó
    public void atualizarAltura(NoAVL no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
            //pesquisando sobre o math.max, ele vai retornar o maior valor entre os dois valores passados
            //e o 1 é para considerar o nó atual na altura
        }
    }

    //criando a rotação à direita
    public NoAVL rotacaoDireita(NoAVL y){
        NoAVL x = y.esquerda;
        NoAVL subArvoreDireitadeX = x.direita

        x.direita = y;
        y.esquerda = subArvoreDireitadeX;

        atualizarAltura(y);
        atualizarAltura(x);

        return x; //retorna o novo nó raiz
    }

    //criando rotação à esquerda
    public NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL subArvoreEsquerdadeY = y.esquerda;

        y.esquerda = x;
        x.direita = subArvoreEsquerdadeY;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    //criando o método de rotação dupla esquerda-direita
    public NoAVL rotacaoEsquerdaDireita(NoAVL no) {
        no.esquerda = rotacaoEsquerda(no.esquerda);
        return rotacaoDireita(no);
    }

    //criando o método de rotação dupla direita-esquerda
    public NoAVL rotacaoDireitaEsquerda(NoAVL no) {
        no.direita = rotacaoDireita(no.direita);
        return rotacaoEsquerda(no);
    }

}
