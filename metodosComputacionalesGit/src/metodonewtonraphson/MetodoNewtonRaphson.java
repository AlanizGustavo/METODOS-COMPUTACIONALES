/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodonewtonraphson;
import java.util.Scanner;
/**
 *
 * @author alanizgustavo
 */
public class MetodoNewtonRaphson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese X0");
        double X0=sc.nextDouble();
        double X1=X0;
        System.out.println("Ingrese el valor del error E: ");
        double E=sc.nextDouble();
        while(Math.abs(f(X1))>E){
            if(df(X0)!=0){
                System.out.println("X0= "+X0);
                System.out.println("f(X0)= "+f(X0));
                System.out.println("df(X0)= "+df(X0));     
                X1=X0-f(X0)/df(X0);
                System.out.println("X1= "+X1);
                X0=X1;
            }
            else{
                System.out.println("La derivada en x0=0");
            }
        }
        System.out.println("Raiz aproximada: "+X1);
    }
    public static double f(double x){
        double res=x*x*x;  // Puede modificar aquí la función a evaluar
        return res;
    }
    public static double df(double x){
        double res=3*(x*x);  // Debe ingresar aquí la función derivada correspondiente
        return res;
    }
}

