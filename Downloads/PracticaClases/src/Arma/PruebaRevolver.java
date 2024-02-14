/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
     * Programa prueba de la clase <code>Revólver</code>.
     * El programa solicitará al usuario un número de revólveres entre 1 y 10.
     * Una vez validada la entrada, se generará 1 revovler con capacidad por 
     * defecto y el resto con capacidad aleatoria dentro de los márgenes definidos
     * por la clase.
     * A continuación, el programa solicitará un número de balas a cargar para
     * el primer revovler. El resto se cargará completamente.
     * Para finalizar, se pedirá al usuario un número de disparos a realizar por
     * el primer revolver y se mostrará el resultado por pantalla.
     */
public class PruebaRevolver {
    //
    
    public static final int MIN_REVOLVER = 1;
    public static final int MAX_REVOLVER = 10;
    
    public static void main(String[] args) {
        
        //Atributos
        int numR = -1; // INICIALIZADA  A -1 PARA PODER INICIAR EL BUCLE WHILE
        int numBalas = -1;
        int numDisparos;
        Revolver[] revolver;
        Scanner sc = new Scanner(System.in);
        
        // PRIMER MENSAJE DE PROGRAMA
        System.out.println("PROGRAMA PARA CREAR REVÓLVERES, ENTRE 1 Y 10.");
        
        while(numR < MIN_REVOLVER || numR > MAX_REVOLVER){
            try{
                //PRIMER WHILE PARA VALIDAR LA ENTRADA CORRECTA MIN_REVOLVER - MAX_REVOLVER
                System.out.print("¿Cúantos revólveres desea usted crear?\nNº: ");
                numR = sc.nextInt();  
                
                }catch(InputMismatchException e){
                System.out.println("Debe ingresar un valor númerico. " + sc.next() + 
                        " no es un número");
            }
        }
        
        revolver = new Revolver[numR]; //ASIGNAMOS numR al tamaño del array.
        
        revolver[0] = new Revolver();
        System.out.println("El primer revolver ha sigo generado con una capacidad "
                + "por defecto.");
        
        // GENERAMOS EL RESTO CON CAPACIDAD ALEATORIA
        for(int i = 1; i < revolver.length ; i++){
            revolver[i] = new Revolver((int) (Math.random() * (Revolver.CAP_MAXIMA-Revolver.CAP_MINIMA+1) ) + (Revolver.CAP_MINIMA));
        }
                
//        A continuación, el programa solicitará un número de balas a cargar para
//     * el primer revovler. El resto se cargará completamente.


        //Solicitamos numero de balas
        System.out.println("Por favor, indícanos cúantas balas quieres cargar "
                            + "para ael primer revolver - Ten en cuenta que el esto se cargara"
                            + " completamente");
        while(numBalas < Revolver.CAP_MINIMA || numBalas > Revolver.CAP_MAXIMA){ 
            try{
                if(numBalas < Revolver.CAP_MINIMA || numBalas > Revolver.CAP_MAXIMA){
                    System.out.println("Recuerde que los valores minimos permitidso son " + Revolver.CAP_MINIMA
                     + " y los valores maximos permitidos son: " + Revolver.CAP_MAXIMA);
                }

                numBalas = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Debe ingresar un valor númerico. " + sc.next() + 
                        " no es un número");
            }
        }
        
        //EL RESTO SE CARGARA COMPLETAMENTE
        for(int i = 1; i < revolver.length ; i++){
            revolver[i].cargar();
        }
        
        
        System.out.println("Ahora y por ultimo, usted debera indicarnos la cantidad "
                + "de veces que desea disparar su revolver.");
        try{
            numDisparos = sc.nextInt();
        }catch(IllegalArgumentException e){
            System.out.println(sc.next() + " no es un número entero.");
        }
        
    }
}
