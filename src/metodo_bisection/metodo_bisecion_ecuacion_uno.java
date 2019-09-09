/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_bisection;


public class metodo_bisecion_ecuacion_uno {

  
  public metodo_bisecion_ecuacion_uno(){
    
  }
  
  public double fxi( double xi ){
    
    double fxi = 3*(xi+1)*(xi-0.5)*(xi-1);
    
    return fxi;
  }
  
  public double fxf( double xu ){
    
    double fxu = 3*(xu+1)*(xu-0.5)*(xu-1) ;
    
    return fxu;
    
  }
  
  
}
