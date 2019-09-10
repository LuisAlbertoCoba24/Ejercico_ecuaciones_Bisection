/*
  Esta parte del codigo contiene una interfas grafica, la cual nos muetra los resultados atrabes de una tabla
  despues de dar click en el boton de calcular nos arroja los resultados, para esto selecionamos una ecuacion
  y llenamos los campos correspondientes a lo que nos esta pidiendo.
 */
package gui;

//Impotmos las paquerias de clases y librias a yulizar
import javax.swing.table.DefaultTableModel;//Importamos DefaultTableModel que nos permitira crear el modelo para la tabla
import metodo_bisection.metodo_bisecion_ecuacion_uno;//Tomamos la resolucion de una funcion numero uno
import metodo_bisection.metodo_bisecion_ecuacion_dos;//Importamos la clase de la ecuacion dos pa usar sus metodos  

public class pantalla_calculos extends javax.swing.JFrame {

  //Inicamos nustras clase las cuales continen la funcion de cada ecuacion o su resolucion de sustitucion
  metodo_bisecion_ecuacion_uno resolucion = new metodo_bisecion_ecuacion_uno();
  metodo_bisecion_ecuacion_dos resolucion_ecuacion_dos = new metodo_bisecion_ecuacion_dos();
 
  //Creamos algunas variables locales para almacenar las operaciones.
  private int iteraciones = 0;//La varaiable de iteraciones nos contendra el numero de repeticiones que realizara el ciclo
  private double xr = 0;//Esta variable contendra el resultado de la formula  (xi + xu)/2, 
                        //de igual forma usaremos para el camvio de variable y la realizacion de su funcion
  private double test = 0;//Contendra los resultados al mutiplicar f(xi)*f(xr) y usaremos para evaluar con los if 
  private double ea = 0;//Con esta variable almacenaremos el error aproximado, por cada repeticion
  private double xrold = 0;//Usaremos como intermediario para guardar el valor de nuettra variable xr
  private int opciones = 0;//Almacena la elecion de la ecuacion segun el usuario
  
  //Clae publica donde se inician los componentes de la interfas grafica
  public pantalla_calculos() {
    initComponents(); //Componentes de interfas grafica
  }
  
  //Metodo de de carga de opcion 
  private void opcionUno(){
    
    //En la varable opcion cargamos el numero uno que nos ayudara a la elecion dentro del switch
    //Al selecionar la premeria ecuacion "3(x+1)(x-1/2)(x-1)" del radio buttom cargara nuetra variable con este numero
    opciones = 1;
    
  }
  
   private void opcionDos(){
    
    //En la varable opcion cargamos el numero dos que nos ayudara a la elecion dentro del switch
    //Al selecionar la segunda ecuacion "x^3-7x^2-14x-6" del radio buttom cargara nuetra variable con este numero
    opciones = 2;
    
  }
   
   //Creamos el metodo o procedimiento de selecion el cual ara la selecion del metodo a usar de las ecuaciones
  private void selecionar(){
    
    //Pasamos la variable opciones, en el switch para selecionar el caso, cada caso contiene una ecuacion
    //Caso numero 1 contiene la reslucion del metodo de bisecion del la ecuacion numero 1
    //El caso dos contiene la resolucion del metodo de bisecion de la ecuacion numero 2
    switch (opciones) { //pasamos la variable opciones 

 
      //Se comprueva el valor de la varibale opciones si es 1 entra en este caso
      case 1:
        //Dentro de case este el metodo para de la resolucion de la ecuacion numero 1 
        ecuacion();
      break; //rompemos el case despues de terminar el proseso para salir del bucle 


      case 2:
        //Dentro de case este el metodo para de la resolucion de la ecuacion numero 2
        ecuacion_dos();
      break;
      
        //si la aplicacion no encuentra ninguna opcion mostrara el siguiente mensaje 
      default:

      System.out.println("selecione una opcion");

      break;
    } 
  }
 
  //proceso de resolucion con el metodo de bisecion, ecuqacion numero 1
  private void ecuacion(){
    
    //cramos un modelo el cual  se usara para la carga de los datos dirigida a la tabla en la interfas 
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel() ;
    
    //creamos la variable xu acuando como datos inferior 
    //que almacenara los datos recuperados de la caja de texto y convertira a double
    double xu = Double.valueOf(txtxf.getText());
    //cremoa la variable xi acuando como el dato superior, y almacena los datos optenidos de la caja de texto
    double xi = Double.valueOf(textXi.getText());
    //la varibale maxiteraciones, nos ayuda a limitar el numero de repeticiones del siclo
    int maxiteraciones = Integer.parseInt(jTextField4.getText());
    //em es el numoer de error aproximado que deseamos encontrar
    double em = Double.parseDouble(jTextField1.getText());
    
    //Llamamos a los metodo de resolucion los cuales contienen los metodos para resolver la ecuacion
    //multiplicamos los resultados y compramos el valor de 0
    if( (resolucion.fxi(xi)*resolucion.fxf(xu)) >= 0 ){
      
      //si es mayor a 0 no tiene raiz y muetra el mensaje
      System.out.println("No tiene raiz");
      
    }else{ //si la consion no se cumple pasamo al siguiente paso o la opcion
    
      //usamos el siclo do para primero ir haciendo el prosedimiento
    do {          
      
      //usamos la variable xrold para guardar xr
      xrold = xr;
      
      //guardamos los resultados de nuetra formalula aplicada
      xr = (xi+xu)/2;
      
      ea = Math.abs((xr-xrold)/xr)*100;//alpicamos y realizamos la formula de error aproximado
      
      //guardamos la multiplicacion pasando xr por la resolucion de ecuaciones
      test = resolucion.fxi(xi)*resolucion.fxf(xr);
      
      //realisamos la evalucion de la variable test
      if( test < 0 ){ 
        
        //si test es menor a 0 asignamos la variable xr a varible xu
        xu = xr;
        
      }else if( test > 0 ){//si la condicion no se cumple lo anterior volvemos a comprar mediante una nueva condicion 

        
        xi = xr;//camviamos el valor de xi por xr
        
      }else{
        //si ninguna condicion se cumple el error minimo es 0 y termina el proceso
        ea = 0;
      }
      
      //aumentamos la el contador de las iteraciones posibles
      iteraciones  = iteraciones  + 1;
      //Aumentamos el modelo de la tabla agregando una columna 
      modelo.addRow(new Object[]{iteraciones,xi,xu,xr,resolucion.fxi(xi), resolucion.fxf(xu),resolucion.fxf(xr),test,ea});
        
      } while( ea > em && iteraciones <= maxiteraciones );
    
    }
  }
  
  
  public void ecuacion_dos(){
    
    //cramos un modelo el cual  se usara para la carga de los datos dirigida a la tabla en la interfas 
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel() ;
    
    //creamos la variable xu acuando como datos inferior 
    //que almacenara los datos recuperados de la caja de texto y convertira a double
    double xu = Double.valueOf(txtxf.getText());
    //cremoa la variable xi acuando como el dato superior, y almacena los datos optenidos de la caja de texto
    double xi = Double.valueOf(textXi.getText());
    //la varibale maxiteraciones, nos ayuda a limitar el numero de repeticiones del siclo
    int maxiteraciones = Integer.parseInt(jTextField4.getText());
    //em es el numoer de error aproximado que deseamos encontrar
    double em = Double.parseDouble(jTextField1.getText());
    
    //Llamamos a los metodo de resolucion los cuales contienen los metodos para resolver la ecuacion
    //Multiplicamos los resultados y compramos el valor de 0
    if( (resolucion_ecuacion_dos.fxi(xi)*resolucion_ecuacion_dos.fxf(xu)) > 0 ){
      
      //Si es mayor a 0 no tiene raiz y muetra el mensaje
      System.out.println("No tiene raiz");
      
    }else{//si la consion no se cumple pasamo al siguiente paso
    
    //usamos el siclo do para primero ir haciendo el prosedimiento
    do {          
      
      //usamos la variable xrold para guardar xr
      xrold = xr;
      
      xr = (xi+xu)/2;//guardamos los resultados de nuetra formalula aplicada
      
      ea = Math.abs((xr-xrold)/xr)*100;//alpicamos y realizamos la formula de error aproximado
      
      //guardamos la multiplicacion pasando xr por la resolucion de ecuaciones
      test = resolucion_ecuacion_dos.fxi(xi)*resolucion_ecuacion_dos.fxf(xr);
              
      if( test < 0 ){
        //si test es menor a 0 asignamos la variable xr a varible xu
        xu = xr;
        
      }else if( test > 0 ){//si la condicion no se cumple lo anterior volvemos a comprar mediante una nueva condicion 

        xi = xr;//camviamos el valor de xi por xr
        
      }else{
        //si ninguna condicion se cumple el error minimo es 0 y termina el proceso
        ea = 0;
      }
      
      //aumentamos la el contador de las iteraciones posibles
      iteraciones  = iteraciones  + 1;
      //Aumentamos el modelo de la tabla agregando una columna 
      modelo.addRow(new Object[]{iteraciones,xi,xu,xr,resolucion_ecuacion_dos.fxi(xi),
                    resolucion_ecuacion_dos.fxf(xu),resolucion_ecuacion_dos.fxf(xr),test,ea});
        
      } while( ea > em && iteraciones <= maxiteraciones );
    
    }
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
