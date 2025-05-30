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




    }
}