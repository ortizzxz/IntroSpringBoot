package Arma;

public class Utilidades {
    
    /**
     * Muestra por pantalla los atributos públicos de la clase <code>Revolver</code>.
     */
    public static void consultaAtributosPublicos(){
        System.out.println("Capacidad de un tambor por defecto: " + Revolver.CAPACIDAD_DEFECTO);
        System.out.println("La capacidad máxima de un tambor es: " + Revolver.CAP_MAXIMA);
        System.out.println("La capacidad mínima de un tambor es: " + Revolver.CAP_MINIMA);
        System.out.println("Se pueden fabricr al año: " + Revolver.MAX_NUM_SERIE+
                "revolveres");
        
    }   
    
    
     /**
     * Muestra por pantalla el contenido de los atributos privados de la clase <code>Revolver</code>.
     */
    public static void consultaInformacionClase(){
        
        
    }
    
    /**
     * Muestra por pantalla el estado del objeto de la clase <code>Revolver</code>
     * @param r objteo revólver cuyo estado se desea mostrar por pantalla
     */
    public static void consultaInformacionObjeto (Revolver r){
        System.out.print(r.toString());
    }
    
    /**
     * Carga un revóler con un número de balas usando el método <code>cargar</code>
     * de la clase <code>revolver</code>>.
     * @param r objeto de la clase revolver que se va a cargar
     * @param numBalas número de balas con las que se va a cargar
     */
    public static void cargarRevolver(Revolver r, int numBalas){
        
    }
    
    /**
     * Carga un revóler completamente usando el método <code>cargar</code>
     * de la clase <code>revolver</code>>.
     * @param r objeto de la clase revolver que se va a cargar
     */
    public static void cargarRevolverCompletamente(Revolver r){
        
        
    }
    
    
    /**
     * Dispara un revólver una cantidad de veces indicada por parámetro usando
     * el método <code>disparar</code> de la clase <code>Revolver</code>.
     * @param r objeto revolver que se va a disparar
     * @param numDisparos cantidad de disparos que se desean realiar
     */
    public static void dispararRevolver(Revolver r, int numDisparos){
        
        
    }
    
    
     /**
     * Descarga un revólver usando el método <code>descargar</code> de la clase 
     * <code>Revovler</code>. Muestra por pantalla el estado antes y después de
     * descargar.
     * @param r objeto revolver que se va a descargar
     */
    public static void descargarRevolver(Revolver r){  
        
        
    }
    
}
