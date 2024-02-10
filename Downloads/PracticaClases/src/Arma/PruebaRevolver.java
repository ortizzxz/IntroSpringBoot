/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

/**
 *
 * @author franc
 */
public class PruebaRevolver {
    //
    public static void main(String[] args) {
        Revolver r = new Revolver();
        //
        
        r.descargar();
        System.out.println(r.toString());
        
        //
        r.cargar(3);
        System.out.println(r.toString());
        r.disparar();
        System.out.println(r.toString());
    }
}
