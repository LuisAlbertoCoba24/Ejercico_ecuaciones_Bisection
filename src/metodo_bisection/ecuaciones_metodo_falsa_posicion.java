/*
 * Esta clase contiene varios metodos los cuales cada uno de ellos contienen la estructura de la ecuacion a resolver
 */
package metodo_bisection;

public class ecuaciones_metodo_falsa_posicion {
  
  //metodo de primera ecuacion
  public double ecuacionNumeroUno(double p){
    //declaramos la variable resultado que contendra el resultado de la operacion
    //Colocamos la estructura de la ecuacion que usaremos para resolver la ecuacion
    double resultado = ( (Math.pow( p , 3 )) - ( 2 * ( Math.pow (p,2) ) ) ) - 5;
    
    return resultado;//retorna el resultado de la operacion
  }
  
  //metodo de segunda ecuacion
  public double ecuacionNumeroDos(double p){
    //declaramos la variable resultado que contendra el resultado de la operacion
    //Colocamos la estructura de la ecuacion que usaremos para resolver la ecuacion
    double resultado = ( ( Math.pow(p, 3) ) + ( 3 * (Math.pow(p, 2))) ) - 1;
    
    return resultado;
  }
  
  //metodo de tercera ecuacion
  public double ecuacionNumeroTres(double p){
    //declaramos la variable resultado que contendra el resultado de la operacion
    //Colocamos la estructura de la ecuacion que usaremos para resolver la ecuacion
    double resultado = p - Math.cos(p);
    
    return resultado;//retorna el resultado de la operacion
  }
  
  //metodo de cuarta ecuacion
  public double ecuacionNumeroCuatro(double p){
    //declaramos la variable resultado que contendra el resultado de la operacion
    //Colocamos la estructura de la ecuacion que usaremos para resolver la ecuacion
    double resultado = p - 0.8 - ( 0.2 * (Math.sin(p)) );
    return resultado;//retorna el resultado de la operacion
  }
  
  
  
}
