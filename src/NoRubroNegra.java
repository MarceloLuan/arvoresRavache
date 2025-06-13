public class NoRubroNegra {
    //criar nó para árvore rubro-negra
    int valor;
    NoRubroNegra esquerda, direita;
    //criar enumerador
    enum cor{
        vermelho, preto
    };
    int altura;

    public NoRubroNegra(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}
