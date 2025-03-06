package tarea06;

// ------------------------------------------------------------
//                   Clase Embarcacion
// ------------------------------------------------------------
/**
 * Representa una <strong>Embarcación</strong>, que puede ser navegable y
 * gestionar su navegación. Esta clase implementa la interfaz {@link Navegable},
 * lo que le permite gestionar su navegación mediante los métodos
 * {@link #iniciarNavegacion(int, String, String, int)} y
 * {@link #pararNavegacion(int)}. Además, define atributos y métodos comunes
 * para todas las embarcaciones, como su nombre, tripulación, patrón, rumbo y
 * velocidad.
 *
 * La clase es abstracta, por lo que no se puede instanciar directamente, pero
 * proporciona los métodos y atributos necesarios para las clases derivadas que
 * gestionen tipos específicos de embarcaciones.
 *
 * @author José Bueno Cruz
 */
public abstract class Embarcacion implements Navegable {

// ------------------------------------------------------------------------
// Atributos estáticos públicos (inmutables)
// ------------------------------------------------------------------------
    /**
     * Nombre por defecto para el patrón de la embarcación: "Sin patrón".
     */
    public static final String PATRON_POR_DEFECTO = "Sin patrón";

    /**
     * Rumbo por defecto para la embarcación: "Sin rumbo".
     */
    public static final String RUMBO_POR_DEFECTO = "Sin rumbo";

    /**
     * Número mínimo de tripulantes: 0.
     */
    public static final int MIN_TRIPULANTES = 0;

// ------------------------------------------------------------------------
// Atributos estáticos privados (mutables)
// ------------------------------------------------------------------------
    /**
     * Número total de embarcaciones creadas.
     */
    private static int numBarcos;

    /**
     * Número de embarcaciones actualmente navegando.
     */
    private static int numBarcosNavegando;

    /**
     * Tiempo total de navegación de todas las embarcaciones.
     */
    private static float tiempoDeNavegacion;

// ------------------------------------------------------------------------
// Atributos de objeto inmutables (privados)
// ------------------------------------------------------------------------
    /**
     * Nombre de la embarcación.
     */
    private final String nombreBarco;

    /**
     * Número máximo de tripulantes que puede tener la embarcación.
     */
    private final int numMaxTripulantesBarco;

// ------------------------------------------------------------------------
// Atributos de objeto variables (protected)
// ------------------------------------------------------------------------
    /**
     * Indica si la embarcación está navegando o no.
     */
    protected boolean estaNavegandoBarco;

    /**
     * Velocidad actual de la embarcación en nudos.
     */
    protected int velocidadBarco;

    /**
     * Nombre del patrón de la embarcación.
     */
    protected String nombreDelPatronBarco;

    /**
     * Rumbo actual de la embarcación.
     */
    protected String rumboBarco;

    /**
     * Número de tripulantes actuales de la embarcación.
     */
    protected int numDeTripulantesBarco;

    /**
     * Tiempo total de navegación de la embarcación en minutos.
     */
    protected int tiempoTotalDeNavegacionBarco;

// ------------------------------------------------------------------------
// Constructores de la clase
// ------------------------------------------------------------------------
    /**
     * Constructor de la clase Embarcacion, que inicializa los atributos de la
     * embarcación, validando que el nombre no sea nulo ni vacío, y que el
     * número máximo de tripulantes sea válido.
     *
     * @param nombre El nombre de la embarcación.
     * @param numMaxTripulantes El número máximo de tripulantes de la
     * embarcación.
     * @throws IllegalArgumentException Si el nombre está vacío o el número de
     * tripulantes es menor que el mínimo.
     * @throws NullPointerException Si el nombre es nulo.
     */
    public Embarcacion(String nombre, int numMaxTripulantes) throws IllegalArgumentException, NullPointerException {
        if (nombre == null) {
            throw new NullPointerException("El nombre de la embarcación no puede ser nulo.\n");
        }

        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la embarcación no puede estar vacío.\n");
        }

        if (numMaxTripulantes < Embarcacion.MIN_TRIPULANTES) {
            throw new IllegalArgumentException(String.format("El número de tripulantes debe ser, como mínimo, %d.\n", Embarcacion.MIN_TRIPULANTES));
        }

        this.nombreBarco = nombre;
        this.numMaxTripulantesBarco = numMaxTripulantes;
        this.nombreDelPatronBarco = Embarcacion.PATRON_POR_DEFECTO;
        this.rumboBarco = Embarcacion.RUMBO_POR_DEFECTO;
        Embarcacion.numBarcos++;
    }

// ------------------------------------------------------------------------
// Getters de objeto
// ------------------------------------------------------------------------
    /**
     * @return El nombre de la embarcación.
     */
    public String getNombreBarco() {
        return nombreBarco;
    }

    /**
     * @return El número máximo de tripulantes que puede tener la embarcación.
     */
    public int getMaxTripulantes() {
        return numMaxTripulantesBarco;
    }

    /**
     * @return Si la embarcación está navegando o no.
     */
    public boolean isNavegando() {
        return estaNavegandoBarco;
    }

    /**
     * @return La velocidad actual de la embarcación en nudos.
     */
    public int getVelocidad() {
        return velocidadBarco;
    }

    /**
     * @return El nombre del patrón de la embarcación.
     */
    public String getPatron() {
        return nombreDelPatronBarco;
    }

    /**
     * @return El rumbo actual de la embarcación.
     */
    public String getRumbo() {
        return rumboBarco;
    }

    /**
     * @return El número de tripulantes de la embarcación.
     */
    public int getTripulacion() {
        return numDeTripulantesBarco;
    }

    /**
     * @return El tiempo total de navegación de la embarcación en minutos.
     */
    public int getTiempoTotalNavegacionBarco() {
        return tiempoTotalDeNavegacionBarco;
    }

// ------------------------------------------------------------------------
// Métodos estáticos (acceden a los atributos estáticos de la clase)
// ------------------------------------------------------------------------
    /**
     * @return El número total de embarcaciones creadas.
     */
    public static int getNumBarcos() {
        return numBarcos;
    }

    /**
     * @return El número de embarcaciones actualmente navegando.
     */
    public static int getNumBarcosNavegando() {
        return numBarcosNavegando;
    }

    /**
     * @return El tiempo total de navegación acumulado por todas las
     * embarcaciones.
     */
    public static float getTiempoTotalNavegacion() {
        return tiempoDeNavegacion;
    }

// ------------------------------------------------------------------------
// Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
// ------------------------------------------------------------------------
    /**
     * Cambia el rumbo de la embarcación si está navegando, lanzando una
     * excepción si no lo está o si el rumbo es el mismo.
     *
     * @param nuevoRumbo El nuevo rumbo que desea establecer.
     * @throws IllegalStateException Si la embarcación no está navegando.
     */
    public void setRumbo(String nuevoRumbo) throws IllegalStateException {
        if (!this.estaNavegandoBarco) {
            throw new IllegalStateException(String.format("La embarcación %s no está navegando, no se puede cambiar el rumbo.\n", this.nombreBarco));
        }

        if (nuevoRumbo.equalsIgnoreCase(this.rumboBarco)) {
            throw new IllegalStateException(String.format("La embarcación %s ya está navegando con ese rumbo (%s), debes indicar un rumbo distinto para poder modificarlo.\n", this.nombreBarco, this.rumboBarco));
        }

        this.rumboBarco = nuevoRumbo;
    }

    /**
     * Inicia la navegación de la embarcación estableciendo la velocidad, rumbo,
     * patrón y número de tripulantes. Lanza excepciones si los parámetros son
     * inválidos.
     *
     * @param velocidad La velocidad de la embarcación en nudos.
     * @param rumbo El rumbo de la embarcación.
     * @param patron El nombre del patrón de la embarcación.
     * @param numTripulantes El número de tripulantes.
     * @throws IllegalStateException Si la embarcación ya está navegando.
     * @throws IllegalArgumentException Si el número de tripulantes es inferior
     * al permitido.
     * @throws NullPointerException Si el rumbo o patrón son invalidos o están
     * vacios.
     */
    @Override
    public void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        if (this.estaNavegandoBarco) {
            throw new IllegalStateException(String.format("La embarcación %s ya está navegando y se encuentra fuera de puerto.\n", this.nombreBarco));
        }

        if (rumbo == null || rumbo.isEmpty()) {
            throw new NullPointerException("El rumbo no puede ser nulo o vacío.\n");
        }

        if (patron == null || patron.isEmpty()) {
            throw new NullPointerException("El patrón no puede ser nulo o vacío.\n");
        }

        if (numTripulantes < Embarcacion.MIN_TRIPULANTES) {
            throw new IllegalArgumentException(String.format("El número de tripulantes debe ser al menos %d.\n", Embarcacion.MIN_TRIPULANTES));
        }

        this.estaNavegandoBarco = true;
        this.velocidadBarco = velocidad;
        this.rumboBarco = rumbo;
        this.nombreDelPatronBarco = patron;
        this.numDeTripulantesBarco = numTripulantes;
        Embarcacion.numBarcosNavegando++;
    }

    /**
     * Detiene la navegación de la embarcación, actualizando el tiempo total de
     * navegación.
     *
     * @param tiempoNavegacion El tiempo en minutos que la embarcación estuvo
     * navegando.
     * @throws IllegalStateException Si la embarcación no está navegando.
     * @throws IllegalArgumentException Si el tiempo de navegación es negativo.
     */
    @Override
    public void pararNavegacion(int tiempoNavegacion) throws IllegalStateException, IllegalArgumentException {
        if (!this.estaNavegandoBarco) {
            throw new IllegalStateException(String.format("La embarcación %s no está navegando.\n", this.nombreBarco));
        }

        if (tiempoNavegacion < 0) {
            throw new IllegalArgumentException("Tiempo de navegación incorrecto. Debe ser mayor que cero.\n");
        }

        this.estaNavegandoBarco = false;
        this.velocidadBarco = 0;
        this.rumboBarco = Embarcacion.RUMBO_POR_DEFECTO;
        this.nombreDelPatronBarco = Embarcacion.PATRON_POR_DEFECTO;
        this.numDeTripulantesBarco = 0;
        this.tiempoTotalDeNavegacionBarco += tiempoNavegacion;
        Embarcacion.tiempoDeNavegacion += tiempoNavegacion;
        Embarcacion.numBarcosNavegando--;
    }

// ------------------------------------------------------------------------
// Método Abstracto (sin implementación)
// ------------------------------------------------------------------------
    /**
     * Método abstracto para señalizar la embarcación.
     */
    public abstract void señalizar();

// ------------------------------------------------------------------------
// Método toString (imprime el estado del objeto)
// ------------------------------------------------------------------------
    /**
     * Devuelve una representación en cadena del estado actual de la
     * embarcación.
     *
     * @return Una cadena con la información de la embarcación.
     */
    @Override
    public String toString() {
        return String.format("Nombre de la embarcación: %s, Tripulación: %s, Navegando: %s, Tiempo total de navegación de la embarcación: %1.2f horas",
                this.nombreBarco, this.numDeTripulantesBarco,
                !this.estaNavegandoBarco ? "No" : String.format("Sí, con el patrón %s en %s a %s nudos",
                                this.nombreDelPatronBarco, this.rumboBarco, this.velocidadBarco),
                this.tiempoTotalDeNavegacionBarco / 60.0);
    }
    
}
