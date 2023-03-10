import javax.swing.JOptionPane;

class Vector {

    private Lista[] v;
    private int n;

    public Vector() {
        v = new Lista[100];
        n = 0;
    }

    public void setDim(int d) {
        n = d;
    }

    public int getDim() {
        return n;
    }

    public void setElem(Lista x, int pos) {
        v[pos] = x;
    }

    public Lista getElem(int pos) {
        return v[pos];
    }

    private boolean vacia() {
        return n == 0;
    }

    private boolean llena() {
        return n == 100;
    }

    public void insertar(Lista x, int p) {
        if (llena()) {
            JOptionPane.showMessageDialog(null, "Vector lleno..!!!");
            return;
        }

        if (p < 0 || p > n) {
            JOptionPane.showMessageDialog(null, "Posición no válida..!!!");
            return;
        } else {
            int k = n - 1;
            while (k >= p) {
                v[k + 1] = v[k];
                k = k - 1;
            }
            v[p] = x;
            n = n + 1;
        }
    }

    public void insertarPri(Lista x) {
        insertar(x, 0);
    }

    public void insertarUlt(Lista x) {
        insertar(x, n);
    }

    public void eliminar(int pos) {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "Vector vacio...!!");
            return;
        }

        int k = pos + 1;
        while (k < n) {
            v[k - 1] = v[k];
            k = k + 1;
        }
        n = n - 1;
    }

    public void eliminarPri() {
        eliminar(0);
    }

    public void eliminarUlt() {
        eliminar(n - 1);
    }

    // 3. Invertir todos los elementos de las subListas correspondientes a cada posición del vector
    public void invertir(){
        invertirListas(0, n);
    }
    private void invertirListas(int pos, int tam) {
        if(pos < tam){
            getElem(pos).invertirLista();
            invertirListas(pos + 1, tam);
        }
    }
    
}//end class