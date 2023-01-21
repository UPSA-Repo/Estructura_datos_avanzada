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

    public Nodo crearNodo(SubLista x, Nodo p) {
        Nodo q = new Nodo(x, p);
        return q;
    }

    public void insertarPrimero(SubLista x) {
        Nodo q = crearNodo(x, primero);
        primero = q;
        cantidad++;
    }

    public void insertarUltimo(SubLista x) {
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

    public SubLista getSubLista(int pos) {

        Nodo p = primero;
        int k = 1;
        while (k < pos && p != null) {
            p = p.getProx();
            k++;
        }
        return p.getListaDeLista();

    }

    public int precioPorPiso(int piso) {
        Nodo p = primero;
        int s = 0;
        int i = 1;
        SubLista LL1 = new SubLista();
        LL1 = getSubLista(piso);
        SubNodo q = LL1.Primero();
        while (q != null) {
            s = s + LL1.getPRECIO(i);
            q = q.getSubProx();
            i++;
        }
        return s;
    }

    // TAREA
    // 1. Dado por parámetro la posición del vector (lista principal), encontrar el mayor de todos sus elementos de la subLista que pertenecen a dicha posición
    public int mayor(int pos) {
        SubLista sl = getSubLista(pos);
        SubNodo sn = sl.Primero();
        int mayor = sn.getPrecio();

        while (sn != null) {
            if (sn.getPrecio() > mayor) {
                mayor = sn.getPrecio();
            }
            sn = sn.getSubProx();
        }

        return mayor;
    }

    // 2. Dado por parámetro la posición del vector (lista principal), eliminar un elemento de la subLista dada la posición de la subLista
    public void eliminarSubNodo(int posLista, int posSubLista){
        SubLista sl = getSubLista(posLista);
        sl.eliminarPosicion(posSubLista);
    }
    
    // 3. Invertir todos los elementos de las subListas correspondientes a cada posición del vector
    public void thisNodo(Nodo primero){
        this.primero = primero;
    }
    
    public Nodo thisNodo(){
        return this.primero;
    }
    
    public void invertir(){
        invertirSubListas(primero);
    }
    
    private void invertirSubListas(Nodo nodo){
        if(nodo == null)
            return;
        
        // INVERTIR SUBLISTA
        SubLista slActual = nodo.getListaDeLista();
        SubNodo  snActual = slActual.Primero();
        
        // DATOS NUEVOS
        SubLista slNueva = new SubLista();
        
        // MOVERME ENTRE SUBNODOS
        while(snActual != null){
            slNueva.insertarPrimero(snActual.getCodigo(), snActual.getPrecio());
            snActual = snActual.getSubProx();
        }
        
        // COPIAR LA LISTA NUEVA AL NODO ACTUAL
        nodo.setListaDeLista(slNueva);
        
        // FIN INVERSION
        invertirSubListas(nodo.getProx());
    }
}//end clase
