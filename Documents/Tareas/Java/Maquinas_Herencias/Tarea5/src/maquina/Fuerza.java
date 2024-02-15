/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquina;

/**
 * Tipo enumerado, que representa las diferentes fuentes de energía que puede usar una máquina mecánica.
 * Puede tomar los valores: ANIMAL, ELECTRICIDAD, COMBUSTIBLE, VIENTO, CORRIENTE_AGUA
 * 
 * @author franc
 */   
public enum Fuerza {   
 
    /**
     * Fuerza ejercida por cualquier ser vivo (un animal, una persona)
     */
    ANIMAL, 

    /**
     * Fuerza ejercida mediante el uso de energía eléctrica.
     */
    ELECTRICIDAD, 

    /**
     * Fuerza ejercida mediante el consumo de un determinado combustible, como puede ser gasolina, diésel, ...
     */
    COMBUSTIBLE, 

    /**
     * Fuerza ejercida por el viento.
     */
    VIENTO, 

    /**
     * Fuerza ejercida por una corriente de agua.
     */
    CORRIENTE_AGUA 
}