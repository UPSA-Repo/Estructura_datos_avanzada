

import javax.swing.JOptionPane;

public class Formulario extends javax.swing.JFrame {

    /** Creates new form Formulario */
    Vector v1=new Vector();
   // Lista l1=new Lista();
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
        jButton1 = new javax.swing.JButton();
        jBtnCantidad = new javax.swing.JButton();
        jBtnMayorSL = new javax.swing.JButton();
        jBtnFactorial = new javax.swing.JButton();
        jBtnMayor = new javax.swing.JButton();

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

        jButton1.setText("sumaSubLista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBtnCantidad.setText("Cantidad");
        jBtnCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCantidadActionPerformed(evt);
            }
        });

        jBtnMayorSL.setText("Mayor SL");
        jBtnMayorSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMayorSLActionPerformed(evt);
            }
        });

        jBtnFactorial.setText("Factorial");
        jBtnFactorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFactorialActionPerformed(evt);
            }
        });

        jBtnMayor.setText("Mayor");
        jBtnMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMayorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCargar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMostrar)
                                .addGap(34, 34, 34)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnCantidad)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnMayorSL)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnFactorial)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnMayor)))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jButton1)
                    .addComponent(jBtnCantidad)
                    .addComponent(jBtnMayorSL)
                    .addComponent(jBtnFactorial)
                    .addComponent(jBtnMayor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarSubLista(Sublista SL)
    {
        int n=Integer.parseInt(JOptionPane.showInputDialog("Tamano de la SubLista "));
         for(int i=0;i<n;i++)
         { 
             int a=Integer.parseInt(JOptionPane.showInputDialog("subElemento:"));
             SL.insertarUltimo2(a);
         }    
    } 
  public void cargarLista(Lista L1) 
  {
      int x; 
      int n=Integer.parseInt(JOptionPane.showInputDialog("Dimension de la Lista:"));      
      Sublista SL;
      for(int i=0;i<n;i++)
      {
          SL=new Sublista();
          //x=Integer.parseInt(JOptionPane.showInputDialog("Elemento de la Lista:")); 
          //SL.insertarUltimo2(x);
          cargarSubLista(SL);
          L1.insertarUltimo(SL);           
      }       
  }  
  
    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        int n=Integer.parseInt(t1.getText());
        Lista L1;
        for(int i=0;i<n;i++)
        {
            L1=new Lista();
            cargarLista(L1);
            v1.insertarUlt(L1);
        }
    }//GEN-LAST:event_btnCargarActionPerformed
    void mostrarSubLista(Sublista L2)
    {
    Subnodo q=L2.Primero2();
       Lista l1;
         l1=new Lista();
         Nodo p=l1.Primero();
        int j=1;
        int k=0;
        while(q!=null )//&& j<l1.getCant() && p!=null)
        {
            ta1.append(q.getElem2()+" ");            
            q=q.getProx2();
            //p=p.getProx();
           j++;
           k++;
        }
         ta1.append("\n");
    }
    void mostrarLista(Lista l1)
    {       
     Nodo p=l1.Primero();
     while(p!=null)
     {
        
        Sublista SL=new Sublista();
        SL=p.getElem();                
        mostrarSubLista(SL);
        p=p.getProx();
     }           
    }                           
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        
        for(int i=0;i<v1.getDim();i++)
        {
            ta1.append("Vector["+ String.valueOf(i)+ "]" + "\n");
            Lista L1=new Lista();
            L1=v1.getElem(i);
            ta1.append("Lista: "+ String.valueOf(i+1)+ "\n");       
            mostrarLista(L1);
            ta1.append("--------------------------------------"+"\n");
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your    handling code here:
            v1.sumarSubLista(ta1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBtnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCantidadActionPerformed
        for(int i=0; i<v1.getDim(); i++){
            JOptionPane.showMessageDialog(this, "Lista " + (i+1) + ": " + v1.getElem(i).getCant() + " elemento(s)");
        }
    }//GEN-LAST:event_jBtnCantidadActionPerformed

    private void jBtnMayorSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMayorSLActionPerformed
        int posVec = Integer.parseInt(JOptionPane.showInputDialog(this, "Posicion vector: "));
        int posLis = Integer.parseInt(JOptionPane.showInputDialog(this, "Posicion lista: "));
        JOptionPane.showMessageDialog(this, "Elemento mayor: " + v1.mayor(posVec, posLis));
    }//GEN-LAST:event_jBtnMayorSLActionPerformed
    
    private void jBtnFactorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFactorialActionPerformed
        
        int pos = Integer.parseInt(JOptionPane.showInputDialog(this, "Posicion de vector: "));
        Lista lista = v1.factorial(pos);
        mostrarLista(lista);
    }//GEN-LAST:event_jBtnFactorialActionPerformed

    private void jBtnMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMayorActionPerformed
        int posVec = Integer.parseInt(JOptionPane.showInputDialog(this, "Posicion vector: "));
        JOptionPane.showMessageDialog(this, "Mayor: " + v1.mayor(posVec));
    }//GEN-LAST:event_jBtnMayorActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Formulario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton jBtnCantidad;
    private javax.swing.JButton jBtnFactorial;
    private javax.swing.JButton jBtnMayor;
    private javax.swing.JButton jBtnMayorSL;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextArea ta1;
    // End of variables declaration//GEN-END:variables

}
