/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulermodificado;
import java.util.Scanner;
/**
 *
 * @author alanizgustavo
 */
public class EulerModificado {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double x,x0,y0,h,xn,yPrima,yFinal;
        double i,j;
        System.out.println("INGRESE EL VALOR DE X0");
        x=sc.nextDouble();
        System.out.println("INGRESE EL VALOR DE Y0");
        y0=sc.nextDouble();
        System.out.println("INGRESE EL VALOR DE H");
        h=sc.nextDouble();
        System.out.println("INGRESE EL VALOR DE YN");
        xn=sc.nextDouble();
        x0=x;
        //double [][] matriz=new double [2][(xn-x)/h];
        for(i=x+h;i<xn+h;i=i+h){ 
            yPrima=y0+h*(funcion(x0,y0));
            
            yFinal=y0+h/2*(funcion(x0,y0)+funcion(i,yPrima));
            
            y0=yFinal;
            x0=i;
            
            System.out.println("El valor de Y("+x0+") es: "+ y0);
        }
        
        
    }
    public static double funcion(double x, double y){
        double derivada;
        
        derivada=2*x*y; //modifiar la ecuacion diferencial
        
        return derivada;
    }
}
