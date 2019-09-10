/*
 este archivo contiene la estructura para la resolucion de la primera ecuacion
 */
package metodo_bisection;

public class metodo_bisecion_ecuacion_dos {
  
  //cramos el constructor vacio 
  public metodo_bisecion_ecuacion_dos(){
    
  }
  
  //cramos instancias de nuestros procesos y ecuaciones
  public double fxi( double xi ){
    
    //realizamos la resolucion de la ecuacion colocando los valores de forma correcta 
    double fxi = (Math.pow(xi,3))-(-7*(Math.pow(xi,2)))-(14*xi)-6;
    
    //cramos instancias de nuestros procesos y ecuaciones
    return fxi;
  }
  
  //cramos instancias de nuestros procesos y ecuaciones
  public double fxf( double xu ){
    
    //realizamos la resolucion de la ecuacion colocando los valores de forma correcta 
    double fxu = (Math.pow(xu,3))-7*(Math.pow(xu,2))-14*xu-6 ;
    
    //cramos instancias de nuestros procesos y ecuaciones
    return fxu;
    
  }
}
