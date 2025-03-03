package tarea06;

// ------------------------------------------------------------
//                   Clase Embarcacion
// ------------------------------------------------------------
/**
 *
 * @author José Bueno Cruz
 */
public abstract class Embarcacion implements Navegable {

    // ------------------------------------------------------------------------
    // Atributos estáticos públicos (inmutables)
    // Pueden ser accedidos desde fuera de la clase
    // ------------------------------------------------------------------------
    public static final String PATRON_POR_DEFECTO = "Sin patrón";
    public static final String RUMBO_POR_DEFECTO = "Sin rumbo";
    public static final int MIN_TRIPULANTES = 0; 
    
    // ------------------------------------------------------------------------
    // Atributos estáticos privados (mutables)
    // No dependen de instancias de objetos particulares y sólo pueden 
    // modificarse desde la propia clase
    // ------------------------------------------------------------------------
    private static int numDeBarcosFlota;
    private static int numBarcosNavegandoFlota;
    private static float tiempoDeNavegacionFlota;
    
    // ------------------------------------------------------------------------
    // Atributos de objeto inmutables (privados)
    // Representan el estado del objeto pero no pueden cambiar su valor
    // ------------------------------------------------------------------------
    private final String nombreBarco;
    private final int numMaxTripulantesBarco;
    
    // ------------------------------------------------------------------------
    // Atributos de objeto variables (privados)
    // Representan el estado del objeto y pueden cambiar su valor
    // ------------------------------------------------------------------------
    
    // ------------------------------------------------------------------------
    // Atributos del estado del barco
    // ------------------------------------------------------------------------
    // Representan el estado básico del barco en un momento dado
    // ------------------------------------------------------------------------
    protected boolean estaNavegandoBarco;
    
    // ------------------------------------------------------------------------
    // Atributos de la información de navegación
    // ------------------------------------------------------------------------
    // Almacenan información sobre los parámetros de navegación
    // ------------------------------------------------------------------------
    protected int velocidadBarco;
    protected String nombreDelPatronBarco;
    protected String rumboBarco;
    protected int numDeTripulantesBarco;
    protected int tiempoTotalDeNavegacionBarco;
    // ------------------------------------------------------------------------
    // Constructores de la clase
    // ------------------------------------------------------------------------
    public Embarcacion(String nombre, int numMaxTripulantes) {

        if (nombre == null) {
            throw new NullPointerException("El nombre de la embarcación no puede ser nulo.");
        }
  
        if (nombre.isEmpty()) {
            throw  new IllegalArgumentException("El nombre de la embarcación no puede estar vacío.");
        }

        if (numMaxTripulantes > Embarcacion.MIN_TRIPULANTES) {
            throw new IllegalArgumentException(String.format("El número de tripulantes debe ser, como mínimo, %d.", Embarcacion.MIN_TRIPULANTES));
        }

        this.nombreBarco = nombre;
        this.numMaxTripulantesBarco = numMaxTripulantes;
        this.nombreDelPatronBarco = Embarcacion.PATRON_POR_DEFECTO;
        this.rumboBarco = Embarcacion.RUMBO_POR_DEFECTO;
        Embarcacion.numBarcosNavegandoFlota++;
        
    }
    // ------------------------------------------------------------------------
    // Getters (consultan el estado del objeto)
    // ------------------------------------------------------------------------

    /**
     * @return the nombreBarco
     */
    public String getNombreBarco() {
        return nombreBarco;
    }

    /**
     * @return the numMaxTripulantesBarco
     */
    public int getMaxTripulantes() {
        return numMaxTripulantesBarco;
    }

    /**
     * @return the estaNavegandoBarco
     */
    public boolean isNavegando() {
        return estaNavegandoBarco;
    }

    /**
     * @return the velocidadBarco
     */
    public int getVelocidad() {
        return velocidadBarco;
    }

    /**
     * @return the nombreDelPatronBarco
     */
    public String getPatron() {
        return nombreDelPatronBarco;
    }

    /**
     * @return the rumboBarco
     */
    public String getRumbo() {
        return rumboBarco;
    }

    /**
     * @return the numDeTripulantesBarco
     */
    public int getTripulacion() {
        return numDeTripulantesBarco;
    }

    /**
     * @return the tiempoTotalDeNavegacionBarco
     */
    public int getTiempoTotalDeNavegacionBarco() {
        return tiempoTotalDeNavegacionBarco;
    } 
    
    // ------------------------------------------------------------------------
    // Métodos estáticos (acceden a los atributos estáticos de la clase)
    // ------------------------------------------------------------------------
    
    /**
     * @return the numDeBarcosFlota
     */
    public static int getNumBarcos() {
        return numDeBarcosFlota;
    }

    /**
     * @return the numBarcosNavegandoFlota
     */
    public static int getNumBarcosNavegando() {
        return numBarcosNavegandoFlota;
    }

    /**
     * @return the tiempoDeNavegacionFlota
     */
    public static float getTiempoTotalNavegacion() {
        return tiempoDeNavegacionFlota;
    }
    // ------------------------------------------------------------------------
    // Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------

    /**
     * @param nuevoRumbo the rumboBarco to set
     */
    public void setRumbo(String nuevoRumbo) {

        if (!this.estaNavegandoBarco) {
            throw new IllegalStateException(String.format("La embarcación %s no está navegando, no se puede cambiar el rumbo.", this.nombreBarco));   
        }

        if (nuevoRumbo.equalsIgnoreCase(this.rumboBarco)) {
            throw new IllegalStateException(String.format("La embarcación %s ya está navegando con ese rumbo (%s), debes indicar un rumbo distinto para poder modificarlo.", this.nombreBarco, this.rumboBarco));
        }
        
        this.rumboBarco = nuevoRumbo;
        
    }
    
    @Override
    public void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes) {
        
        if (!this.estaNavegandoBarco) {
            throw new IllegalStateException(String.format("La embarcación %s ya está navegando y se encuentra fuera de puerto.", this.nombreBarco));
        }
        
        if (rumbo == null) {
            throw  new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo para iniciar la navegación.");
        }
        
        if (rumbo.isEmpty()) {
            throw  new IllegalArgumentException("El rumbo no puede estar vacío, debes indicar el rumbo para iniciar la navegación.");
        }
        
        if (patron == null) {
            throw  new NullPointerException("El patrón de la embarcación no puede ser nulo, se necesita un patrón para iniciar la navegación.");
        }
        
        if (patron.isEmpty()) {
            throw  new IllegalArgumentException("El patrón de la embarcación no puede estar vacío, se necesita un patrón para iniciar la navegación.");
        }
        
        if (numTripulantes < Embarcacion.MIN_TRIPULANTES) {
            throw  new IllegalArgumentException(String.format("El número de tripulantes debe estar entre %d y %d.", Embarcacion.MIN_TRIPULANTES, this.numMaxTripulantesBarco));
        }
        
        this.estaNavegandoBarco = true;
    }
    
    @Override
    public void pararNavegacion(int tiempoNavegacion) {
        
        if (!this.estaNavegandoBarco) {
            throw new  IllegalStateException(String.format("La embarcación %s no está navegando.", this.nombreBarco));
        }
        
        if (tiempoNavegacion < 0) {
            throw new  IllegalArgumentException("Tiempo navegando incorrecto, debe ser mayor que cero.");
        }
        
        this.estaNavegandoBarco = false;
    }
    
    
    // ------------------------------------------------------------------------
    // Método Abstracto (sin implementación)
    // ------------------------------------------------------------------------
    
    public abstract void señalizar();
    
    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public String toString(){
        return String.format("Nombre de la embarcación: %s, Tripulación: %s, Navegando: %s, Tiempo total de navegación de la embarcación: %1.2f horas ", 
                this.nombreBarco, this.numDeTripulantesBarco,
                !this.estaNavegandoBarco ? "No" : String.format("Si, con el patrón %s en %s a %s nudos.", 
                        this.nombreDelPatronBarco, this.rumboBarco, this.velocidadBarco),
                this.tiempoTotalDeNavegacionBarco / 60.0);
    }
     
}
