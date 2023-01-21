
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Formulario extends javax.swing.JFrame {

    /** Creates new form Formulario */
    Vector v1=new Vector();
    
    public Formulario() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        t1 = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jBtnMayorSubLista = new javax.swing.JButton();
        jBtnEliminarPosicion = new javax.swing.JButton();
        jBtnInvertir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ));
        jScrollPane3.setViewportView(tabla);

        jBtnMayorSubLista.setText("Mayor  Sublista");
        jBtnMayorSubLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMayorSubListaActionPerformed(evt);
            }
        });

        jBtnEliminarPosicion.setText("Eliminar posicion");
        jBtnEliminarPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarPosicionActionPerformed(evt);
            }
        });

        jBtnInvertir.setText("Invertir todo");
        jBtnInvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInvertirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCargar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnMostrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBtnMayorSubLista))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnInvertir)
                                    .addComponent(jBtnEliminarPosicion)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnMostrar)
                    .addComponent(jBtnMayorSubLista)
                    .addComponent(jBtnEliminarPosicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnInvertir))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void cargarLista(Lista l1)
    {
      int x;  
      int n=Integer.parseInt(JOptionPane.showInputDialog("Dimension de la Lista:"));
        for(int i=0;i<n;i++)
        {
          x=Integer.parseInt(JOptionPane.showInputDialog("Elemento:"));            
          l1.insertarUltimo(x);
        }      
    }
  
    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        int n=Integer.parseInt(t1.getText());
        Lista l1;
        for(int i=0;i<n;i++)
        {
            l1=new Lista();
            cargarLista(l1);
            v1.insertarUlt(l1);
        }
    }//GEN-LAST:event_btnCargarActionPerformed
    
    void mostrarLista(Lista l1,int i)
    {
        Nodo p=l1.Primero();
        int j=0;
        while(p!=null)
        {
            ta1.append(p.getElem() + " ");
            tabla.setValueAt(p.getElem(),i ,j);
            p=p.getProx();
            j++;
        }      
    }
    
    void limpiarTabla(final JTable table){
        for(int i=0; i<table.getRowCount(); i++){
            for(int j=0; j<table.getColumnCount(); j++)
                table.setValueAt("", i, j);
        }
    }
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        
        ta1.setText("");
        limpiarTabla(tabla);
        
        Lista l1;
        for(int i=0;i<v1.getDim();i++)
        {
            l1=new Lista();
            l1=v1.getElem(i);
            mostrarLista(l1,i);
            ta1.append("\n");
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void jBtnMayorSubListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMayorSubListaActionPerformed
        int pos = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la posicion: "));
        JOptionPane.showMessageDialog(this, "Mayor: " + v1.getElem(pos).mayor());
    }//GEN-LAST:event_jBtnMayorSubListaActionPerformed

    private void jBtnEliminarPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarPosicionActionPerformed
        int posLista = Integer.parseInt(JOptionPane.showInputDialog(this, "Posicion de lista: "));
        int posElem  = Integer.parseInt(JOptionPane.showInputDialog(this, "Posicion de elemento: "));
        v1.getElem(posLista).eliminar(posElem);
    }//GEN-LAST:event_jBtnEliminarPosicionActionPerformed

    private void jBtnInvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInvertirActionPerformed
        v1.invertir();
    }//GEN-LAST:event_jBtnInvertirActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton jBtnEliminarPosicion;
    private javax.swing.JButton jBtnInvertir;
    private javax.swing.JButton jBtnMayorSubLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

}
