package tarea06;

// ------------------------------------------------------------
//                   Clase Velero
// ------------------------------------------------------------
/**
 * Clase que representa una embarcación tipo <strong>Velero</strong>. El velero
 * tiene un númerolimitado de mástiles y unos límites de velocidad de
 * navegación, y su comportamiento de navegación está determinado por esos
 * factores.
 *
 *  * La clase velero hereda de la clase {@link Embarcacion} e implementa los
 * métodos para navegar, establecer rumbo, y gestionar el combustible.
 *
 *  * Además, implementa la interfaz {@link Regateable} y el método
 * {@link Regateable#iniciarRegata(Velero oponente)} para iniciar una regata con
 * otro velero.
 *
 * @author José Bueno Cruz
 */
public final class Velero extends Embarcacion implements Regateable {

// ------------------------------------------------------------------------
// Atributos estáticos públicos (inmutables)
// ------------------------------------------------------------------------
    /**
     * Número mínimo de mástiles permitido para un velero: 1.
     */
    public static final int MIN_MASTILES = 1;

    /**
     * Número máximo de mástiles permitido para un velero: 4.
     */
    public static final int MAX_MASTILES = 4;

    /**
     * Velocidad mínima de un velero en nudos: 2.
     */
    public static final int MIN_VELOCIDAD_VELERO = 2;

    /**
     * Velocidad máxima de un velero en nudos: 30.
     */
    public static final int MAX_VELOCIDAD_VELERO = 30;

// ------------------------------------------------------------------------
// Atributos estáticos privados (mutables)
// ------------------------------------------------------------------------
    /**
     * Número total de veleros creados.
     */
    private static int numVeleros;

// ------------------------------------------------------------------------
// Atributos de objeto inmutables (privados)
// ------------------------------------------------------------------------
    /**
     * Número de mástiles del velero.
     */
    private final int numMastiles;

// ------------------------------------------------------------------------
// Constructores de la clase
// ------------------------------------------------------------------------
    /**
     * Constructor principal para crear un velero con nombre, número de mástiles
     * y capacidad máxima de tripulantes.
     *
     * @param nombre Nombre del velero.
     * @param numMastiles Número de mástiles del velero. Debe estar entre
     * {@link Velero#MIN_MASTILES} y {@link Velero#MAX_MASTILES}.
     * @param numMaxTripulantes Número máximo de tripulantes del velero.
     * @throws IllegalArgumentException Si el número de mástiles no está en el
     * rango permitido.
     * @throws IllegalArgumentException Si el nombre está vacío o el número de
     * tripulantes es menor que el mínimo.
     * @throws NullPointerException Si el nombre es nulo.
     */
    public Velero(String nombre, int numMastiles, int numMaxTripulantes) throws IllegalArgumentException {
        super(nombre, numMaxTripulantes);

        if (numMastiles < Velero.MIN_MASTILES || numMastiles > Velero.MAX_MASTILES) {
            throw new IllegalArgumentException(String.format("El número de mástiles debe estar entre %d y %d.\n", Velero.MIN_MASTILES, Velero.MAX_MASTILES));
        }

        this.numMastiles = numMastiles;
        Velero.numVeleros++;
    }

    /**
     * Constructor por defecto que crea un velero con un nombre predeterminado y
     * con los valores mínimos de mástiles y tripulantes.
     */
    public Velero() {
        this("Velero " + Velero.numVeleros, Velero.MIN_MASTILES, Embarcacion.MIN_TRIPULANTES);
    }

// ------------------------------------------------------------------------
// Getters de objeto
// ------------------------------------------------------------------------
    /**
     * Obtiene el número de mástiles del velero.
     *
     * @return El número de mástiles del velero.
     */
    public int getNumMastiles() {
        return numMastiles;
    }

// ------------------------------------------------------------------------
// Métodos estáticos (acceden a los atributos estáticos de la clase)
// ------------------------------------------------------------------------
    /**
     * Obtiene el número total de veleros creados.
     *
     * @return El número total de veleros creados.
     */
    public static int getNumVeleros() {
        return numVeleros;
    }

// ------------------------------------------------------------------------
// Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
// ------------------------------------------------------------------------
    /**
     * Establece el rumbo de navegación del velero.
     *
     * @param nuevoRumbo El nuevo rumbo a establecer (debe ser "Ceñida" o
     * "empopada").
     * @throws IllegalArgumentException Si el rumbo no es válido.
     * @throws NullPointerException Si el rumbo es nulo.
     * @throws IllegalStateException Si la embarcación no está navegando.
     */
    @Override
    public void setRumbo(String nuevoRumbo) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        if (nuevoRumbo == null) {
            throw new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.\n");
        }

        if (!nuevoRumbo.equalsIgnoreCase("Ceñida") && !nuevoRumbo.equalsIgnoreCase("empopada")) {
            throw new IllegalArgumentException("El rumbo no es correcto, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.\n");
        }

        super.setRumbo(nuevoRumbo);
    }

    /**
     * Inicia la navegación del velero con una velocidad, rumbo y tripulación
     * definidos.
     *
     * @param velocidad Velocidad de navegación en nudos. Debe estar entre
     * {@link Velero#MIN_VELOCIDAD_VELERO} y
     * {@link Velero#MAX_VELOCIDAD_VELERO}.
     * @param rumbo El rumbo de navegación (ceñida o empopada).
     * @param patron Nombre del patrón que dirige el velero.
     * @param numTripulantes Número de tripulantes a bordo.
     * @throws IllegalArgumentException Si la velocidad no está en el rango
     * permitido.
     * @throws IllegalStateException Si la embarcación ya está navegando.
     * @throws IllegalArgumentException Si el número de tripulantes es inferior
     * al permitido.
     * @throws NullPointerException Si el rumbo o patrón son invalidos o están
     * vacios.
     */
    @Override
    public void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        if (velocidad < Velero.MIN_VELOCIDAD_VELERO || velocidad > Velero.MAX_VELOCIDAD_VELERO) {
            throw new IllegalArgumentException(String.format("La velocidad de navegación de %d nudos asignada a %s es incorrecta.\n", velocidad, this.getNombreBarco()));
        }

        super.iniciarNavegacion(velocidad, rumbo, patron, numTripulantes);
    }

    /**
     * Inicia una regata con otro velero.
     *
     * @param oponente El velero con el que se competirá.
     * @return Un mensaje indicando el resultado de la regata.
     * @throws IllegalStateException Si algún velero no está navegando o no
     * tiene el mismo rumbo o tienen distinto número de mástiles.
     * @throws NullPointerException Si el oponente es nulo.
     */
    @Override
    public String iniciarRegata(Velero oponente) throws IllegalStateException, NullPointerException {
        if (oponente == null) {
            throw new NullPointerException("El barco con el que se intenta regatear no existe.\n");
        }

        if (!oponente.isNavegando() || !this.isNavegando()) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, el barco %s no está navegando.\n", !oponente.isNavegando() ? oponente.getNombreBarco() : this.getNombreBarco()));
        }

        if (!oponente.getRumbo().equals(this.getRumbo())) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, los barcos %s y %s deben navegar con el mismo rumbo.\n", oponente.getNombreBarco(), this.getNombreBarco()));
        }

        if (oponente.numMastiles != this.numMastiles) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, los barcos %s y %s no tienen el mismo numero de mástiles.\n", oponente.getNombreBarco(), this.getNombreBarco()));
        }

        String salida;
        if (this.velocidadBarco == oponente.velocidadBarco) {
            salida = String.format("Los veleros %s y %s han llegado a la vez a la línea de llegada.\n", this.getNombreBarco(), oponente.getNombreBarco());
        } else {
            salida = String.format("El velero %s ha llegado primero a la línea de llegada.\n", (this.velocidadBarco > oponente.velocidadBarco) ? this.getNombreBarco() : oponente.getNombreBarco());
        }

        return salida;
    }

// ------------------------------------------------------------------------
// Método Abstracto sobreecrito
// ------------------------------------------------------------------------
    /**
     * Método que emite una señalización del velero utilizando banderas.
     */
    @Override
    public void señalizar() {
        System.out.printf("AVISO del velero %s con banderas de señalización marítima.", this.getNombreBarco());
    }

// ------------------------------------------------------------------------
// Método toString (imprime el estado del objeto)
// ------------------------------------------------------------------------
    /**
     * Devuelve una representación en forma de cadena del velero.
     *
     * @return Una cadena que representa el estado del velero.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Numero de mástiles: %d.", this.numMastiles);
    }
    
}
