/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4atema6caamal;

import java.util.ArrayList;

/**
 *
 * @author m
 */
public class ctrlEuler {
    double h, intervaloI, intervaloF, valorInicial;

    public ctrlEuler(double h, double intervaloI, double intervaloF, double valorInicial) {
        this.h = h;
        this.intervaloI = intervaloI;
        this.intervaloF = intervaloF;
        this.valorInicial = valorInicial;
    }
    
    private double getEvaluacionXi(double xi, double yi){
        return yi+(-2*Math.pow(xi,3)+12*Math.pow(xi, 2)-20*xi+8.5)*this.h;
  
    }
    
     public ArrayList<filaEuler> Euler(){
         ArrayList<filaEuler> listaSoluciones=new ArrayList<>();
         int i=0;
         double incrementos=intervaloI;
         double yi=0;
         double iteraciones=(this.intervaloF/h);
         while(i<=iteraciones){
            filaEuler fila=new filaEuler();
            if(i==0){
                  
                  fila.setXi(this.intervaloI);
                  fila.setYi(this.valorInicial);
                  yi=this.getEvaluacionXi(intervaloI, valorInicial);

            }else{
            fila.setXi(incrementos);
            fila.setYi(yi);    
            yi=this.getEvaluacionXi(incrementos, yi);
            
            }
            
            listaSoluciones.add(fila);
            incrementos+=this.h;
            i++;
         }
         
         return listaSoluciones;
     }
    
        public tablaEuler getTablaEuler(){
        tablaEuler modelo=null;
        
        ArrayList<filaEuler> lista=this.Euler();
        
        modelo=new tablaEuler(lista);
        return modelo;
    
    }
}
