
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Map;

class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    private boolean esHoja(Nodo pr) {
        return pr.getHI() == null && pr.getHD() == null;
    }

    public Nodo getRaiz() {
        return raiz;
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

    private Nodo insertarRec(Nodo pr, int x) {
        if (pr == null) {
            Nodo q = new Nodo(x);
            return q;
        }

        if (x < pr.getElem()) {
            pr.setHI(insertarRec(pr.getHI(), x));
        } else {
            pr.setHD(insertarRec(pr.getHD(), x));
        }

        return pr;
    }
    
    public void insertarR(int x) {
        raiz = insertarRec(raiz, x);
    }

    public void eliminarR(int x) {
        raiz = eliminarR(raiz, x);
    }

    //nfun
    public Nodo eliminarR(Nodo p, int x) {
        if (p == null) {
            return null;
        }

        if (x < p.getElem()) {
            p.setHI(eliminarR(p.getHI(), x));
        } else if (x > p.getElem()) {
            p.setHD(eliminarR(p.getHD(), x));
        } else {
            p = eliminarR(p, x);
        }

        return p;
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

    private void PostOrden(Nodo pr, JTextArea rt) {
        if (pr != null) {
            PostOrden(pr.getHI(), rt);
            PostOrden(pr.getHD(), rt);
            rt.append(String.valueOf(pr.getElem() + "  "));
        }
    }

    public void PostOrden(JTextArea rt) {
        PostOrden(raiz, rt);
    }

    private int suma(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) // no es necesario
        {
            return pr.getElem();
        } else {
            int hi = suma(pr.getHI());
            int hd = suma(pr.getHD());

            return hi + hd + pr.getElem();
        }
    }

    public int suma() {
        return suma(raiz);
    }

    private int sumaPares(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) //no es necesario
        {
            if (pr.getElem() % 2 == 0) {
                return pr.getElem();
            } else {
                return 0;
            }
        } else {
            int hi = sumaPares(pr.getHI());
            int hd = sumaPares(pr.getHD());
            if (pr.getElem() % 2 == 0) {
                return hi + hd + pr.getElem();
            } else {
                return hi + hd;
            }
        }
    }

    public int sumaPares() {
        return sumaPares(raiz);
    }

    private int contarPares(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) //no es necesario
        {
            if (pr.getElem() % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int hi = contarPares(pr.getHI());
            int hd = contarPares(pr.getHD());
            if (pr.getElem() % 2 == 0) {
                return hi + hd + 1;
            } else {
                return hi + hd;
            }
        }
    }

    public int contarPares() {
        return contarPares(raiz);
    }

    private int cantidad(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) //no es necesario
        {
            return 1;
        } else {
            int hi = cantidad(pr.getHI());
            int hd = cantidad(pr.getHD());
            return hi + hd + 1;
        }
    }

    public int cantidad() {
        return cantidad(raiz);
    }

    private int altura(Nodo ptr) {
        if (ptr == null) {
            return 0;
        } else if (esHoja(ptr)) //no es necesario
        {
            return 1;
        } else {
            int hi = altura(ptr.getHI());
            int hd = altura(ptr.getHD());
            if (hi > hd) {
                return hi + 1;
            } else {
                return hd + 1;
            }
        }
    }

    public int altura() {
        return altura(raiz);
    }

    private int menor(Nodo ptr) {
        if (ptr == null) {
            return 0;
        } else if (esHoja(ptr)) {
            return ptr.getElem();
        } else {
            if (ptr.getHI() != null) {
                int hi = menor(ptr.getHI());
                return hi;
            }
            return ptr.getElem();
        }
    }

    public int menor() {
        return menor(raiz);
    }

    private int mayor(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (esHoja(nodo)) {
            return nodo.getElem();
        }
        if (nodo.getHD() != null) {
            return mayor(nodo.getHD());
        }
        return nodo.getElem();
    }

    public void mayor() {
        int res = mayor(raiz);
        JOptionPane.showMessageDialog(null, "Mayor: " + res);
    }

    private int incompletos(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) //no es necesario
        {
            return 0;
        } else {
            int hi = incompletos(pr.getHI());
            int hd = incompletos(pr.getHD());
            if (pr.getHI() != null && pr.getHD() == null || pr.getHI() == null && pr.getHD() != null) {
                return hi + hd + 1; //el padre es incompleto
            } else {
                return hi + hd;
            }
        }
    }

    public int incompletos() {
        return incompletos(raiz);
    }

    private boolean existe(Nodo pr, int x) {
        if (pr == null) {
            return false;
        } else /*if (esHoja(pr))
                    return pr.getElem() == x;
                else*/ {
            if (pr.getElem() == x) {
                return true;
            } else if (x < pr.getElem()) {
                return existe(pr.getHI(), x);
            } else {
                return existe(pr.getHD(), x);
            }
        }
    }

    public boolean existe1(int x) {
        return existe1(raiz, x);
    }

    private boolean existe1(Nodo pr, int x) {
        if (pr == null) {
            return false;
        } else {
            if (existe(pr.getHI(), x) || existe(pr.getHD(), x)) {
                return true;
            } else {
                return pr.getElem() == x;
            }
        }
    }

    private int cantHojas(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) //necesario
        {
            return 1;
        } else {
            int hi = cantHojas(pr.getHI());
            int hd = cantHojas(pr.getHD());
            return hi + hd;   //aqui el padre no es hoja
        }
    }

    //otra version en vez del caso base: esHoja lo hace en el general
    private int cantHojas1(Nodo pr) {
        if (pr == null) {
            return 0;
        } else /*if (esHoja(pr)) //necesario
                    return 1;
                else*/ {
            int hi = cantHojas1(pr.getHI());
            int hd = cantHojas1(pr.getHD());
            if (pr.getHI() == null && pr.getHD() == null) {
                return hi + hd + 1;
            } else {
                return hi + hd;
            }
        }
    }

    public int cantHojas() {
        return cantHojas(raiz);
    }

    //estudiar y modificar igual que el anterior, sin el caso base: esHoja
    private int cantPadres(Nodo pr) {
        if (pr == null) {
            return 0;
        } else if (esHoja(pr)) //necesario
        {
            return 0;
        } else {
            int hi = cantPadres(pr.getHI());
            int hd = cantPadres(pr.getHD());
            return hi + hd + 1;
        }
    }

    public int cantPadres() {
        return cantPadres(raiz);
    }
    //Otra forma sin esHoja, xq no es necesario

    private int cantPadres1(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {
            int hi = cantPadres1(pr.getHI());
            int hd = cantPadres1(pr.getHD());
            if (pr.getHI() != null || pr.getHD() != null) {
                return hi + hd + 1;
            } else {
                return hi + hd;
            }
        }
    }

    private void mostrarPadres(Nodo p, JTextArea jta) {
        if (p == null) {
            return;
        } else /* if (esHoja(p))
                    return ;
                else*/ {
            mostrarPadres(p.getHI(), jta);
            mostrarPadres(p.getHD(), jta);
            if (p.getHI() != null || p.getHD() != null) {
                jta.append(p.getElem() + "  ");
            }
        }
    }

    public void mostrarPadres(JTextArea jta) {
        mostrarPadres(raiz, jta);
    }

    private void mostrarPadre(int x) {
        Nodo nodo = raiz;

        if (nodo == null || nodo.getElem() == x) {
            JOptionPane.showMessageDialog(null, "No tiene padre o no existe");
            return;
        }

        while (nodo != null) {
            if (nodo.getHI() != null) {
                if (nodo.getHI().getElem() == x) {
                    JOptionPane.showMessageDialog(null, "Padre: " + nodo.getElem());
                    return;
                }
            }
            if (nodo.getHD() != null) {
                if (nodo.getHD().getElem() == x) {
                    JOptionPane.showMessageDialog(null, "Padre: " + nodo.getElem());
                    return;
                }
            }
            if (nodo.getElem() < x) {
                nodo = nodo.getHD();
            } else {
                nodo = nodo.getHI();
            }
        }

        JOptionPane.showMessageDialog(null, "El elemento no existe");
    }

    public void mostrarPadre() {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Mostrar padre de: "));
        mostrarPadre(buscar);
    }

    private void mostrarPares(Nodo pr, JTextArea rt) {
        if (pr == null) {
            return;
        } else if (esHoja(pr)) {
            if (pr.getElem() % 2 == 0) {
                rt.append(pr.getElem() + " ");
            }
        } else {
            mostrarPares(pr.getHI(), rt);
            mostrarPares(pr.getHD(), rt);
            if (pr.getElem() % 2 == 0) {
                rt.append(pr.getElem() + " ");
            }
        }
    }

    public void mostrarPares(JTextArea jta) {
        mostrarPares(raiz, jta);
    }

    private void mostrarPrimos(Nodo nodo, JTextArea jta) {
        if (nodo == null) {
            return;
        } else if (esHoja(nodo) && esPrimo(nodo.getElem())) {
            jta.append(nodo.getElem() + " ");
        } else {
            mostrarPrimos(nodo.getHI(), jta);
            mostrarPrimos(nodo.getHD(), jta);
            if (esPrimo(nodo.getElem())) {
                jta.append(nodo.getElem() + " ");
            }
        }
    }

    public void mostrarPrimos(JTextArea jta) {
        jta.append("\nPrimos: ");
        mostrarPrimos(raiz, jta);
    }

    //imprime en postOrden
    private void mostrarMayoresX(Nodo pr, JTextArea rt, int x) {
        if (pr == null) {
            return;
        } else if (esHoja(pr)) {
            if (pr.getElem() > x) {
                rt.append(pr.getElem() + " ");
            }
        } else {
            mostrarMayoresX(pr.getHI(), rt, x);
            mostrarMayoresX(pr.getHD(), rt, x);
            if (pr.getElem() > x) {
                rt.append(pr.getElem() + " ");
            }
        }
    }

    public void mostrarMayoresX(JTextArea rt, int x) {
        mostrarMayoresX(raiz, rt, x);
    }

    private boolean brother(Nodo p, int x, int y) {
        if (p == null) {
            return false;
        } else if (esHoja(p) || incompleto(p)) {
            return false;
        } else {
            if (brother(p.getHI(), x, y) || brother(p.getHD(), x, y)) {
                return true;
            } else {  //Para la forma como meta los hnos
                if (p.getHI().getElem() == x && p.getHD().getElem() == y || p.getHI().getElem() == y && p.getHD().getElem() == x) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean brother(int x, int y) {
        return brother(raiz, x, y);
    }

    public void descendientes(int x, JTextArea rt) {
        Nodo ant = null;
        Nodo pr = raiz;
        if (pr.getElem() == x) {
            preOrden(pr, rt);
        } else {
            while (pr != null) {
                ant = pr;
                if (x < pr.getElem()) {
                    pr = pr.getHI();
                } else if (x > pr.getElem()) {
                    pr = pr.getHD();
                } else {
                    pr = null;
                }
            }
            preOrden(ant, rt);
        }
    }

//Otros extras        
    public boolean Padre(Nodo pr) {
        return pr.getHD() != null && pr.getHI() != null;
    }

    private boolean Hermanos(Nodo pr, int x, int y) {
        if (pr == null) {
            return false;
        }
        if (Padre(pr) && pr.getHI().getElem() == x && pr.getHD().getElem() == y) {
            return true;
        }
        if (Hermanos(pr.getHD(), x, y) || Hermanos(pr.getHI(), x, y)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Hermanos(int x, int y) {
        return Hermanos(raiz, x, y);
    }

    private boolean incompleto(Nodo T) {
        return (T.getHD() != null && T.getHI() == null) || (T.getHD() == null && T.getHI() != null);
    }

    private boolean Hermanos1(Nodo T, int x, int y) {
        if (T == null || esHoja(T) || incompleto(T)) {
            return false;
        } else {
            int a = T.getHI().getElem();
            int b = T.getHD().getElem();
            if ((a == x && b == y) || (a == y && b == x)) {
                return true;
            }

            if (Hermanos(T.getHD(), x, y) || Hermanos(T.getHI(), x, y)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean TieneNietos(int abu, Nodo pr) {
        if (pr == null) {
            return false;
        }
        if (pr.getElem() == abu && altura(pr) >= 3) {
            return true;
        }
        boolean ai = TieneNietos(abu, pr.getHD());
        boolean ad = TieneNietos(abu, pr.getHD());
        if (ai || ad) {
            return true;
        } else {
            return false;
        }
    }

    public boolean TieneNietos(int abu) {
        return TieneNietos(abu, raiz);
    }

    public boolean esPrimo(int x) {
        if (x == 1 || x == 0) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int contarPrimos(Nodo pr) {
        if (pr == null) {
            return 0;
        }
        if (esHoja(pr) && esPrimo(pr.getElem())) {
            return 1;
        } else {
            int ai = contarPrimos(pr.getHD());
            int ad = contarPrimos(pr.getHI());
            if (esPrimo(pr.getElem())) {
                return ai + ad + 1;
            } else {
                return ai + ad;
            }
        }
    }

    public int contarPrimos() {
        return contarPrimos(raiz);
    }

    private boolean esSuHijo(Nodo pr, int hijo) {
        if (pr == null) {
            return false;
        }
        if (!esHoja(pr)) {
            if (pr.getHD() != null && pr.getHD().getElem() == hijo) {
                return true;
            }
            if (pr.getHI() != null && pr.getHI().getElem() == hijo) {
                return true;
            }
        }
        return false;
    }

    //cuando no tiene abuelo devuelve 0
    private int retornaAbuelo(Nodo pr, int x) {
        if (pr == null) {
            return 0;
        }
        if (altura(pr) >= 3) {
            if (pr.getHI() != null && esSuHijo(pr.getHI(), x)) {
                return pr.getElem();
            }
            if (pr.getHD() != null && esSuHijo(pr.getHD(), x)) {
                return pr.getElem();
            }
        }

        int ai = retornaAbuelo(pr.getHI(), x);
        int ad = retornaAbuelo(pr.getHD(), x);
        if (ai != 0) {
            return ai;
        } else if (ad != 0) {
            return ad;
        } else {
            return 0;
        }
    }

    public int retornaAbuelo(int x) {
        return retornaAbuelo(raiz, x);
    }

    public int retornaBisabuelo(int x){
        return retornaBisabuelo(raiz, x);
    }
    
    private int retornaBisabuelo(Nodo pr, int x){
        if (pr == null) {
            return 0;
        }
        if (altura(pr) >= 4) {
            if (pr.getHI() != null && pr.getHI().getHI() != null && esSuHijo(pr.getHI().getHI(), x)) {
                return pr.getElem();
            }
            if (pr.getHI() != null && pr.getHI().getHD() != null && esSuHijo(pr.getHI().getHD(), x)) {
                return pr.getElem();
            }
            if (pr.getHD() != null && pr.getHD().getHI() != null && esSuHijo(pr.getHD().getHI(), x)) {
                return pr.getElem();
            }
            if (pr.getHD() != null && pr.getHD().getHD() != null && esSuHijo(pr.getHD().getHD(), x)) {
                return pr.getElem();
            }
        }

        int ai = retornaBisabuelo(pr.getHI(), x);
        int ad = retornaBisabuelo(pr.getHD(), x);
        if (ai != 0) {
            return ai;
        } else if (ad != 0) {
            return ad;
        } else {
            return 0;
        }
    }
    
    private void MostrarNivel(Nodo pr, int n, int nivel, JTextArea ta) {
        if (pr == null) {
            return;
        }
        if (n == nivel) {
            ta.append(pr.getElem() + " ");
            return;
        } else {
            MostrarNivel(pr.getHI(), n, nivel + 1, ta);
            MostrarNivel(pr.getHD(), n, nivel + 1, ta);
            nivel = 1;
        }
    }

    public void MostrarNivel(int nivel, JTextArea rtb) {
        MostrarNivel(raiz, nivel, 1, rtb);
    }

    //no funca para los nietos del medio del arbol
    private void MostrarNietos(Nodo p, int x, JTextArea jta) {
        if (p == null) {
        }
        if (x == p.getElem()) {
            if (p.getHD() != null) {
                if (p.getHD().getHI() != null) {
                    jta.append(p.getHD().getHI().getElem() + " ");
                }
                if (p.getHD().getHD() != null) {
                    jta.append(p.getHD().getHD().getElem() + " ");
                }
            }
            if (p.getHI() != null) {
                if (p.getHD().getHI() != null) {
                    jta.append(p.getHI().getHI().getElem() + " ");
                }
                if (p.getHD().getHD() != null) {
                    jta.append(p.getHI().getHD().getElem() + " ");
                }
            }
            return;
        }
        if (x > p.getElem()) {
            MostrarNietos(p.getHD(), x, jta);
        } else {
            MostrarNietos(p.getHI(), x, jta);
        }
    }

    public void MostrarNietos(int x, JTextArea jta) {
        MostrarNietos(raiz, x, jta);
    }

    //lo mismo que descendientes, pero recursivo
    private void ImprimirDescendientes(Nodo p, JTextArea ta, int x) {
        if (p == null) {
            return;
        }
        if (p.getElem() == x) {
            preOrden(p, ta);
            return;
        }
        if (p.getElem() < x) {
            ImprimirDescendientes(p.getHD(), ta, x);
        } else {
            ImprimirDescendientes(p.getHI(), ta, x);
        }
    }

    public void ImprimirDescendientes(JTextArea ta, int x) {
        ImprimirDescendientes(raiz, ta, x);
    }

    //OTROS METODOS      
    public void eliminar(int x) {
        Nodo p = raiz;
        Nodo ap = null;
        while (p != null && p.getElem() != x) {
            ap = p;
            if (x > p.getElem()) {
                p = p.getHD();
            } else {
                p = p.getHI();
            }
        }
        if (p == null) {
            return;
        }
        if (esHoja(p)) {
            elimCaso1(ap, p);
        } else if ((p.getHD() != null && p.getHI() == null) || (p.getHD() == null && p.getHI() != null)) {
            elimCaso2(ap, p);
        } else {
            elimCaso3(p);
        }
    }

    private void elimCaso1(Nodo ap, Nodo p) {
        if (ap == null) {
            raiz = null;
        } else {
            if (p == ap.getHD()) {
                ap.setHD(null);
            } else {
                ap.setHI(null);
            }
        }
    }

    private void elimCaso2(Nodo ap, Nodo p) {
        if (ap == null) {
            if (p.getHD() != null) {
                raiz = p.getHD();
            } else {
                raiz = p.getHI();
            }
        } else {
            if (p == ap.getHD()) {
                if (p.getHD() != null) {
                    ap.setHD(p.getHD());
                } else {
                    ap.setHD(p.getHI());
                }
            } else if (p.getHD() != null) {
                ap.setHD(p.getHD());
            } else {
                ap.setHI(p.getHI());
            }
        }
    }

    private void elimCaso3(Nodo p) {
        Nodo s = p.getHD();
        Nodo ant = null;
        while (s.getHI() != null) {
            ant = s;
            s = s.getHI();
        }
        int aux = p.getElem();
        p.setElem(s.getElem());
        s.setElem(aux);
        if (ant == null) {
            p.setHD(null);
        } else {
            ant.setHI(null);
        }
    }

    private Nodo devolverHermano(Nodo p, int x) {
        if (p == null /*|| esHoja(p) || incompleto(p)*/) {
            return null;
        } else {
            if(p.getHI() != null){
                if (p.getHI().getElem() == x) {
                    return p.getHD();
                }
            }
            if(p.getHD() != null){
                if (p.getHD().getElem() == x) {
                    return p.getHI();
                }
            }
            
            Nodo ni = devolverHermano(p.getHI(), x);
            Nodo nd = devolverHermano(p.getHD(), x);
            
            if (ni != null) {
                return ni;
            }
            if (nd != null) {
                return nd;
            }
        }
        return null;
    }

    public void devolverHermano(int x) {
        Nodo p = devolverHermano(raiz, x);
        if (!existe1(x)) {
            JOptionPane.showMessageDialog(null, "No existe");
            return;
        }
        if (p == null) {
            JOptionPane.showMessageDialog(null, "No tiene hermano");
        } else {
            JOptionPane.showMessageDialog(null, p.getElem());
        }
    }

    private Nodo devolverPadre(Nodo p, int x) {
        if (p == null || esHoja(p)) {
            return null;
        } else {
            if (p.getHI() != null) {
                if (p.getHI().getElem() == x) {
                    return p;
                }
            }

            if (p.getHD() != null) {
                if (p.getHD().getElem() == x) {
                    return p;
                }
            }

            Nodo I = devolverPadre(p.getHI(), x);
            Nodo D = devolverPadre(p.getHD(), x);
            if (I != null) {
                return I;
            } else {
                return D;
            }
        }
    }

    public void devolverPadre(int x) {
        Nodo p = devolverPadre(raiz, x);
        if (!existe1(x)) {
            return;
        }
        if (p == null && existe1(x)) {
            JOptionPane.showMessageDialog(null, "NO tiene Padre");
        } else {
            JOptionPane.showMessageDialog(null, p.getElem());
        }
    }

    private Nodo sucInOrden(Nodo T) {
        if (T == null || esHoja(T)) {
            return null;
        }
        if (T.getHI() == null && T.getHD() != null) {
            return T.getHD();
        }
        if (T.getHI() != null && T.getHD() == null) {
            return T.getHI();
        }

        Nodo P = T.getHD();
        while (P.getHI() != null) {
            P = P.getHI();
        }
        return P;
    }

    public void sucInOrden() {
        Nodo p = sucInOrden(raiz);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "NO tiene sucInOrden");
        } else {
            JOptionPane.showMessageDialog(null, p.getElem());
        }
    }

//    1. Dado por parámetro un elemento X verificar si existe dicho elemento en el árbol
    public void existe() {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Buscar elemento: "));
        if (existe(buscar)) {
            JOptionPane.showMessageDialog(null, "Existe el elemento");
        } else {
            JOptionPane.showMessageDialog(null, "No existe el elemento");
        }
    }

    private boolean existe(int x) {
        if (raiz == null) {
            return false;
        }
        if (raiz.getElem() == x) {
            return true;
        }
        Nodo copia = raiz;
        while (copia != null) {
            if (copia.getElem() == x) {
                return true;
            }
            if (copia.getElem() < x) {
                copia = copia.getHD();
            } else {
                copia = copia.getHI();
            }
        }
        return false;
    }
//    2. Dado por parámetro un elemento X, mostrar los hijos (hijo izquierdo y derecho) del elemento X del árbol
    // FUNCION LLAMADA DESDE EL FORM

    public void mostrarHijos() {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Buscar elemento: "));
        mostrarHijos(buscar);
    }

    private void mostrarHijos(int x) {
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacio");
        }

        Nodo copia = raiz;
        while (copia != null) {
            if (copia.getElem() == x) {
                mostrarHijos(copia);
                return;
            }
            if (copia.getElem() < x) {
                copia = copia.getHD();
            } else {
                copia = copia.getHI();
            }
        }

        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
    }

    private void mostrarHijos(Nodo nodo) {
        String str = "";
        if (nodo.getHD() != null) {
            str += nodo.getHD().getElem();
            str += " ";
        }
        if (nodo.getHI() != null) {
            str += nodo.getHI().getElem();
            str += " ";
        }

        if (str.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sin hijos");
        } else {
            JOptionPane.showMessageDialog(null, "Hijos: " + str);
        }
    }
//    3. Dado por parámetro un elemento X, verificar cuantos hijos tiene dicho elemento del árbol

    public void cantidadHijos() {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Buscar elemento: "));
        cantidadHijos(buscar);
    }

    private void cantidadHijos(int x) {
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "Arbol vacio");
        }
        Nodo copia = raiz;
        while (copia != null) {
            if (copia.getElem() == x) {
                int cant = 0;
                if (copia.getHD() != null) {
                    cant++;
                }
                if (copia.getHI() != null) {
                    cant++;
                }

                JOptionPane.showMessageDialog(null, "Cantidad de hijos: " + cant);
            }
            if (copia.getElem() < x) {
                copia = copia.getHD();
            } else {
                copia = copia.getHI();
            }
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
    }

    // Sumar numeros primos de todo el arbol
    private int sumarPrimos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (esHoja(nodo) && esPrimo(nodo.getElem())) {
            return nodo.getElem();
        } else {
            int hi = sumarPrimos(nodo.getHI());
            int hd = sumarPrimos(nodo.getHD());
            if (esPrimo(nodo.getElem())) {
                return hi + hd + nodo.getElem();
            }
            return hi + hd;
        }
    }

    public void sumarPrimos() {
        int res = sumarPrimos(raiz);
        JOptionPane.showMessageDialog(null, "Suma de primos: " + res);
    }

    // ---- PRACTICO ---- //
    // Funciones auxiliares //
    private Nodo escogerCamino(Nodo nodo, int x) {
        if (nodo.getElem() < x) {
            return nodo.getHD();
        }
        return nodo.getHI();
    }

    private Nodo escogerCamino(Nodo nodo){
        if(nodo.getHI() != null)
            return nodo.getHI();
        return nodo.getHD();
    }
    
    private void preOrden(Nodo nodo, String[] str) {
        if (nodo != null) {
            str[0] += nodo.getElem() + " ";
            preOrden(nodo.getHI(), str);
            preOrden(nodo.getHD(), str);
        }
    }
    
    // 1. Dado un árbol binario, mostrar los nietos de un elemento X introducido por parámetro.
    public void mostrarNietos() {
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Encontrar nietos de: ", "Mostrar nietos"));
        mostrarNietos(raiz, x);
    }

    private String getNietos(Nodo nodo) {
        String str = "";
        if (nodo.getHI() != null) {
            if (nodo.getHI().getHI() != null) {
                str += nodo.getHI().getHI().getElem() + " ";
            }
            if (nodo.getHI().getHD() != null) {
                str += nodo.getHD().getHD().getElem() + " ";
            }
        }

        if (nodo.getHD() != null) {
            if (nodo.getHD().getHI() != null) {
                str += nodo.getHD().getHI().getElem() + " ";
            }
            if (nodo.getHD().getHD() != null) {
                str += nodo.getHD().getHD().getElem() + " ";
            }
        }
        return str;
    }

    private void mostrarNietos(Nodo nodo, int x) {
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }

        while (nodo != null) {
            if (nodo.getElem() == x) {
                String str = getNietos(nodo);  // En string para mostrar facilmente los datos

                if (str.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No tiene nietos");
                } else {
                    JOptionPane.showMessageDialog(null, "Nietos: " + str);
                }
                return;
            }

            nodo = escogerCamino(nodo, x);
        }

        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
    }

    // 2. Dado un árbol binario, mostrar el abuelo de un elemento X introducido por parámetro.
    public void mostrarAbuelo() {
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Encontrar abuelo de: "));
        mostrarAbuelo(raiz, x);
    }

    private void mostrarAbuelo(Nodo nodo, int x) {
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }

        Nodo abuelo = null;
        int generacion = 1;

        while (nodo != null) {
            if (generacion == 3) {  // A partir de la tercera generacion, los nodos ya cuentan con abuelo
                abuelo = raiz;
            }

            if (nodo.getElem() == x && abuelo != null) {
                JOptionPane.showMessageDialog(null, "El abuelo es: " + abuelo.getElem());
                return;
            } else if (nodo.getElem() == x && abuelo == null) {
                JOptionPane.showMessageDialog(null, "No tiene abuelo");
                return;
            }

            nodo = escogerCamino(nodo, x);
            generacion++;

            if (generacion > 3) {  // El abuelo debe seguir el camino recorrido por su nieto
                abuelo = escogerCamino(abuelo, x);
            }
        }

        JOptionPane.showMessageDialog(null, "El elemento no existe");
    }

    // 3. Dado un árbol binario, mostrar los descendientes de un elemento X(Al decir descendientes se refiere a: hijos, nietos, bisnietos,etc).
    public void mostrarDescendencia() {
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Mostrar descendencia de:"));
        mostrarDescendencia(raiz, x);
    }

    private void mostrarDescendencia(Nodo nodo, int x) {
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }

        String descendencia[] = {""};
        /*
        // EXPLICACION DEL ARREGLO
        // Java al no tener una forma de pasar elementos por referencia, lo hace
        // unicamente por valor, lo que hago es crear un arreglo de un unico elemento
        // cuando un arreglo es pasado como argumento de un metodo, este afecta directamente
        // los valores almacenados dentro suyo, de esta manera se consigue crear parametros por referencia
        // de tipos de datos primitivos, esto lo hago asi porque requiero que la funcion
        // sea recursiva para encontrar toda la descendencia de un nodo especifico.
         */
        while (nodo != null) {
            if (nodo.getElem() == x) {
                preOrden(nodo, descendencia);
                JOptionPane.showMessageDialog(null, "Descendencia: " + descendencia[0]);
                return;
            }
            nodo = escogerCamino(nodo, x);
        }

        JOptionPane.showMessageDialog(null, "No existe el elemento");

    }

    // 4. Diseñar un método que permita verificar que 2 árboles son iguales (en tamaño y elementos)
    public void compararArboles(Nodo arbol1, Nodo arbol2) {
        if (arbol1 == null || arbol2 == null) {
            JOptionPane.showMessageDialog(null, "Uno o ambos arboles no existen");
            return;
        }

        String arbol1_aplanado[] = {""};  // Aplanar los arboles almacenandolos en preorden para comparar facilmente
        String arbol2_aplanado[] = {""};  // Uso de la misma tecnica para pasar argumentos por referencia y no por valor

        preOrden(arbol1, arbol1_aplanado);
        preOrden(arbol2, arbol2_aplanado);

        // JOptionPane.showMessageDialog(null, "Arbol 1: " + arbol1_aplanado[0]);
        // JOptionPane.showMessageDialog(null, "Arbol 2: " + arbol2_aplanado[0]);
        if (Arrays.equals(arbol1_aplanado, arbol2_aplanado)) {
            JOptionPane.showMessageDialog(null, "Los arboles son iguales");
        } else {
            JOptionPane.showMessageDialog(null, "Los arboles son diferentes");
        }
    }

    // 5. Verificar que un árbol es una lista enlazada simple (El árbol es lista, si el nodo padre solo tiene hijos izquierdo o hijos derechos)
    public void esLista() {
        if (esLista(raiz)) {
            JOptionPane.showMessageDialog(null, "El arbol es una lista");
        } else {
            JOptionPane.showMessageDialog(null, "No existe o no es lista");
        }
    }

    private boolean esLista(Nodo nodo) {
        if (nodo == null) {
            return false;
        }

        while (nodo != null) {
            if (nodo.getHI() != null && nodo.getHD() != null) {
                return false;
            }
            nodo = escogerCamino(nodo);
        }
        return true;
    }

    // 6. Implementar un método que permita mostrar por niveles los elementos de un árbol binario
    public void mostrarPorNiveles() {
        mostrarPorNiveles(raiz);
    }

    private void mostrarPorNiveles(Nodo nodo) {
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }

        Queue<Nodo> queue = new LinkedList<Nodo>();
        String arbol_aplanado = "";
        queue.add(nodo);
        while (!queue.isEmpty()) {
            Nodo temporario = queue.poll();
            arbol_aplanado += temporario.getElem() + " ";
            if (temporario.getHI() != null)
                queue.add(temporario.getHI());
            if (temporario.getHD() != null)
                queue.add(temporario.getHD());
        }

        JOptionPane.showMessageDialog(null, "Arbol por niveles: " + arbol_aplanado);
    }

    // 7. Implementar un método que permita mostrar por niveles los elementos pares de un árbol binario.
    public void mostrarParesPorNiveles() {
        mostrarParesPorNiveles(raiz);
    }

    private void mostrarParesPorNiveles(Nodo nodo) {
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }
        
        Queue<Nodo> queue = new LinkedList<Nodo>();
        queue.add(nodo);
        int nivel = 1;
        String mensaje = "";
        while (!queue.isEmpty()) {
            mensaje += "Nivel " + nivel + ":";
            
            // Sacar los elementos a una lista, recorrerla con un for
            // ir agregando los elementos al mensaje, llenar la cola con los hijos
            
            List<Nodo> lista = new ArrayList(queue);
            queue.clear();
            
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getElem() % 2 == 0)
                    mensaje += " " + lista.get(i).getElem();
                if (lista.get(i).getHI() != null) {
                    queue.add(lista.get(i).getHI());
                }
                if (lista.get(i).getHD() != null) {
                    queue.add(lista.get(i).getHD());
                }
            }
            nivel++;
            mensaje += "\n";
        }
            // REVISAR
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    // 8. Hacer una función para calcular la suma de cada nivel de un árbol
    public void sumarPorNiveles(){
        sumarPorNiveles(raiz);
    }
    
    private void sumarPorNiveles(Nodo nodo){
        if(nodo == null){
            JOptionPane.showMessageDialog(null, "No existe arbol");
            return;
        }
        
        Queue<Nodo> queue = new LinkedList<Nodo>();
        queue.add(nodo);
        String mensaje = "";
        
        while(!queue.isEmpty()){
            int sumaParcial = 0;
            List<Nodo> list = new ArrayList(queue);
            queue.clear();
            
            for(int i=0; i<list.size(); i++){
                sumaParcial += list.get(i).getElem();
                if (list.get(i).getHI() != null) {
                    queue.add(list.get(i).getHI());
                }
                if (list.get(i).getHD() != null) {
                    queue.add(list.get(i).getHD());
                }
            }
            
            mensaje += sumaParcial + "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    // -----EXAMEN PRACTICO----- //
    // 1. Realizar un método que devuelva la suma desus elementos delos nietos de un elemento x introducido por parámetro
    public void sumarNietos(){
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Sumar los nietos de: "));
        sumarNietos(raiz, x);
    }
    
    private void sumarNietos(Nodo nodo, int x){
        if(nodo == null){
            JOptionPane.showMessageDialog(null, "No existe el arbol");
            return;
        }
        
        int suma = 0;
        while(nodo != null){
            if(nodo.getElem() == x){
                if(nodo.getHI() != null && nodo.getHI().getHI() != null){
                    suma += nodo.getHI().getHI().getElem();
                }
                if(nodo.getHI() != null && nodo.getHI().getHD() != null){
                    suma += nodo.getHI().getHD().getElem();
                }
                
                if(nodo.getHD() != null && nodo.getHD().getHI() != null){
                    suma += nodo.getHD().getHI().getElem();
                }
                if(nodo.getHD() != null && nodo.getHD().getHD() != null){
                    suma += nodo.getHD().getHD().getElem();
                }
                
                JOptionPane.showMessageDialog(null, "La suma de los nietos es: " + suma);
                return;
            }
            
            nodo = escogerCamino(nodo, x);
        }
        
        JOptionPane.showMessageDialog(null, "No se encontro el elemento " + x);
    }
}//end class

