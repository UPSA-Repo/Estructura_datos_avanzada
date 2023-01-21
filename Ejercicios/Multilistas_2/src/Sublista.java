
public class Sublista {

    private Subnodo primero;
    private int cantidad;

    public Sublista() {
        primero = null;
        cantidad = 0;
    }

    public boolean vacia2() {
        return primero == null;
    }

    public void setCant2(int c) {
        cantidad = c;
    }

    public int getCant2() {
        return cantidad;
    }

    public Subnodo Primero2() {
        return primero;
    }

    public Subnodo crearNodo(int x, Subnodo p) {
        Subnodo q = new Subnodo(x, p);
        return q;
    }

    public void insertarPrimero2(int x) {
        Subnodo q = crearNodo(x, primero);
        primero = q;
        cantidad++;
    }

    public void insertarUltimo2(int x) {
        if (vacia2()) {
            insertarPrimero2(x);
        } else {
            Subnodo p = primero;
            while (p.getProx2() != null) {
                p = p.getProx2();
            }

            Subnodo q = crearNodo(x, null);
            p.setProx2(q);

            cantidad++;
        }
    }

}//end clase
