import java.util.LinkedList;
import java.util.Queue;
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

    //método para percorrer em nível
    public void emNivel(No no){
        if(raiz == null){
            return;
        }
        Queue<No> fila = new LinkedList<>();//criação da fila
        fila.add(raiz);//adicionar o valor da raiz

        while(!fila.isEmpty()){//quando não for vazia
            No atual = fila.poll();//retira o nó da fila e mostra o valor
            System.out.print(atual.valor + " ");//mostra valor do nó atual na tela
            if(atual.esquerda != null){
                fila.add(atual.esquerda);//adiciona o nó esquerdo na fila
            }
            if(atual.direita != null){
                fila.add(atual.direita);//adiciona o nó direito na fila
            }
            /*
            Estudando o caso, a fila é recomendada pois tudo que quero adicionar primeiro,
            quero que mostre primeiro, e o loop while funciona assim, se não estiver vazia,
            ele vai tirar o valor do nó atual e mostrar, logo depois adiciona os nós,
            para que na volta do loop ele mostrar esses nós adicionados
             */
        }
    }

}
