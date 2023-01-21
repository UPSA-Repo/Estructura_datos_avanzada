
public class Subnodo {

    private int elem;
    private Subnodo prox;

    public Subnodo(int x, Subnodo p) {
        elem = x;
        prox = p;
    }

    public void setElem2(int x) {
        elem = x;
    }

    public int getElem2() {
        return elem;
    }

    public void setProx2(Subnodo p) {
        prox = p;
    }

    public Subnodo getProx2() {
        return prox;
    }
}
