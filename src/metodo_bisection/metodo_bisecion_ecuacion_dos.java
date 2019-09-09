/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_bisection;

public class metodo_bisecion_ecuacion_dos {
  
  public metodo_bisecion_ecuacion_dos(){
    
  }
  
  public double fxi( double xi ){
    
    double fxi = (Math.pow(xi,3))-7*(Math.pow(xi,2))-14*xi-6;
    
    return fxi;
  }
  
  public double fxf( double xu ){
    
    double fxu = (Math.pow(xu,3))-7*(Math.pow(xu,2))-14*xu-6 ;
    
    return fxu;
    
  }
}
