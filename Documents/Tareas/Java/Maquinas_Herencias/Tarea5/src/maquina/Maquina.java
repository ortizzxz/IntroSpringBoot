/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquina;

/**
 *
 * @author Jesus
 */
public abstract class Maquina {
    //Atributos protegidos de objeto
    protected String marca;
    protected String modelo;
    protected int numeroDeSerie;
    
    //Atributos públicos de clase
    public int cantidadDeMaquinasFabricadas = 0;
    
    //Crea un constructor con los parámetros marca y modelo (numeroDeSerie será igual al número total de máquinas fabricadas)
    Maquina(String marca,
            String modelo){
        this.marca = marca;
        this.modelo = modelo;
        this.numeroDeSerie = cantidadDeMaquinasFabricadas;
        cantidadDeMaquinasFabricadas++;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public int getCantidadDeMaquinasFabricadas() {
        return cantidadDeMaquinasFabricadas;
    }
    
    //Sobreescribe el método toString() para que imprima los datos de la máquina con el siguiente formato:
    //{ Marca: <texto10>; modelo: <texto10>; NS: <número4> }
    
    @Override
    public String toString() {
        return String.format("{ Marca: %10s; Modelo %10s; NS: %4d; }" ,marca,  modelo , numeroDeSerie);
    }
    
}
