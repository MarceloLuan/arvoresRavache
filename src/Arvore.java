import java.util.Stack;

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


    //método para percorrer os nós da árvore em pré-ordem
    public void preOrdem(No no) {
        if (no != null) {//se o nó for nulo significa que não existe mais nós para percorrer
            System.out.print(no.valor + " ");//primeiro exibe o valor do nó
            preOrdem(no.esquerda);//segundo exibe valor da sub-árvore esquerda
            preOrdem(no.direita);//terceiro exibe valor da sub-árvore direita
        }
    }


    //método para percorrer em ordem
    public void emOrdem(No no) {
        if (no != null) {//se for vazia fim do percurso
            emOrdem(no.esquerda);//percorrer em ordem a sub-árvore esquerda
            System.out.println(no.valor + " ");//exibir o valor do nó
            emOrdem(no.direita);//percorrer em ordem a sub-árvore direita
        }
    }

    //método para percorrer em pós-ordem sendo recursivo
    public void posOrdem(No no){
        if(no != null){//se for vazio fim
            posOrdem(no.esquerda);//percorrer em pos ordem sub-árvore esquerda
            posOrdem(no.direita);//percorrer em pos ordem a sub-árvore direita
            System.out.println(no.valor + " ");//exibir o valor do nó
        }
    }


}
