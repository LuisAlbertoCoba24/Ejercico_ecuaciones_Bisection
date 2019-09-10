/*
 este archivo contiene la estructura para la resolucion de la primera ecuacion
 */
package metodo_bisection;


public class metodo_bisecion_ecuacion_uno {

  //cramos el constructor vacio 
  public metodo_bisecion_ecuacion_uno(){
  }
  
  //cramos instancias de nuestros procesos y ecuaciones
  public double fxi( double xi ){
    
    //realizamos la resolucion de la ecuacion colocando los valores de forma correcta 
    double fxi = 3*(xi+1)*(xi-0.5)*(xi-1);
    
    //retornamos el valor de la ecuacion
    return fxi;
  }
  
  //cramos instancias de nuestros procesos y ecuaciones
  public double fxf( double xu ){
    
    //realizamos la resolucion de la ecuacion colocando los valores de forma correcta 
    double fxu = 3*(xu+1)*(xu-0.5)*(xu-1) ;
    
    //retornamos el valor de la ecuacion
    return fxu;
    
  }
  
  
}
