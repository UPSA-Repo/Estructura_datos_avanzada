
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    private boolean esHoja(Nodo pr) {
        return pr.getHI() == null && pr.getHD() == null;
    }

    public void insertar(int x) {
        Nodo q = new Nodo(x);
        if (raiz == null) {
            raiz = q;
            return;
        }
        Nodo pr = raiz;
        Nodo ant = null;
        while (pr != null) {
            ant = pr;
            if (x < pr.getElem()) {
                pr = pr.getHI();
            } else if (x > pr.getElem()) {
                pr = pr.getHD();
            } else {
                return;
            }
        }
        if (x < ant.getElem()) {
            ant.setHI(q);
        } else {
            ant.setHD(q);
        }
    }

    private void preOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            rt.append(String.valueOf(pr.getElem() + "  "));
            preOrden(pr.getHI(), rt);
            preOrden(pr.getHD(), rt);
        }
    }

    public void preOrden(JTextArea rt) {
        preOrden(raiz, rt);
    }

    private void InOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            InOrden(pr.getHI(), rt);
            rt.append(String.valueOf(pr.getElem() + "  "));
            InOrden(pr.getHD(), rt);
        }
    }

    public void InOrden(JTextArea rt) {
        InOrden(raiz, rt);
    }

    // -----EXAMEN-----
    // Realizar un método que obtenga la suma de los elementos que conforman el contorno del árbol de un elemento X
    public void sumarContorno() {
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Contorno de: "));
        sumarContorno(raiz, x);
    }

    private void sumarContorno(Nodo nodo, int x) {
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }

        while (nodo != null) {
            if (nodo.getElem() == x) {
                int suma = 0;

                Nodo aux = nodo.getHI();
                while (aux != null) {
                    suma += aux.getElem();
                    aux = aux.getHI();
                }
                aux = nodo.getHD();
                while (aux != null) {
                    suma += aux.getElem();
                    aux = aux.getHD();
                }
                JOptionPane.showMessageDialog(null, "Contorno: " + (suma + nodo.getElem()));
                return;
            }
            if (nodo.getElem() < x) 
                nodo = nodo.getHD(); 
            else
                nodo = nodo.getHI();
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
    }
}//end class

