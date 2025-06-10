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
        //valor tem que ser -1, 0 ou 1 para a árvore estar balanceada
    }

    //atualiza a altura do nó
    public void atualizarAltura(NoAVL no) {
        if (no != null) {
            no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
            //sobre o math.max, ele vai retornar o maior valor entre os dois valores passados
            //e o 1 é para considerar o nó atual na altura
        }
    }

    //criando a rotação à direita
    public NoAVL rotacaoDireita(NoAVL y){
        NoAVL x = y.esquerda;//x recebe o nó esquerdo de y
        NoAVL subArvoreDireitadeX = x.direita;//criar temporário para armazenar a subárvore direita de x

        x.direita = y;//atribuir nó inteiro
        y.esquerda = subArvoreDireitadeX;//atribuir nó inteiro

        atualizarAltura(y);//chamar a função previamente criada
        atualizarAltura(x);

        return x; //retorna o novo nó raiz
    }

    //criando rotação à esquerda
    public NoAVL rotacaoEsquerda(NoAVL x) {//ser espelho da outra rotação
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
            //não pode ter valor duplicado
            return no;
        }

        //atualiza a altura do nó após a inserção, que é o passo importante para manter a árvore balanceada
        atualizarAltura(no);

        //verifica o fator de balanceamento do nó
        int fatorBalanceamento = fatorBalanceamento(no);

        //verificar casos de desbalanceamento
        if(fatorBalanceamento > 1 && valor < no.esquerda.valor){
            //caso 1: rotação à direita
            return rotacaoDireita(no);
        }
        if(fatorBalanceamento < -1 && valor > no.direita.valor){
            //caso 2: rotação à esquerda
            return rotacaoEsquerda(no);
        }
        if(fatorBalanceamento > 1 && valor > no.esquerda.valor){
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if(fatorBalanceamento < -1 && valor < no.direita.valor){
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        //retorna o nó atualizado
        return no;
    }


}
