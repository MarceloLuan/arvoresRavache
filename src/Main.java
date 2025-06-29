public class Main {
    public static void main(String[] args) {
        //testando as funções da árvore
        Arvore arvore = new Arvore();
        No no1 = new No("A");
        No no2 = new No("B");
        No no3 = new No("C");
        No no4 = new No("D");

        //adicionando nós à árvore
        no1.adicionarEsquerda(no2);
        no1.adicionarDireita(no3);
        no2.adicionarEsquerda(no4);
        arvore.raiz = no1; // Definindo a raiz da árvore
        //chamando os métodos criados na árvore
        //chamar o contar nós
        int totalNos = arvore.contarNos(arvore.raiz);
        System.out.println("Total de nós na árvore: " + totalNos);
        //chamar o contar nós iterativo
        int totalNosIterativo = arvore.contarNosIterativo();
        System.out.println("Total de nós na árvore: " + totalNosIterativo);
        //chamar o contar folhas
        int totalFolhas = arvore.contagemFolhas(arvore.raiz);
        System.out.println("Total de folhas na árvore: " + totalFolhas);
        //chamar o contar folhas iterativo
        int totalFolhasIterativo = arvore.contagemFolhasIterativo();
        System.out.println("Total de folhas na árvore (iterativo): " + totalFolhasIterativo);
        //chamar o preOrdem
        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
        //chamar o preOrdem iterativo
        System.out.print("\nPré-ordem com iteração: ");
        arvore.preOrdemIterativo();
        //chamar o em ordem
        System.out.print("\nEm ordem: ");
        arvore.emOrdem(arvore.raiz);
        //chamar o em ordem iterativo
        System.out.print("\nEm ordem com iteração: ");
        arvore.emOrdemIterativo();
        //chamar o posOrdem
        System.out.print("\nPós-ordem: ");
        arvore.posOrdem(arvore.raiz);
        //chamar o posOrdem iterativo
        System.out.print("\nPós-ordem com iteração: ");
        arvore.posOrdemIterativo();
        //chamar o nivel
        System.out.print("\nNível: ");
        arvore.emNivel(arvore.raiz);

        /*System.out.println("\n Testando árvore AVL");
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        NoAVL noAVL1 = new NoAVL(10);
        NoAVL noAVL2 = new NoAVL(20);
        NoAVL noAVL3 = new NoAVL(30);
        NoAVL noAVL4 = new NoAVL(40);
        NoAVL noAVL5 = new NoAVL(50);
        NoAVL noAVL6 = new NoAVL(25);
        // Inserindo nós na árvore AVL
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, noAVL1.valor);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, noAVL2.valor);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, noAVL3.valor);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, noAVL4.valor);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, noAVL5.valor);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, noAVL6.valor);

         */

        ArvoreAVL arvoreAVL = new ArvoreAVL();

        int[] valores = {10, 20, 30, 40, 50, 25};

        for (int valor : valores) {
            arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, valor);
        }

        System.out.print("Árvore AVL percurso em ordem: ");
        arvoreAVL.emOrdem(arvoreAVL.raiz);
        arvoreAVL.raiz = arvoreAVL.remover(arvoreAVL.raiz, 30);

        ArvoreRubroNegra arvore = new ArvoreRubroNegra();

        int[] valores = {10, 20, 30, 40, 50, 25};
        for (int valor : valores) {
            arvore.inserir(valor);
        }
        System.out.print("Árvore Rubro-Negra percurso em ordem: ");
        arvore.emOrdem(arvore.raiz);

        arvore.deletar(30);

        System.out.print("\nÁrvore Rubro-Negra após remoção de 30: ");
        arvore.emOrdem(arvore.raiz);


    }
}