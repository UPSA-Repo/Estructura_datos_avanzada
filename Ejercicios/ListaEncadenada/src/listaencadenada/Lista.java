package listaencadenada;

import javax.swing.JOptionPane;

class Lista {

    private Nodo primero;
    private int cantidad;

    public Lista() {
        primero = null;
        cantidad = 0;
    }

    public boolean vacia() {
        return primero == null;
    }

    public void setCant(int c) {
        cantidad = c;
    }

    public int getCant() {
        return cantidad;
    }

    public Nodo Primero() {
        Nodo p = primero;
        return p;
    }

    public Nodo crearNodo(int x, Nodo p) {
        Nodo q = new Nodo(x, p);
        return q;
    }

    public void insertarPrimero(int x) {
        Nodo q = crearNodo(x, primero);
        primero = q;
        cantidad++;
    }

    public void insertarUltimo(int x) {
        if (vacia()) {
            insertarPrimero(x);
        } else {
            Nodo p = primero;
            while (p.getProx() != null) {
                p = p.getProx();
            }

            Nodo q = crearNodo(x, null);
            p.setProx(q);

            cantidad++;
        }
    }

    public void insertarPosicion(int x, int pos) {
        if (pos < 1 || pos > cantidad) {
            JOptionPane.showMessageDialog(null, "Posición fuera de rango..!!");
        } else {
            if (pos == 1) {
                insertarPrimero(x);
            } else {
                int i = 1;
                Nodo p = primero;
                while (i < pos - 1 && p != null) {
                    p = p.getProx();
                    i = i + 1;
                }
                Nodo q = crearNodo(x, p.getProx());
                p.setProx(q);
                cantidad++;
            }
        }
    }

    public void eliminarPrimero() {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "EliminarPrimero::Lista vacia..!!");
            return;
        }
        Nodo p = primero;
        primero = p.getProx();
        cantidad--;
    }

    public void eliminarUltimo() {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "EliminarUltimo::Lista vacia..!!");
        }

        if (cantidad == 1) {
            primero = null;
            cantidad = 0;
        } else {
            Nodo p = primero;
            Nodo ap = null;
            while (p.getProx() != null) {
                ap = p;
                p = p.getProx();
            }
            ap.setProx(null);
            cantidad--;
        }
    }

    //elimina el nodo apuntado por p y devuelve el proximo
    //nodo de ap, despues de eliminar
    public Nodo eliminarNodo(Nodo ap, Nodo p) {
        if (ap == null) {
            eliminarPrimero();
            return primero;
        } else {
            ap.setProx(p.getProx());
        }

        return (ap.getProx());
    }

    public void eliminarPosicion(int pos) {
        if (pos >= 1 && pos <= getCant()) {
            int k = 1;
            Nodo ap = null, p = primero;
            while (k < pos && p != null) {
                ap = p;
                p = p.getProx();
                k = k + 1;
            }
            if (p == null) {
                return;
            }

            if (ap == null) {
                primero = p.getProx();
            } else {
                ap.setProx(p.getProx());
            }

            cantidad--;
            //delete p
        } else {
            JOptionPane.showMessageDialog(null, "Fuera de posición..!!");
        }
    }

    public void eliminarTodo(int x) {
        Nodo p = primero, ap = null;
        while (p != null) {
            if (p.getElem() == x) {
                p = eliminarNodo(ap, p); //la direccion de memoria del sgte nodo
            } else {
                ap = p;
                p = p.getProx();
            }
        }
    }

    public void eliminarDup() {
        int i = 1;
        int j;
        while (i < getCant()) {
            j = i + 1;
            while (j <= getCant()) {
                if (getElemento(i) == getElemento(j)) {
                    eliminarPosicion(j);
                } else {
                    j++;
                }
            }
            i++;
        }
    }

    public void eliminarDuplicados() {
        Nodo p = primero;
        Nodo aq = null;
        while (p != null) {
            Nodo q = p.getProx();
            aq = p;
            while (q != null) {
                if (q.getElem() == p.getElem()) {
                    q = eliminarNodo(aq, q);
                    cantidad--;
                } else {
                    aq = q;
                    q = q.getProx();
                }
            }
            p = p.getProx();
        }
    }

    public int sumarLista() {
        Nodo p = primero;
        int s = 0;
        while (p != null) {
            s = s + p.getElem();
            p = p.getProx();
        }
        return s;
    }

    public int getElemento(int pos) {

        Nodo p = primero;
        int k = 1;
        while (k < pos && p != null) {
            p = p.getProx();
            k++;
        }
        return p.getElem();

    }

    public void rotarN(int n) {
        int x;
        for (int i = 1; i <= n; i++) {
            x = getElemento(getCant());
            this.insertarPrimero(x);
            this.eliminarUltimo();
        }
    }

    public void intercambiar(int i, int j) {
        int x = getElemento(i);
        int y = getElemento(j);
        int aux = x;
        x = y;
        y = aux;
        eliminarPosicion(i);
        eliminarPosicion(j);
        insertarPosicion(i, y);
        insertarPosicion(j, x);
    }

    public void invertir() {
        int i = 1;
        int j = getCant();
        while (i < j) {
            intercambiar(i, j);
            i++;
            j--;
        }
    }

    public int elementoMayor() {
        int mayor = primero.getElem();
        Nodo p = primero;
        while (p != null) {
            if (p.getElem() > mayor) {
                mayor = p.getElem();
            }
            p = p.getProx();
        }
        return mayor;
    }

    // METODOS RECURSIVOS
    public int sumar1() {
        return sumar1(cantidad);
    }

    private int sumar1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return primero.getElem();
        } else {
            return sumar1(n - 1) + getElemento(n);
        }
    }

    public int mayorRecursivo() {
        return mayorRecursivo(cantidad);
    }

    public int mayorRecursivo(int n) {
        if (n == 1) {
            return primero.getElem();
        } else {
            int mayor = mayorRecursivo(n - 1);
            if (getElemento(n) > mayor) {
                return getElemento(n);
            } else {
                return mayor;
            }
        }
    }

}//end clase
