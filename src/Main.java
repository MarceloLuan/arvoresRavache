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
        //contando os nós da árvore
        int totalNos = arvore.contarNos(arvore.raiz);
        System.out.println("Total de nós na árvore: " + totalNos);
        //contando os nós da árvore de forma iterativa
        int totalNosIterativo = arvore.contarNosIterativo();
        System.out.println("Total de nós na árvore (iterativo): " + totalNosIterativo);
        //contando as folhas da árvore
        int totalFolhas = arvore.contagemFolhas(arvore.raiz);
        System.out.println("Total de folhas na árvore: " + totalFolhas);
        //contando as folhas da árvore de forma iterativa
        int totalFolhasIterativo = arvore.contagemFolhasIterativo();
        System.out.println("Total de folhas na árvore (iterativo): " + totalFolhasIterativo);

    }
}