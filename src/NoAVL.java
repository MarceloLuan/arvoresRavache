public class NoAVL {
    //criação de um nó pra usar na árvore AVL
    String valor;
    NoAVL esquerda, direita;
    int altura; //altura do nó na árvore AVL, diferenciando do nó comum

    public NoAVL(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1; // altura inicial do nó é sempre 1, pois ele é a raiz da árvore
    }
}
