public class no {
    private int valor;
    private no proximo;

    public no(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public no getProximo() {
        return proximo;
    }
    public void setProximo(no proximo) {
        this.proximo = proximo;
    }
}
