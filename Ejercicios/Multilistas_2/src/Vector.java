
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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

    public void sumarSubLista(JTextArea ta) {
        for (int i = 0; i < n; i++) {
            Lista L1 = getElem(i);
            Nodo p = L1.Primero();
            int j = 1;
            while (p != null) {
                Sublista SL = p.getElem();
                Subnodo q = SL.Primero2();
                int acum = 0;
                while (q != null) {
                    acum = acum + q.getElem2();
                    q = q.getProx2();
                }
                ta.append(i + " " + j + " " + acum);
                ta.append("\n");
                p = p.getProx();
            }
            j++;
        }

    }
    
    public int mayor(int posVec, int posLis){
        if(posVec < 0 || posVec >= n)
            return -1;
        if(posLis <= 0 || posLis > getElem(posVec).getCant())
            return -1;
        
        Sublista sl = getElem(posVec).getElemento(posLis);
        Subnodo sn = sl.Primero2();
        int elementoMayor = sn.getElem2();
        
        while(sn != null){
            if(sn.getElem2() > elementoMayor)
                elementoMayor = sn.getElem2();
            sn = sn.getProx2();
        }
        
        return elementoMayor;
    }

    
    // IMPRIMIR EL FACTORIAL DE TODOS LOS ELEMENTOS DE UNA LISTA
    private int fact(int n) {
            if (n == 0)
                return 1;

            return n * fact(n--);
        }
    
    public Lista factorial(int posVec){
        if(posVec < 0 || posVec >= n)
            return null;
        
        Lista fact = getElem(posVec);
        Nodo nodo = fact.Primero();
        
        while(nodo != null){
            Sublista sl = nodo.getElem();
            Subnodo  sn = sl.Primero2();
            while(sn != null){
                sn.setElem2(fact(sn.getElem2()));
                sn = sn.getProx2();
            }
            nodo = nodo.getProx();
        }
        return fact;
    }
    
    // MAYOR DE TODAS LAS SUBLISTAS DE UNA LISTA DADA
    public int mayor(int posVec){
        Lista lista = getElem(posVec);
        Nodo nodo = lista.Primero();
        Sublista sl = nodo.getElem();
        Subnodo sn = sl.Primero2();
        
        // Subnodo sn = getElem(posVec).Primero().getElem().Primero2();
        int resp = sn.getElem2();
        
        while(nodo != null){
            sn = nodo.getElem().Primero2();
            while(sn != null){
                if(sn.getElem2() > resp)
                    resp = sn.getElem2();
                sn = sn.getProx2();
            }
            nodo = nodo.getProx();
        }
        
        return resp;
    }
    
}//end class
