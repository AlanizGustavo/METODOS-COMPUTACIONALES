/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metododebiseccion;
import java.util.Scanner;
/**
 *
 * @author alanizgustavo
 */
public class MetodoDeBiseccion {

    /**
     * @param args the command line arguments
     */
    /*PROGRAMA PARA CALCULAR RAICES APROXIMADAS POR METODO DE BISECCION EN UNA FUNCION
    QUE SEA CONTINUA EN TODOS LOS PUNTOS DEL INTERVALO A CONSIDERAR*/
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       int cont=0;
       double r;
       System.out.println("Ingrese el valor de a");//valor de cota inferior del intervalo
       double a=sc.nextDouble();
       System.out.println("Ingrese el valor de b");//valor de cota superiro del intervalo
       double b=sc.nextDouble();
       System.out.println("Ingrese el valor del Error E"); //Error a considerar para el calculo del metodo
       double E=sc.nextDouble();
       if((f(a)*f(b))<0){
          do{
              cont=cont+1;
              r=(a+b)/2;
              System.out.println("Iteracion "+cont+": "+r);
              System.out.println(f(r));
              if((f(a)*f(r))<0){
                  b=r;
              }
              else{
                          a=r;
              }
            }
            while(Math.abs(f(r))>E);
                  System.out.println("Raiz aproximada: "+r);
              
        }
         
       else{
           System.out.print("No se cumple la condicion inicial f(a)*f(b)<0. "
                   + "El teorema de bolsano aseguro un f(r)=0 cuando la funcion "
                   + "evaluada en sus extremos difiere del signo");
       }
    }
    
    public static double f(double x){
        double resultado=Math.pow(x, 3)-2*x-1; //INGRESAR LA FUNCION EN LA CUAL SE QUIERA EVALUAR
        return resultado;
    }
       
}
    

