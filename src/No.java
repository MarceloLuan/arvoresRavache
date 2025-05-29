public class No {
    String valor;
    No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    //função adicionar nó à esquerda
    public void adicionarEsquerda(No no) {
        this.esquerda = no;
    }
    //função adicionar nó à direita
    public void adicionarDireita(No no) {
        this.direita = no;
    }
    //função para retornar o valor do nó
    public String getValor() {
        return valor;
    }
    //função para retornar o nó da esquerda
    public No getEsquerda() {
        return esquerda;
    }
    //função para retornar o nó da direita
    public No getDireita() {
        return direita;
    }
    //função para definir o valor do nó
    public void setValor(String valor) {
        this.valor = valor;
    }
    //função para definir o nó da esquerda
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
    //função para definir o nó da direita
    public void setDireita(No direita) {
        this.direita = direita;
    }

}
