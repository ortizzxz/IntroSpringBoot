
package Arma;

// ------------------------------------------------------------

import java.time.LocalDate;

//                   Clase Revolver
// ------------------------------------------------------------
/**
 * Clase que representa un revolver 
 * Los objetos de esta clase permiten almacenar y gestionar información
 * sobre: 
 * Número de serie del revolver. Este valor se establecerá
 * al crear el objeto revolver y ya no podrá cambiar. Es un valor
 * constante. 
 * Tambor del revolver: balas y casquillos que contiene en
 * cada momento el tambor del revolver, así como su disposición en el tambor y
 * qué orificio del tambor está en cada momento ante el percutor para recibir el
 * impacto al apretar el gatillo del arma. 
 * Disparos efectivos realizados por el revolver a lo largo
 * de su historia. 
 * 
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de: 
 * Número de disparos totales realizados por todos los
 * revólveres hasta el momento actual. 
 * Número de revólveres descargados en el momento
 * actual. 
 *  
 * @author franc
 */

public class Revolver {
    // ------------------------------------------------------------
    //                 ATRIBUTOS ESTÁTICOS (de clase)
    // ------------------------------------------------------------
    // Atributos estáticos constantes públicos
    // (rangos y requisitos de los atributos de objeto)
    // Son públicos, disponibles para que cualquier código cliente pueda acceder a ellos
    // --------------------------------------------------------------------------------

    /**
     * Numero entero que indica la capacidad minima del tambor del revolver
     * a la hora de crear un nuevo revoler 
     * {@value CAP_MINIMA}
     */
    
    public static final int CAP_MINIMA = 5;

    /**
     * Numero entero que indica la capacidad minima del tambor del revolver a la hora
     * de crear un nuevo revolver
     * {@value CAP_MAXIMA}
     */
    public static final int CAP_MAXIMA = 10;
    
    /**
     * Numero entero que indica la capacidad por defecto de un tambor de un 
     * nuevo revolver
     * @value CAPACIDAD_DEFECTO
     */
    public static final int CAPACIDAD_DEFECTO = 6;
    
    /**
     * Numero que indica la cantidad de numeros de series que se pueden crear 
     * por año 
     * @value MAX_NUM_SERIE
     */ 
    public static final int MAX_NUM_SERIE = 99;

    
    // Atributos estáticos variables (privados).
    // Representan "estado" de la clase en general. No de objetos en particular
    // ------------------------------------------------------------------------
    
    private static int disparoshechos = 0; // Total de disparos hechos por todos los R
    private static int revolveresDescargados = 0; // Total de R descargados
    private static int siguienteNumSerie = 0; // Numero de serie para el siguiente R
    private static int añoActual = LocalDate.now().getYear(); // Año actual cuando se inicie la clase
    
    // ------------------------------------------------------------
    //               ATRIBUTOS DE OBJETO (todos privados)
    // ------------------------------------------------------------
    // Atributos de objeto constantes durante la vida del objeto (desde que se crea objeto)
    // No hace falta declararlas como variables pues no van a cambiar una vez creado el objeto.
    // Representan "características inmutables" o "de naturaleza" del objeto.
    // (usamos notación "camelCase" aunque sean final, pues son "internos" y no los "ve" nadie más)
    // ------------------------------------------------------------------------
    
    private final String numSerie; // Numero de serie xxx-zz (xxx Año y zz = 00 - 99)
    private final Estado[] tambor; //Array que representa el tambor del R

    // Atributos de objeto variables
    // Representan el "estado" del objeto en un instante dado.
    // ------------------------------------------------------------------------
    private int posicion;
    private int disparos; //numero disparos efectivos realizados de este revolver
    

    
    
    // ------------------------------------------------------------
    //                        CONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Constructor basado en la capacidad del tambor. Crea un nuevo objeto
     * <code>Revolver</code> con el tamaño de tambor indicado en el parámetro.
     *
     * @param capacidad capacidad del tambor (número de orificios)
     * 
     */
    public Revolver(int capacidad) throws IllegalArgumentException, IllegalStateException{
        int currentYear = LocalDate.now().getYear();
        
       if (capacidad > Revolver.CAP_MAXIMA || capacidad < Revolver.CAP_MINIMA){
           throw new IllegalArgumentException("Capacidad " + capacidad + " no válida. Por favor use valores"
                   + " válidos. Capacidad máxima: " + Revolver.CAP_MAXIMA + ", capacidad "
                           + "mínima: " + Revolver.CAP_MINIMA);
       }
       
       if(siguienteNumSerie > MAX_NUM_SERIE && currentYear == añoActual){
           throw new IllegalStateException("Se ha alcanzado el máximo de "
                   + "revolveres fabricados este año. " + currentYear + ":" + MAX_NUM_SERIE);
       }
       
       //else
       tambor = new Estado[capacidad];
       posicion = 0;
       
       for(int i = 0; i < tambor.length; i++){
           tambor[i] = Estado.VACIO;
       }
       
       // ACTUALIZAMOS EL AÑO
       if(currentYear > añoActual){
           siguienteNumSerie = 0;
           añoActual = currentYear;
       }
       
       //Formato del string 
       numSerie = String.format("%4d-%2d", currentYear, siguienteNumSerie);
       
       //Actualizar los atributos de clase
       siguienteNumSerie++;
       revolveresDescargados++;
    }
    
    
    /**
     * Constructor copia. Crea un nuevo objeto <code>Revolver</code> con las
     * mismas características que el que se ha pasado como parámetro. El nuevo
     * objeto tendrá el tambor vacío y un nuevo número de serie.
     * @param r objeto que se va a usar para realizar la copia
     * 
     */
    public Revolver(Revolver r) throws IllegalStateException{
        this(r.tambor.length);
    }
    
    
    /**
     * Constructor sin parámetros. Crea un nuevo objeto <code>Revolver</code>
     * con el tamaño de tambor por omisión. El tamaño por omisión para el tambor
     * es de {@value DEFAULT_CAPACIDAD} balas.
     *
     */
    public Revolver() throws IllegalStateException{
        this(CAPACIDAD_DEFECTO);
    }
    
    
    // ------------------------------------------------------------
    //          MÉTODOS "FÁBRICA" O PSEUDOCONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Método "fábrica" creador de un revolver ya cargado. Crea un nuevo objeto
     * <code>Revolver</code> con el tamaño de tambor indicado en el parámetro y
     * cargado de balas.
     *
     * @param capacidad capacidad del tambor
     * @return revólver con tambor del tamaño indicado y cargado
     */
    public static Revolver crearRevolverCargado(int capacidad){
        //creamos el revolver 
        Revolver r = new Revolver(capacidad);
        //CARGAMOS EL REVOLVER 
        r.cargar();
        //RETURN
        return r;
    }
    
    /**
     * Método "fábrica" creador de un revolver ya cargado con el tamaño del
     * tambor por omisión. Crea un nuevo objeto <code>Revolver</code> con el
     * tamaño de tambor por omisión y cargado de balas. El tamaño por omisión
     * para el tambor es de {@value DEFAULT_CAPACIDAD} balas.
     *
     * @return revólver con tambor del tamaño por omisión y cargado
     */
    public static Revolver crearRevolverCargado(){
        //Creando el revolver vacio usando el metodo Revolver()
        Revolver r = new Revolver();
        //RETURN
        return r;
    }
    
    
    
    // ------------------------------------------------------------
    //                 Getters:  Métodos GET
    // ------------------------------------------------------------
    /**
     * Obtiene el número de serie del revólver.
     *
     * @return número de serie del revólver
     */
    public String getNumSerie(){
        return this.numSerie;
    }
    
    
    /**
     * Obtiene la capacidad del tambor del revólver.
     *
     * @return capacidad del tambor del revólver
     */
    public int getSizeTambor(){
        return this.tambor.length;
    }
    
    
    /**
     * Obtiene la cantidad de balas que contiene actualmente el tambor del
     * revólver. Los casquillos no cuentan.
     *
     * @return cantidad de balas que contiene en ese momento el tambor del
     * revólver
     */
    public int getCantidadBalas(){
        int n = 0;
        
        for(int i = 0; i < this.tambor.length; i++){
           if (this.tambor[i] == Estado.BALA){
               n++;
           }
       }
        
        return n;
    }
    
    
    /**
     * Indica si el revólver se encuentra totalmente descargado.
     *
     * @return si el revolver no contiene ninguna bala
     */
    public boolean getDescargado(){
        
        boolean descargado = true;
        
        for(int i = 0; i < this.tambor.length; i++){
           if (this.tambor[i] == Estado.BALA){
               descargado = false;
           }
        }
        
        return descargado;
    }
    
    
    /**
     * Devuelve la cantidad de disparos efectivos realizados por el revolver
     * desde que se creó.
     *
     * @return cantidad de disparos efectivos realizados por el revolver desde
     * que se creó
     */
    public int getDisparosEfectivos(){
        // 
        int d = 0;
        //
        for(int i = 0; i < this.tambor.length; i++){
           if (this.tambor[i] == Estado.CASQUILLO){
               d++;
           }
        }
        //
        return d;
    }
    
    
    /**
     * Devuelve la cantidad de disparos efectivos realizados por todos los
     * revólveres hasta el momento.
     *
     * @return cantidad de disparos efectivos realizados por todos los
     * revólveres hasta el momento
     */
    public int getDisparosEfectivosGlobales(){
        return Revolver.disparoshechos;
    }
    
    
    /**
     * Devuelve la cantidad de revólveres descargados que hay en el momento
     * actual.
     *
     * @return cantidad de revólveres descargados que hay en el momento actual
     */
    public int getRevovolveresDescargados(){
        return Revolver.revolveresDescargados;
    }
    
    // ------------------------------------------------------------
    //          MÉTODOS "SET"  (opcionales)
    // ------------------------------------------------------------
    
    
    
    // ------------------------------------------------------------
    //                 Métodos de "ACCIÓN"
    // ------------------------------------------------------------
    /**
     * Carga el revólver con una determinada cantidad de balas. Se va
     * recorriendo el tambor desde su posición 0 y se van introduciendo
     * proyectiles en los orificios que aún no tengan bala (tanto si hay hueco
     * como si hay casquillo). Si en algún orificio ya hay una bala aún sin
     * utilizar, se pasa al siguiente orificio. Si sobran balas, simplemente no
     * se tienen en cuenta. Se devolverá el número de balas que efectivamente se
     * han introducido en el tambor.
     *
     * @param numBalas Número de balas con las que se quiere cargar el revólver
     * @return cantidad de balas que se han podido introducir efectivamente en
     * el tambor
     * @throws IllegalArgumentException si el número de balas es negativo
     */
    public int cargar(int numBalas){
        //VARIABLE TIPO INT QUE LLEVA CONTROL DE LA CANTIDAD DE BALAS
        //QUE SE HAN PODIDO INTRODUCIR PARTIENDO DE numBalas
        int b = 0;
        
        //ILLEGAL ARGUMENT ERROR
        if(numBalas >= 0){
            throw new IllegalArgumentException("Tiene que introducir al menos una bala.");
        }
        //
        for (int i = 0; i < this.tambor.length; i++){
            if(this.tambor[i] == Estado.VACIO || this.tambor[i] == Estado.CASQUILLO){
                this.tambor[i] = Estado.BALA;
                b++;
            }
        }
        //RETURN
        return b;
    }
    /**
     * Carga el tambor del revólver completamente. Se va recorriendo el tambor
     * desde su posición 0 y se van introduciendo proyectiles en los orificios
     * que aún no tengan bala (tanto si hay hueco como si hay casquillo). Si en
     * algún orificio ya hay una bala aún sin utilizar, se pasa al siguiente
     * orificio. Se devolverá el número de balas que efectivamente se han
     * introducido en el tambor.
     *
     * @return cantidad de balas que se han podido introducir efectivamente en
     * el tambor
     */
    public int cargar(){
        int b = 0;
        
        for (int i = 0; i < this.tambor.length; i++){
            if(this.tambor[i] == Estado.VACIO || this.tambor[i] == Estado.CASQUILLO){
                this.tambor[i] = Estado.BALA;
                b++;
            }
        }
        
        return b;
    }
    
    
    /**
     * Descarga el tambor del revólver completamente. Se vacía completamente el
     * tambor del revólver, tanto de casquillos como de proyectiles sin
     * utilizar.
     *
     * @return cantidad de balas (no casquillos) que había en el tambor
     */
    public int descargar(){
        int v = 0;
        
        for (int i = 0; i < this.tambor.length; i++){
            if(this.tambor[i] == Estado.CASQUILLO || this.tambor[i] == Estado.BALA){
                this.tambor[i] = Estado.VACIO;
                v++;
            }
        }
        
        return v;
    }
    
    
    /**
     * Se dispara el revólver pulsando el gatillo. Si el orificio del tambor que
     * había en ese momento ante el percutor contenía un proyectil completo, se
     * producirá un disparo efectivo. Si el orificio estaba vacío o contenía un
     * casquillo, no se producirá un disparo efectivo. En cuaqluier caso el
     * tambor girará de izquierda a derecha una posición y se colocará el
     * siguiente orificio ante el percutor.
     *
     * @return si el disparo ha sido o no efectivo
     */
    public boolean disparar(){
        boolean disparo = false;
        
        
        
        if( this.tambor[posicion] == Estado.BALA ){
            disparo = true;
        }
        
        //ACTUALIZAMOS LA POSICION 
        if(this.posicion < this.tambor.length){
            this.posicion++;
        }else{
            this.posicion = 0;
        }
        //
        return disparo;
    }
    
    
    /**
     * Devuelve una cadena que representa el estado de un revolver. El resultado
     * devuelto representará el contenido del tambor y tendrá la siguiente
     * estructura:
     * <ol>
     * <li>un inicio de bloque o llave (carácter '{');</li>
     * <li>un carácter de tipo '_', 'X' o 'x' por cada orificio del tambor:
     * <ul>
     * <li>si el orificio está vacío aparecerá el carácter '_' (guion bajo o
     * "subrayado");</li>
     * <li>si el orificio contiene una bala completa (no disparada), aparecerá
     * el carácter 'X' (equis mayúscula);</li>
     * <li>si el orificio contiene un casquillo (bala disparada), aparecerá el
     * carácter 'x' (equis minúscula);</li>
     * </ul></li>
     * <li>un fin de bloque o llave (carácter '}').</li>
     * </ol>
     * <p>
     * Además, el orificio que se encuentre en ese momento delante del percutor
     * deberá aparecerá encerrado entre corchetes (caracteres '[' y ']'). Así
     * quedará claro el orificio sobre el que va a impactar el percutor la
     * próxima vez que se apriete el gatillo al disparar.</p>
     * <p>
     * Aquí tienes un posible ejemplo de salida:
     *  <code>{ x [X] X  X  _  _  _  _ }</code>, donde observamos que: </p>
     * <ul>
     * <li>se trata de un revólver con un tambor de capacidad para ocho
     * proyectiles;</li>
     * <li>en el primer orificio hay un casquillo;</li>
     * <li>en los orificios segundo, tercero y cuarto hay balas que aún no han
     * sido disparadas;</li>
     * <li>los orificios del quinto al octavo se encuentran aún vacíos;</li>
     * <li>el percutor se encuentra sobre el segundo orificio.</li>
     * </ul>
     *
     *
     * @return una cadena que representa el estado del tambor del revolver
     */
    @Override
    public String toString(){
        String mensaje = "{}";
        
        for (int i = 0; i <= this.tambor.length; i++){
            //AGREGAMOS VALORES AL STRING 
            if(this.tambor[i] == Estado.VACIO){
                mensaje += "_";
            }
            if(this.tambor[i] == Estado.BALA){
                mensaje += "X";
            }
            if(this.tambor[i] == Estado.CASQUILLO){
                mensaje += "x";
            }
            if(i == this.posicion){
                mensaje = "[" + mensaje;
                mensaje += "]";
            }
        }
            
        return mensaje;
    }
    
    // ------------------------------------------------------------
    //                    MÉTODOS PRIVADOS
    // ------------------------------------------------------------
    /**
     * Este es el método que realmente genera la cadena de estado del tambor.
     *
     * @return cadena con el estado del tambor
     */
    private String estadoTambor() {
        String estado = this.tambor.toString();
        
        return estado;
    }
    
    /**
     * Enum privado con los distintos estados de un orificio del tambor.
     */
    private enum Estado {
        /**
         * Vacio
         */
        VACIO,
        /**
         * Bala
         */
        BALA,
        /**
         * Casquillo
         */
        CASQUILLO;
    }    
    
}
