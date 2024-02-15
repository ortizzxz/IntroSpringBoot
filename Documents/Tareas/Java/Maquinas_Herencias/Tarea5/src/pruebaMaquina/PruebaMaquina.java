package pruebaMaquina;

import java.util.Arrays;
import maquina.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author franc
 */
public class PruebaMaquina {
    /**
     * Programa  principal de prueba de la biblioteca maquina
     * @param args La lista de argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("Probando máquina");
        
        Maquina[] listaMaquinas;
        boolean error=false;
        
        //-------------------------------------------------------
        //             Pruebas de máquinas
        //-------------------------------------------------------

        Maquina artefacto;

        //-------------------------------------------------------
        //                CABECERA DE LAS PRUEBAS
        //-------------------------------------------------------
        System.out.println();
        System.out.println("+------------------------------------------------------+");
        System.out.println("| PRUEBAS DE LA JERARQUÍA DE CLASES DEL PAQUETE maquina |");
        System.out.println("+------------------------------------------------------+");
        System.out.println();        
        
        //-------------------------------------------------------
        //           Creación de elementos 
        //-------------------------------------------------------
        // Reservamos espacio para el array de elementos que vamos a usar de prueba
        listaMaquinas = new Maquina[9];
        int maquinasGuardadasEnArray=0;
        
        System.out.println ("CREACIÓN DE MÁQUINAS");
        System.out.println ("---------------------");        
        
        System.out.println ("\nPruebas de creación de BICICLETAS:");
        System.out.println ("------------------------------------");        
        artefacto= new Bicicleta ("", "");  //Bicicleta con nombre y marca vacíos  (CORRECTO)
           mostrarMaquinaCreada (artefacto);
        artefacto= new Bicicleta (null, null); // Bicicleta con nombre y marca nulos (CORRECTO)
           mostrarMaquinaCreada(artefacto);
        artefacto= new Bicicleta ("ORBEA", "Orca"); // Bicicleta con nombre y Marca (CORRECTO)
           mostrarMaquinaCreada (artefacto);
        
        System.out.printf ("\t Guardamos artefacto tipo %s en el array.\n", artefacto.getClass().getSimpleName()); //solo el último, con marca y modelo significativos usando primer constructor
        listaMaquinas[maquinasGuardadasEnArray]= artefacto;
        maquinasGuardadasEnArray++; 
        
        
         System.out.println ("\nPruebas de creación de MOLINOS:");
         System.out.println ("---------------------------------");        
         
        artefacto= new Molino ("", "",Fuerza.ELECTRICIDAD);  //Molino Eléctrico con nombre y marca vacíos. (CORRECTO)
           mostrarMaquinaCreada (artefacto);
        artefacto= new Molino ("IBERDROLA", "Eficient",Fuerza.VIENTO); // Molino de viento con nombre y Marca.
           mostrarMaquinaCreada (artefacto);
        
        System.out.printf ("\t Guardamos artefacto tipo %s en el array.\n", artefacto.getClass().getSimpleName()); //solo el último, con marca y modelo significativos usando primer constructor
        listaMaquinas[maquinasGuardadasEnArray]= artefacto;
        maquinasGuardadasEnArray++;
        
        
        
         // Mostramos el contenido del array de máquinas
        int indice=0;
        System.out.println ("\n--------------------------------"); 
        System.out.println ("MÁQUINAS INCLUIDAS EN EL ARRAY:");
        System.out.println ("--------------------------------"); 
        for (Maquina maq: listaMaquinas) {
            System.out.printf ("MÁQUINA %d: %s\n",
                    indice++, contenidoMaquina(maq));
        }
       
    }      
    //==========================================================================       
    
    
    static void mostrarMaquinaCreada (Maquina artefacto) {
        System.out.printf ("Máquina creada %s\n", 
                contenidoMaquina (artefacto));        
    }
    
    static String contenidoMaquina (Maquina artefacto) {
        String resultado;
        if (artefacto != null) {                
            resultado= String.format ("%-15s %s",
                artefacto.getClass().getSimpleName()+":", artefacto);
        } else {
            resultado= "null";
        }
        return resultado;
    }
}

