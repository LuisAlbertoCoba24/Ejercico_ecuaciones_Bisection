/*
 * Integrantes: Luis Alberto Coba Ventura
 * seccion 2
 * generacion 2018
 * metodo de falsa posicion
 */
package gui;

//Impotamos paqueterias a usar para la creacion de nuestros metodos
import javax.swing.table.DefaultTableModel; //no ayuda en la cracion del modelo de nuetra tabla
import metodo_bisection.ecuaciones_metodo_falsa_posicion;//traemos las ecuaciones definidas
import javax.swing.JOptionPane;

public class falsa_posicion extends javax.swing.JFrame {
  
  //Declaramos el modelo que se cargara a la base de datos 
  DefaultTableModel modelo_tabla = new DefaultTableModel();
  //Inicialisamos el metodo de las bariables 
  ecuaciones_metodo_falsa_posicion ecuaciones = new ecuaciones_metodo_falsa_posicion();
  
  //creamos variables universales
  static int opciones = 0;//Nos ayuda para guardar el valor del radiobuton 
  static  double q = 0;// Esta variable garda la respuesta del resultado de la ecuacion
  static  double tol = 0.00;//
  static  double ea = 1;
  static  double p = 0;//Guarda el resultado de aplicar la formula utilizando q1 y q0, en el paso dos
  static  double p0 = 0;//
  static  double p1 = 0;//
  static  double q0 = 0;//
  static  double q1 = 0;//
  
  /**
   * Metodo de inicialisacion de componentes.
  */
  public falsa_posicion() {
    initComponents();
    inicartabla();
  }
  
  /*
  
   Este metodo asigna al modelo de la tabla las columanas con los siguientes nombres
    esto para poder identificar el orden de los datos, que gardaremos en el modelo, este modelo lo mostraremos 
    en la interfas grafica 
  
  */
  private void inicartabla() {
    
    /*Declaramos el nombre de las columnas
     *añadimos en el modelo de la tabla*/
    modelo_tabla.addColumn("No");
    modelo_tabla.addColumn("P");
    modelo_tabla.addColumn("P0");
    modelo_tabla.addColumn("P1");
    modelo_tabla.addColumn("F(P0)");
    modelo_tabla.addColumn("F(P1)");
    modelo_tabla.addColumn("q");
    modelo_tabla.addColumn("q0");
    modelo_tabla.addColumn("q1");
    
    //cargamos el modelo de la tabla
    tableDatos.setModel(modelo_tabla);
  }

  private void limpiar_tabla(){
   /*El metodo de limpiar tabla elimina los renglones del modelo de tabla datos, 
      y carga un modelo vasio */ 
    DefaultTableModel eliminar_datos = new DefaultTableModel();//Creacion de nuevo modelo para la tabla 
    
    tableDatos.setModel(eliminar_datos);//Asignamos el modelo vasio a la tabla 
    
    modelo_tabla.setRowCount(0);//Limpia el modelo generar de la tabla 
  }
  
  //Este metodo nos permite lansar una alerta con el mensaje que nostros demos
  private void alerta(String mensaje){
    
    JOptionPane.showMessageDialog(null, mensaje);
    
  }
  
  /*
  * Los metodos de pciones nos permiten asigan un valor numerico a nuestra variable opciones para usarla 
  * en el metodo de prosedimiento que contiene un switch el cual garda las opciones que podemos usar
  * haciendo referencia a las ecuaciones que se nos muestran en la interfas, cada radio button cuenta con una metodo de 
  * opcion.
  */
  private void opcion_uno(){
    //La opcion uno se encuentra en el radio button que como texto tiene x^3-2x^2-5
    opciones = 1;
  }
  
  private void opcion_dos(){
    //La opcion dos se encuentra en el radio button que como texto tiene x^3+3x^2-1
    opciones = 2;
  }
  
  private void opcion_tres(){
    //La opcion tres se encuentra en el radio button que como texto tiene x - cos x
    opciones = 3;
  }
  
  private void opcion_cuatro(){
    //La opcion cuatro se encuentra en el radio button que como texto tiene x-0.8-0.2sinx
    opciones = 4;
  }
  
  
  private void procedimiento(){
  
    //Pasamos la variable opciones, en el switch para selecionar el caso, cada caso contiene una ecuacion
    //Caso numero 1 contiene la reslucion del metodo de bisecion del la ecuacion numero 1
    //El caso dos contiene la resolucion del metodo de bisecion de la ecuacion numero 2
    switch (opciones) {

      //Se comprueva el valor de la varibale opciones si es 1 entra en este caso
      case 1:
        //Dentro de case este el metodo para de la resolucion de la ecuacion numero 1
        procedimiento_ecuacion_uno();
        
      break; //rompemos el case despues de terminar el proseso para salir del bucle 


      
      case 2:
        //Dentro de case este el metodo para de la resolucion de la ecuacion numero 2
        procedimiento_ecuacion_dos();
        
      break;
        
      case 3:
        //Dentro de case este el metodo para de la resolucion de la ecuacion numero 3
       
        
      break;
        
      case 4:
        //Dentro de case este el metodo para de la resolucion de la ecuacion numero 4
       
        
      break;
      
        //si la aplicacion no encuentra ninguna opcion mostrara el siguiente mensaje 
      default:

      
      alerta("selecione una Ecuacion"); //utilizamos el metodo de alerta para mostrar este mesja

      break;
    } 
    
  }
  
  private void procedimiento_ecuacion_uno(){
    
    int i = 0; //Iniciamos un contador en 0 para controlar el nuevo numero de repeticiones
    
    p0 = Double.parseDouble( textFieldP0.getText() );//Obtenemos los valores de la caja de texto(textFieldP0) y combertimos a double
    p1 = Double.parseDouble( textFieldP1.getText() );//Obtenemos los valores de la caja de texto (textFieldP1) y converimos a double
    
    //ralizamos la resolucion de la ecuacion
    //Damos el dato de p0 recuperado para saver el resultado de la ecuacion y asignarlo a q0
    q0 = ecuaciones.ecuacionNumeroDos(p0);
    //Damos el dato de p1 recuperado para saver el resultado de la ecuacion y asignarlo a q1
    q1 = ecuaciones.ecuacionNumeroDos(p1);
    
    //Se realiza un ciclo mientras, para repetir el metodo de falsa posicion, 
    //esto se repite hasta llegar al maximo numero de interaciones  
    while( (i <= 20) && ( ea != 0 )){
      
      //cargamos el modelo con las datos que mostraremos en la interfas grafica, estos datos se separan por una coma,
      //este objeto se le colocan las varibales que se quieran mostrar en el orden de la estructura antes construida
      modelo_tabla.addRow( new Object[]{i,p,p0,p1,ecuaciones.ecuacionNumeroDos(p0),ecuaciones.ecuacionNumeroDos(p1),
                            q,q0,q1 });
      
      //Aplicamos la formula para encontrar a p utilizando las varbles que contienen los numeros recuperados de las 
      //cajas de texto y las variables de contien los resultados de las ecuaciones
      p = p1 - (q1 * (( p1 - p0)/( q1 - q0 )));
     
      //Se realiza una comparacion, con el valo absoluto de la resta de p para comprovar si es mejor que la tolerancia
      if((Math.abs( p - p1)) < tol ){
        //Si la afirmacion es correcta se asigna el numero 0 a la variable error aproximado
        ea = 0;
        
      }//Si la sentencia no se cumple no se raliza nada.
      
      //Despues del pasar por la condicion se ralizan las sigientes operaciones 
      q = ecuaciones.ecuacionNumeroDos(p);//se resuelve la ecuacion pasando como valor la variable p
      
      //Despues de obtener el resultado de la ecuacion, realizamos una multiplicacion de q con q1 y el resultado 
      //lo comparamos, si el resultado es menor a 0 
      if( (q * q1) < 0 ){
        
        //Si es menor a 0, intercamviamos las variables, quitando el valor de p0 y dandole el valor de p1
        p0 = p1;
        
      }else
      {
        //En caso contrario si es mayor damos el valor a q0 de la varibale q1
        q0 = q1;
      }
      
      //Se realiza un cambio de variables
      p1 = p; //A p1 asigamos a p
      q1 = q; //A q1 asignamos a q
      
      i = i + 1; //Incrementamos el contador en uno
     
    }
    
    tableDatos.setModel(modelo_tabla); //asigsamos el modelo a la tabla con los neuvos renglones
  }
  
  private void procedimiento_ecuacion_dos(){
    
    int i = 0; //Iniciamos un contador en 0 para controlar el nuevo numero de repeticiones
    
    p0 = Double.parseDouble( textFieldP0.getText() );//Obtenemos los valores de la caja de texto(textFieldP0) y combertimos a double
    p1 = Double.parseDouble( textFieldP1.getText() );//Obtenemos los valores de la caja de texto (textFieldP1) y converimos a double
    
    //ralizamos la resolucion de la ecuacion
    //Damos el dato de p0 recuperado para saver el resultado de la ecuacion y asignarlo a q0
    q0 = ecuaciones.ecuacionNumeroUno(p0);
    //Damos el dato de p1 recuperado para saver el resultado de la ecuacion y asignarlo a q1
    q1 = ecuaciones.ecuacionNumeroUno(p1);
    
    //Se realiza un ciclo mientras, para repetir el metodo de falsa posicion, 
    //esto se repite hasta llegar al maximo numero de interaciones  
    while( (i <= 20) && ( ea != 0 )){
      
      //cargamos el modelo con las datos que mostraremos en la interfas grafica, estos datos se separan por una coma,
      //este objeto se le colocan las varibales que se quieran mostrar en el orden de la estructura antes construida
      modelo_tabla.addRow( new Object[]{i,p,p0,p1,ecuaciones.ecuacionNumeroUno(p0),ecuaciones.ecuacionNumeroUno(p1),
                            q,q0,q1 });
      
      //Aplicamos la formula para encontrar a p utilizando las varbles que contienen los numeros recuperados de las 
      //cajas de texto y las variables de contien los resultados de las ecuaciones
      p = p1 - (q1 * (( p1 - p0)/( q1 - q0 )));
     
      //Se realiza una comparacion, con el valo absoluto de la resta de p para comprovar si es mejor que la tolerancia
      if((Math.abs( p - p1)) < tol ){
        //Si la afirmacion es correcta se asigna el numero 0 a la variable error aproximado
        ea = 0;
        
      }//Si la sentencia no se cumple no se raliza nada.
      
      //Despues del pasar por la condicion se ralizan las sigientes operaciones 
      q = ecuaciones.ecuacionNumeroUno(p);//se resuelve la ecuacion pasando como valor la variable p
      
      //Despues de obtener el resultado de la ecuacion, realizamos una multiplicacion de q con q1 y el resultado 
      //lo comparamos, si el resultado es menor a 0 
      if( (q * q1) < 0 ){
        
        //Si es menor a 0, intercamviamos las variables, quitando el valor de p0 y dandole el valor de p1
        p0 = p1;
        
      }else
      {
        //En caso contrario si es mayor damos el valor a q0 de la varibale q1
        q0 = q1;
      }
      
      //Se realiza un cambio de variables
      p1 = p; //A p1 asigamos a p
      q1 = q; //A q1 asignamos a q
      
      i = i + 1; //Incrementamos el contador en uno
     
    }
    
    tableDatos.setModel(modelo_tabla); //asigsamos el modelo a la tabla con los neuvos renglones
  }
  
  
  
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    ecuacionA = new javax.swing.JRadioButton();
    ecuacionB = new javax.swing.JRadioButton();
    ecuacionC = new javax.swing.JRadioButton();
    ecuacionD = new javax.swing.JRadioButton();
    jPanel2 = new javax.swing.JPanel();
    textFieldP0 = new javax.swing.JTextField();
    textFieldP1 = new javax.swing.JTextField();
    jTextField3 = new javax.swing.JTextField();
    jTextField4 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tableDatos = new javax.swing.JTable();
    buttonLimpiarTabla = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ecuaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 1, 14))); // NOI18N

    buttonGroup1.add(ecuacionA);
    ecuacionA.setText("x^3-2x^2-5");
    ecuacionA.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ecuacionAActionPerformed(evt);
      }
    });

    buttonGroup1.add(ecuacionB);
    ecuacionB.setText("x^3+3x^2-1");
    ecuacionB.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ecuacionBActionPerformed(evt);
      }
    });

    buttonGroup1.add(ecuacionC);
    ecuacionC.setText("x - cos x");
    ecuacionC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ecuacionCActionPerformed(evt);
      }
    });

    buttonGroup1.add(ecuacionD);
    ecuacionD.setText("x-0.8-0.2sinx");
    ecuacionD.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ecuacionDActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(ecuacionA)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
        .addComponent(ecuacionB)
        .addGap(140, 140, 140)
        .addComponent(ecuacionC)
        .addGap(139, 139, 139)
        .addComponent(ecuacionD)
        .addGap(63, 63, 63))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(15, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ecuacionA)
          .addComponent(ecuacionB)
          .addComponent(ecuacionC)
          .addComponent(ecuacionD))
        .addGap(19, 19, 19))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton1.setText("Calcular");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel1.setText("No iteraciones");

    jLabel2.setText("Tolerancia");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setText("P0");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel4.setText("P1");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(156, 156, 156)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(textFieldP0)
              .addComponent(jTextField3)
              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
            .addGap(158, 158, 158)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(textFieldP1)
              .addComponent(jTextField4)
              .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(343, 343, 343)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(textFieldP0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(textFieldP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tableDatos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {},
        {},
        {},
        {}
      },
      new String [] {

      }
    ));
    jScrollPane1.setViewportView(tableDatos);

    buttonLimpiarTabla.setText("Limpiar Tabla");
    buttonLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonLimpiarTablaActionPerformed(evt);
      }
    });

    jButton2.setText("jButton2");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jScrollPane1)
      .addGroup(layout.createSequentialGroup()
        .addGap(84, 84, 84)
        .addComponent(buttonLimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(164, 164, 164)
        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonLimpiarTabla)
          .addComponent(jButton2))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarTablaActionPerformed
    // TODO add your handling code here:
    limpiar_tabla();
  }//GEN-LAST:event_buttonLimpiarTablaActionPerformed

  private void ecuacionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecuacionAActionPerformed
    // TODO add your handling code here:
    opcion_uno();
    limpiar_tabla();
  }//GEN-LAST:event_ecuacionAActionPerformed

  private void ecuacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecuacionBActionPerformed
    // TODO add your handling code here:
    opcion_dos();
    limpiar_tabla();
  }//GEN-LAST:event_ecuacionBActionPerformed

  private void ecuacionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecuacionCActionPerformed
    // TODO add your handling code here:
    opcion_tres();
    limpiar_tabla();
  }//GEN-LAST:event_ecuacionCActionPerformed

  private void ecuacionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecuacionDActionPerformed
    // TODO add your handling code here:
    opcion_cuatro();
    limpiar_tabla();
    
  }//GEN-LAST:event_ecuacionDActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    procedimiento();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton2ActionPerformed

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
      java.util.logging.Logger.getLogger(falsa_posicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(falsa_posicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(falsa_posicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(falsa_posicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new falsa_posicion().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton buttonLimpiarTabla;
  private javax.swing.JRadioButton ecuacionA;
  private javax.swing.JRadioButton ecuacionB;
  private javax.swing.JRadioButton ecuacionC;
  private javax.swing.JRadioButton ecuacionD;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField jTextField3;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JTable tableDatos;
  private javax.swing.JTextField textFieldP0;
  private javax.swing.JTextField textFieldP1;
  // End of variables declaration//GEN-END:variables
}
