
public class Nodo {

    private Sublista elem;
    private Nodo prox;

    public Nodo() {
        prox = null;
    }

    public Nodo(Sublista x, Nodo p) {
        this.elem = x;
        this.prox = p;
    }

    public void setElem(Sublista x) {
        elem = x;
    }

    public Sublista getElem() {
        return elem;
    }

    public void setProx(Nodo p) {
        prox = p;
    }

    public Nodo getProx() {
        return prox;
    }
}
