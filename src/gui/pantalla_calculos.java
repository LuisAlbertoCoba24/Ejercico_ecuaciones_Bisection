/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.table.DefaultTableModel;
import metodo_bisection.metodo_bisecion_ecuacion_uno;
import metodo_bisection.metodo_bisecion_ecuacion_dos;

public class pantalla_calculos extends javax.swing.JFrame {

  metodo_bisecion_ecuacion_uno resolucion = new metodo_bisecion_ecuacion_uno();
  metodo_bisecion_ecuacion_dos resolucion_ecuacion_dos = new metodo_bisecion_ecuacion_dos();
 
  int iteraciones = 0;
  double xr = 0;
  double test = 0;
  double ea = 0;
  double xrold = 0;
  int opciones = 0;
  
  
  
  public pantalla_calculos() {
    initComponents();

  }
  
  public void ecuacion(){
    
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel() ;
  
    double xu = Double.valueOf(txtxf.getText());  
    double xi = Double.valueOf(textXi.getText());
    int maxiteraciones = Integer.parseInt(jTextField4.getText());
    double em = Double.parseDouble(jTextField1.getText());
    
    resolucion.fxi(xi);
    resolucion.fxf(xu);
    
    if( (resolucion.fxi(xi)*resolucion.fxf(xu)) > 0 ){
      
      System.out.println("No tiene raiz");
      
    }else{
    
    do {          
      
      xrold = xr;
      
      xr = (xi+xu)/2;
      
      ea = Math.abs((xr-xrold)/xr)*100;

      test = resolucion.fxi(xi)*resolucion.fxf(xr);
              
      if( test < 0 ){
        
        xu = xr;
        
      }else if( test > 0 ){
        
        xi = xr;
        
      }else{
        
        ea = 0;
        
      }

      iteraciones  = iteraciones  + 1;
      modelo.addRow(new Object[]{iteraciones,xi,xu,xr,resolucion.fxi(xi), resolucion.fxf(xu),resolucion.fxf(xr),test,ea});
        
      } while( ea > em && iteraciones <= maxiteraciones );
    
    }
  }
  
  
  public void ecuacion_dos(){
    
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel() ;
  
    double xu = Double.valueOf(txtxf.getText());  
    double xi = Double.valueOf(textXi.getText());
    int maxiteraciones = Integer.parseInt(jTextField4.getText());
    double em = Double.parseDouble(jTextField1.getText());
    
    resolucion_ecuacion_dos.fxi(xi);
    resolucion_ecuacion_dos.fxf(xu);
    
    if( (resolucion_ecuacion_dos.fxi(xi)*resolucion_ecuacion_dos.fxf(xu)) > 0 ){
      
      System.out.println("No tiene raiz");
      
    }else{
    
    do {          
      
      xrold = xr;
      
      xr = (xi+xu)/2;
      
      ea = Math.abs((xr-xrold)/xr)*100;

      test = resolucion_ecuacion_dos.fxi(xi)*resolucion_ecuacion_dos.fxf(xr);
              
      if( test < 0 ){
        
        xu = xr;
        
      }else if( test > 0 ){
        
        xi = xr;
        
      }else{
        
        ea = 0;
        
      }

      iteraciones  = iteraciones  + 1;
      modelo.addRow(new Object[]{iteraciones,xi,xu,xr,resolucion_ecuacion_dos.fxi(xi),
                    resolucion_ecuacion_dos.fxf(xu),resolucion_ecuacion_dos.fxf(xr),test,ea});
        
      } while( ea > em && iteraciones <= maxiteraciones );
    
    }
  }
  
  private void selecionar(){
    
   switch (opciones) {

 

        case 1:

        ecuacion();

        break;

 

        case 2:

        ecuacion_dos();

        break;

      

        default:

       System.out.println("selecione una opcion");

        break;
 }
     
  }
 
  private void opcionUno(){
    
    opciones = 1;
    
  }
  
   private void opcionDos(){
    
    opciones = 2;
    
  }



  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    txtxf = new javax.swing.JTextField();
    textXi = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    ecuacion_uno = new javax.swing.JRadioButton();
    ecuacion_dos = new javax.swing.JRadioButton();
    jTextField4 = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
    jButton1.setText("Calcular");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jTable1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Xi", "Xu", "Xr", "F(xi)", "F(xu)", "F(xr)", "f(Xi)*F(Xu)", "ea"
      }
    ));
    jTable1.setEnabled(false);
    jTable1.setGridColor(new java.awt.Color(255, 255, 255));
    jScrollPane1.setViewportView(jTable1);

    jLabel4.setText("Xi");

    jLabel5.setText("Xf");

    buttonGroup1.add(ecuacion_uno);
    ecuacion_uno.setText("3(x+1)(x-1/2)(x-1)");
    ecuacion_uno.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ecuacion_unoActionPerformed(evt);
      }
    });

    buttonGroup1.add(ecuacion_dos);
    ecuacion_dos.setText("x^3-7x^2-14x-6");
    ecuacion_dos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ecuacion_dosActionPerformed(evt);
      }
    });

    jLabel7.setText("Numero de iteraciones ");

    jLabel1.setText("Intervalo");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(58, 58, 58)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ecuacion_uno)
          .addComponent(textXi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(68, 68, 68)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(136, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtxf, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(ecuacion_dos)
                .addGap(196, 196, 196))))))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(356, 356, 356))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(38, 38, 38)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ecuacion_uno)
          .addComponent(ecuacion_dos))
        .addGap(38, 38, 38)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(textXi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5)
          .addComponent(txtxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7)
          .addComponent(jLabel1)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(13, 13, 13)
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    selecionar();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void ecuacion_unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecuacion_unoActionPerformed
    // TODO add your handling code here:
    opcionUno();
  }//GEN-LAST:event_ecuacion_unoActionPerformed

  private void ecuacion_dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecuacion_dosActionPerformed
    // TODO add your handling code here:
    opcionDos();
  }//GEN-LAST:event_ecuacion_dosActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(pantalla_calculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(pantalla_calculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(pantalla_calculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(pantalla_calculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new pantalla_calculos().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JRadioButton ecuacion_dos;
  private javax.swing.JRadioButton ecuacion_uno;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JTextField textXi;
  private javax.swing.JTextField txtxf;
  // End of variables declaration//GEN-END:variables
}
