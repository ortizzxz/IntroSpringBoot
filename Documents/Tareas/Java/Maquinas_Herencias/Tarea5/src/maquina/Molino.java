/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquina;

/**
 *
 * @author Jesus
 */
public final class Molino extends MaquinaMecanica{
    //atributo 
    private TipoMolino tipoDeMolino;
    
    
    public Molino(String marca, 
                  String modelo, 
                  Fuerza fuerzaMotriz) {
        super(marca, modelo, fuerzaMotriz);
    }

    public TipoMolino getTipoDeMolino() {
        return tipoDeMolino;
    }   
    
//{ Marca: <texto10>; modelo: <texto10>; NS: <número4>; Fuerza Motriz: <texto10>; Molino de: <texto18> }
    @Override
    public String toString() {
        String salida = super.toString();
        salida = salida.substring(0, (salida.length() - 1) );
        
        return salida + String.format(" Molino de: %18s }", tipoDeMolino);
    }
    
    
}

//Crea un constructor con los parámetros marca, modelo, fuerzaMotriz.
//Crea el método "get": tipoDeMolino
//Sobreescribe el método toString() para que imprima los datos de la máquina con el siguiente formato: