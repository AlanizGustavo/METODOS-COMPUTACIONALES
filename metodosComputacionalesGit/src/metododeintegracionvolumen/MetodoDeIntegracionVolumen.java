/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metododeintegracionvolumen;
import java.util.Scanner;
/**
 *
 * @author alanizgustavo
 */
public class MetodoDeIntegracionVolumen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean seguir=true;
        int opcion,n,m;
        double a, b, c,d; 
        String sigue;
        System.out.println("INGRESE EL LIMITE INFERIOR DE X A EVALUAR");
        a = sc.nextDouble();
        System.out.println("INGRESE EL LIMITE SUPERIOR DE X A EVALUAR"); //Lectura de datos
        b = sc.nextDouble();;
        System.out.println("INGRESE EL NUMERO DE SUBDIVISIONES EN X");
        n = sc.nextInt();
        System.out.println("INGRESE EL LIMITE INFERIOR DE Y A EVALUAR");
        c = sc.nextDouble();
        System.out.println("INGRESE EL LIMITE SUPERIOR DE Y A EVALUAR"); //Lectura de datos
        d = sc.nextDouble();;
        System.out.println("INGRESE EL NUMERO DE SUBDIVISIONES EN Y");
        m = sc.nextInt();
        do{
            System.out.println("ELIJA UNA OPCION");
            System.out.println("1- CALCULAR VOLUMEN  POR TRAPECIOS");
            System.out.println("2- CALCULAR VOLUMEN POR SIMPSON 1/3");
            opcion=sc.nextInt();
            switch(opcion){
                case 1: if(opcion==1){
                            trapecios(a,b,n,c,d,m);
                        }
                break;
             case 2: if(opcion==2){
                            simpson(a,b,m,c,d,n);
                        } 
             break;
            }
            System.out.println("Desea realizar otra operacion?");
            sigue=sc.nextLine();
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
    public static void trapecios(double a, double b, int m,double c, double d,int n){
        double[][] lineal=new double[n+1][m+1];
        double[]lineal2=new double[n+1];
        double h,k, res = 0,res2=0,resul=0;
        int p=0,i,j;
        double g=a,f=c;
        k = (d - c) / n;
        h = (b - a) / m;
        
        for(i = 0; i <n+1; i++){
            for (j=0;j<m+1;j++)  { 
                
                lineal[i][j]=f5(g,f);
                System.out.print(lineal[i][j]+" ");
                g=g+h;
                
            }
            System.out.println();
            g=a;
            f=f+k;
        }
        
        
        for(i=0;i<n+1;i++){
            for(j=1;j<m;j++){
                res=res+lineal[i][j];
                resul=res;
            }
            res=0;

            lineal2[i]=(h/2)*(lineal[i][0]+lineal[i][m]+2*resul);
            
        }
        for(i=1;i<n;i++){
            res2=res2+lineal2[i];
        }
        System.out.println("El volumen por trapecios es de: "+ k/2*(lineal2[0]+lineal2[n]+2*res2));
                
    }
            
  
    
  //modulo que calcula la integral segun simpson 1/3
    public static void simpson(double a, double b, int n,double c, double d,int m) {
        double[][] lineal=new double[n+1][m+1];
        double[]lineal2=new double[n+1];
        double h,k, res = 0,res2=0,resul=0,res3 = 0, sum1 = 0, sum2 = 0,sum3=0,sum4=0;
        int p=0,i,j;
        double g=a,f=c;
        k = (d - c) / n;
        h = (b - a) / m;
        
        for(i = 0; i <n+1; i++){
            for (j=0;j<m+1;j++)  { 
                
                lineal[i][j]=f5(g,f);
                System.out.print(lineal[i][j]+" ");
                g=g+h;
                
            }
            System.out.println();
            g=a;
            f=f+k;
        }
        
        for(i=0;i<n+1;i++){
            for(j=1;j<m;j++){
                if(j%2==0){
                    sum1=sum1+lineal[i][j];
                    sum3=sum1;
                    System.out.println(sum1);
                }
                else{
                    sum2=sum2+lineal[i][j];
                    sum4=sum2;
                    //System.out.println(sum4);
                }
            }
            sum1=0;
            sum2=0;
            lineal2[i]=(h / 3 * (lineal[i][0] + lineal[i][m] + 2 * sum3 + 4 * sum4));
            //System.out.println(lineal2[i]);
        }
        
        for(i=1;i<n;i++){
            if(i%2==0){
                    sum1=sum1+lineal2[i];
                    
                }
                else{
                    sum2=sum2+lineal2[i];
                    
                    
                }
        }
        
        System.out.println("El volumen por Simpson 1/3 es de: "+ ((k / 3) * (lineal2[0] + lineal2[n] + 4 * sum2 + 2 * sum1)));
        
        
        
        
    }
    
    //modulo donde se ingresa la funcion a evalura
    public static double f5(double x, double y){
        double b;
        return b=14-(x*x)-(2*y);//ingresar la funcion aqui
    
    }
    
}
