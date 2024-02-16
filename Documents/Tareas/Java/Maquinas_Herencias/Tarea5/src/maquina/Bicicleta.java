/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquina;

/**
 *
 * @author Jesus
 */
public final class Bicicleta extends MaquinaMecanica{
    //Atributos privados
    private double radioRueda; //se mide en cms 
    private double totalKilometros;
    
    // constantes de clase 
    private static final double DEFAULT_RADIO_RUEDA  = 33.0; // (valor por defecto para el radio)
    private static final double MIN_RADIO_RUEDA = 17.75; // (valor mínimo para el radio)
    private static final double MAX_RADIO_RUEDA = 36.85; //(valor máximo para el radio)
    private static final double MAX_DESPLAZAMIENTO = 200.0; //(número máximo de kilómetros 
                                                             //que se puede desplazar una bicicleta sin hacer paradas

//Crea un constructor con todos los parámetros: marca, modelo, radioRueda (Se establede Fuerza.Animal con valor necesesario)
    public Bicicleta(String marca, 
                     String modelo,
                     double radioRueda){
        
        super(marca, modelo, Fuerza.ANIMAL);
        this.radioRueda = radioRueda;
    }
    
    public Bicicleta(String marca, 
                     String modelo){
        
        super(marca, modelo);
    }

    public double getRadioRueda() {
        return radioRueda;
    }

    public double getTotalKilometros() {
        return totalKilometros;
    }

    @Override
    public String toString() {
        String salida = super.toString();
        salida = salida.substring(0, (salida.length() - 1) );
        
        return salida + String.format("Radio: %4.2f; Kilómetros: %4.2f", radioRueda, totalKilometros);
    }   
}