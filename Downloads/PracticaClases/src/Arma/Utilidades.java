package Arma;

public class Utilidades {
    
    /**
     * Muestra por pantalla los atributos públicos de la clase <code>Revolver</code>.
     */
    public static void consultaAtributosPublicos(){
        System.out.println("Atributos Públicos de Clase:");
        System.out.println("------------------------------------------------");
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
        System.out.println("Atributos Privados de la clase:");
        System.out.println("Los disparos efectivos globales son: " + Revolver.getDisparosEfectivosGlobales());
        System.out.println("Los revolveres que hay descargados son: " + Revolver.getRevovolveresDescargados());
    }
    
    /**
     * Muestra por pantalla el estado del objeto de la clase <code>Revolver</code>
     * @param r objteo revólver cuyo estado se desea mostrar por pantalla
     */
    public static void consultaInformacionObjeto (Revolver r){
        System.out.println("CONSULTA DE LA INFORMACIÓN DE UN OBJETO REVOLVER");
        System.out.println("Número de serie: " + r.getNumSerie());
        System.out.println("Capacidad del tambor: " + r.getSizeTambor());
        System.out.println("Número de balas cargadas: " + r.getCantidadBalas());
        System.out.println("Número total de disparos: " + r.getDisparosEfectivos());
        System.out.println("¿Está descargado? - " + (r.isDescargado()?"Si" : "No"));
        System.out.println("Estado actual del tambor: " + r.toString());
    }
    
    /**
     * Carga un revóler con un número de balas usando el método <code>cargar</code>
     * de la clase <code>revolver</code>>. Muestra el estado previo y posterior
     * a cargar
     * @param r objeto de la clase revolver que se va a cargar
     * @param numBalas número de balas con las que se va a cargar
     */
    public static void cargarRevolver(Revolver r, int numBalas){
        //
        System.out.println("Cargamos el revolver con " + numBalas);
        System.out.println("Estado del revolver antes de cargar: " + r.toString());
        System.out.println("Cargando...");
        r.cargar(numBalas);
        System.out.println("Cargado");
        System.out.println("La cantidad de balas cargadas ha sido: " + r.cargar(numBalas));
        System.out.println("Estado del revolver luego de cargar: " + r.toString());
    }
    
    /**
     * Carga un revóler completamente usando el método <code>cargar</code>
     * de la clase <code>revolver</code>>.
     * @param r objeto de la clase revolver que se va a cargar
     */
    public static void cargarRevolverCompletamente(Revolver r){
        r.cargar();
        
    }
    
    
    /**
     * Dispara un revólver una cantidad de veces indicada por parámetro usando
     * el método <code>disparar</code> de la clase <code>Revolver</code>.
     * @param r objeto revolver que se va a disparar
     * @param numDisparos cantidad de disparos que se desean realiar
     */
    public static void dispararRevolver(Revolver r, int numDisparos){
        for(int i=0; i < numDisparos; i++){
            r.disparar();
        }
    }
    
    
     /**
     * Descarga un revólver usando el método <code>descargar</code> de la clase 
     * <code>Revovler</code>. Muestra por pantalla el estado antes y después de
     * descargar.
     * @param r objeto revolver que se va a descargar
     */
    public static void descargarRevolver(Revolver r){  
        //antes
        System.out.print("Antes de descargar: ");
        System.out.println(r.toString());
        r.descargar();
        System.out.print("Después de descargar: ");
        System.out.println(r.toString());
    }
    
}
