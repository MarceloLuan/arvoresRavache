enum Cor{
    VERMELHO, PRETO
}


public class NoRubroNegra {
    int valor;
    NoRubroNegra esquerda, direita, pai;
    Cor cor;


    public NoRubroNegra(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = Cor.VERMELHO;
    }
}
