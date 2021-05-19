/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metododeintegracion;
import utiles.TecladoIn;
/**
 *
 * @author alanizgustavo
 */
public class MetodoDeIntegracion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir=false;
        int opcion;
        double a, b, n; 
        String sigue;
        System.out.println("Ingrese a");
        a = TecladoIn.readLineDouble();
        System.out.println("Ingrese b"); //Lectura de datos
        b = TecladoIn.readLineDouble();
        System.out.println("Ingrese n");
        n = TecladoIn.readLineDouble();
        do{
            System.out.println("ELIJA UNA OPCION");
            System.out.println("1- CALCULAR INTEGRAL POR TRAPECIOS");
            System.out.println("2- CALCULAR INTEGRAL POR SIMPSON 1/3");
            opcion=TecladoIn.readInt();
            switch(opcion){
                case 1: if(opcion==1){
                            trapecios(a,b,n);
                        }
                break;
             case 2: if(opcion==2){
                            simpson(a,b,n);
                        } 
             break;
            }
            System.out.println("Desea realizar otra operacion?");
            sigue=TecladoIn.readLine();
            if(sigue.equalsIgnoreCase("si")){
                seguir=true;
            }
            else{
                seguir=false;
            }
                    
        }
        while(seguir);
    }
    //modulo que calcula integral segun metodo de trapecios
    public static void trapecios(double a, double b, double n){
        double h, res = 0, i;
        h = (b - a) / n;
        for (i = 1; i < n; i++) { //Sumatoria desde 1 hasta n-1: f(x_i)
            res = res + f5(a + i * h);
        }
        System.out.println("Integral aproximada: " + (h / 2 * (f5(a) + f5(b) + 2 * res)));
    }
   
    
    //modulo que calcula la integral segun simpson 1/3
    public static void simpson(double a,double b,double n) {
        double h, res = 0, i, j, sum1 = 0, sum2 = 0;
        h = (b - a) / n;
        for (i = 1; i < n; i = i + 2) {
            sum1 = sum1 + f5(a + i * h);
        }
        for (j = 2; j < n - 1; j = j + 2) {
            sum2 = sum2 + f5(a + j * h);
        }
        System.out.println("Integral aproximada: " + (h / 3 * (f5(a) + f5(b) + 4 * sum1 + 2 * sum2)));
    }
    
    //modulo donde se ingresa la funcion a evalura
    public static double f5(double x){
        double b;
        return b=Math.tan(x);//ingresar la funcion aqui
    }
}
