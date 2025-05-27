import org.w3c.dom.ls.LSOutput;

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

    //método iterativo para contar os nós da árvore
    public int contarNosIterativo() {
        if (raiz == null) {
            return 0;
        }
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        int contador = 0; //inicializa o contador de nós

        while (!pilha.isEmpty()) {//enquanto não for vazia
            No atual = pilha.pop();//retira o nó da pilha e retorna o valor
            contador++;//incrementa o contador de nós
            if (atual.direita != null) {
                pilha.push(atual.direita);//adiciona nó da direita
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);//adiciona nó da esquerda
            }
        }
        /*
        Uso de while para ir percorrendo e mostrando a pilha, e o contador vai incrementando
        */
        return contador;
    }

    //método para contar as folhas da árvore com iteratividade
    public int contagemFolhas(No no){
        if(no == null){//se for nulo não existe mais nós
            return 0;
        }
        if(no.esquerda == null && no.direita == null){
            // verificar no if se não tem os filhos
            return 1;
        }
        return contagemFolhas(no.esquerda) + contagemFolhas(no.direita);
    }

    //método agora usando iteratividade, contar as folhas da árvore
    public int contagemFolhasIterativo(){
        if(raiz == null){
            return 0;
        }
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        int contador = 0;

        while(!pilha.isEmpty()) {
            No atual = pilha.pop();
            //verifica se o nó atual tem filhos ou nn
            if(atual.esquerda == null && atual.direita == null){
                contador++;//incrementar o contador
            }
            //adiciona os nós da direita e esquerda na pilha
            if(atual.direita != null){
                pilha.push(atual.direita);
            }
            if(atual.esquerda != null){
                pilha.push(atual.esquerda);
            }
        }
        return contador;
    }

    //método para percorrer os nós da árvore em pré-ordem
    public void preOrdem(No no) {
        if (no != null) {//se o nó for nulo significa que não existe mais nós para percorrer
            System.out.print(no.valor + " ");//primeiro exibe o valor do nó
            preOrdem(no.esquerda);//segundo exibe valor da sub-árvore esquerda
            preOrdem(no.direita);//terceiro exibe valor da sub-árvore direita
        }
    }

    //método iterativo em pré-ordem, usando o LIFO para percorrer e mostrar os nós
    public void preOrdemIterativo(){
        if(raiz == null){
            return;
        }
        Stack<No> pilha = new Stack<>();//criar a pilha
        pilha.push(raiz);//push adiciona valor na raiz

        while(!pilha.isEmpty()){//enquanto não for vazia
            No atual = pilha.pop();//retira nó da fila e retorna o valor
            System.out.print(atual.valor + " ");//mostra o valor do nó atual da pilha
            //adicionando os nós da direita e esquerda na pilha
            if(atual.direita != null){
                pilha.push(atual.direita);//adiciona nó da direita, antes da esquerda
                //pois o LIFO tem que retirar o último nó adicionado
            }
            if(atual.esquerda != null){
                pilha.push(atual.esquerda);//adiciona nó da esquerda
            }
            /*
            Está entendido que adicionando o valor da direita primeiro, está correto pois
            o pop vai retirar o último valor adicionado primeiro, o esquerdo, assim como
            quero que seja com a travessia pré-ordem
             */
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

    //método iterativo em ordem, também irei usar LIFO
    public void emOrdemIterativo(){
        if(raiz == null){
            return;
        }
        Stack<No> pilha = new Stack<>();//criar a pilha
        No atual = raiz;//criar nó atual
        while(atual != null || !pilha.isEmpty()){//enquanto não for nulo ou pilha não for vazia
            while(atual != null){//enquanto o nó atual não for nulo
                pilha.push(atual);//adiciona o nó atual na pilha
                atual = atual.esquerda;//atualiza o nó atual para o nó da esquerda
            }
            atual = pilha.pop();//retira o nó da pilha e mostra o valor
            System.out.print(atual.valor + " ");//mostra o valor do nó
            atual = atual.direita;//nó atual agora vira o da direita

        }
        /*
        O método iterativo em ordem, enquanto o nó atual não for nulo,
        adiciona o nó atual na pilha, e atualiza o nó atual para o nó da esquerda,
        depois retira o nó da pilha e mostra o valor, e atualiza o nó atual para o nó da direita
        assim, o nó atual vai ser sempre o último nó adicionado na pilha, e o nó da esquerda
        vai ser sempre o primeiro nó adicionado na pilha, assim como o em ordem
         */
    }

    //método para percorrer em pós-ordem sendo recursivo
    public void posOrdem(No no){
        if(no != null){//se for vazio fim
            posOrdem(no.esquerda);//percorrer em pos ordem sub-árvore esquerda
            posOrdem(no.direita);//percorrer em pos ordem a sub-árvore direita
            System.out.println(no.valor + " ");//exibir o valor do nó
        }
    }
    //método iterativo pós-ordem
    public void posOrdemIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha1 = new Stack<>(); // Cria a pilha 1 para processar os nós
        Stack<No> pilha2 = new Stack<>(); // Cria a pilha 2 para armazenar os nós em ordem pós-ordem

        pilha1.push(raiz); // Adiciona a raiz na pilha 1

        while (!pilha1.isEmpty()) { // Enquanto a pilha 1 não estiver vazia
            No atual = pilha1.pop(); // Retira o nó da pilha 1
            pilha2.push(atual); // Adiciona o nó na pilha 2

            // adiciona os nós da esquerda e direita na pilha 1
            if (atual.esquerda != null) {
                pilha1.push(atual.esquerda);
            }
            if (atual.direita != null) {
                pilha1.push(atual.direita);
            }
        }

        //o loop vai adicionar os nós na pilha 2, e depois vai retirar
        while (!pilha2.isEmpty()) {
            No atual = pilha2.pop(); // Retira o nó da pilha 2
            System.out.print(atual.valor + " "); // Exibe o valor
        }

    }



    //método para percorrer em nível
    public void emNivel(No no){
        if(raiz == null){
            return;//se raiz é nula então árvore nem existe
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
