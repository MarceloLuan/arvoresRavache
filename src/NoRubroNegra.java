public class NoRubroNegra {
    //criar nó para árvore rubro-negra
    int valor;
    NoRubroNegra esquerda, direita, pai;
    cor corNo;
    enum cor{
        vermelho, preto
    };
    int altura;

    public NoRubroNegra(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.corNo = corNo.preto;
        this.altura = 1;
    }
}
