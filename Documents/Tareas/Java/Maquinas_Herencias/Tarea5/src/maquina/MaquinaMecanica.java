/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquina;

/**
 *
 * @author Jesus
 */
public abstract class MaquinaMecanica extends Maquina{
    //Atributo protegido de objeto: fuerzaMotriz (Fuerza)
    protected Fuerza fuerzaMotriz;
    //Constante pública de clase: DEFAULT_FUERZA_MOTRIZ=Fuerza.COMBUSTIBLE
    public static final Fuerza DEFAULT_FUERZA_MOTRIZ = Fuerza.ANIMAL;
    
    // esto va? 
//    private final String marca;
//    private final String modelo;

    //Crea un constructor con los parámetros marca, modelo, fuerzaMotriz
    public MaquinaMecanica(String marca, 
                           String modelo, 
                           Fuerza fuerzaMotriz){
        super(marca, modelo);
        this.fuerzaMotriz = fuerzaMotriz;
    }
    
    //Crea otro constructor con sólo los parámetros marca y modelo. Se asignará la fuerzaMotriz por defecto.
    public MaquinaMecanica(String marca,
                           String modelo){
        super(marca, modelo);
        this.fuerzaMotriz = MaquinaMecanica.DEFAULT_FUERZA_MOTRIZ;
    }

    public Fuerza getFuerzaMotriz() {
        return fuerzaMotriz;
    }

//Sobreescribe el método toString() para que imprima los datos de la máquina con el siguiente formato:
//{ Marca: <texto10>; modelo: <texto10>; NS: <número4>; Fuerza Motriz: <texto10> } 
    @Override
    public String toString() {
        String salida = super.toString();
        salida = salida.substring(0, (salida.length() - 1));
        
        return salida + String.format(" Fuerza Motriz: %10s }", fuerzaMotriz);
    }   
}