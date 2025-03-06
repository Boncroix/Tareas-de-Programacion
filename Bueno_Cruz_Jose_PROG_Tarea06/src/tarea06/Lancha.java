package tarea06;

// ------------------------------------------------------------
//                   Clase Lancha
// ------------------------------------------------------------
/**
 * Clase que representa una embarcación del tipo <strong>Lancha</strong>. La
 * lancha tiene un número limitado de motores y una cantidad de combustible, y
 * su comportamiento de navegación está determinado por esos factores.
 *
 * La clase lancha hereda de la clase {@link Embarcacion} e implementa los
 * métodos para navegar, establecer rumbo, y gestionar el combustible.
 *
 * @author José Bueno Cruz
 */
public final class Lancha extends Embarcacion {

// ------------------------------------------------------------------------
// Atributos estáticos públicos (inmutables)
// ------------------------------------------------------------------------
    /**
     * El número mínimo de motores que puede tener una lancha: 1.
     */
    public static final int MIN_MOTORES = 1;

    /**
     * El número máximo de motores que puede tener una lancha: 2.
     */
    public static final int MAX_MOTORES = 2;

    /**
     * El nivel mínimo de combustible (en litros) necesario para que la lancha
     * inicie la navegación: 8.
     */
    public static final int MIN_COMBUSTIBLE = 8;

    /**
     * El nivel máximo de combustible (en litros) que puede tener la lancha: 50.
     */
    public static final int MAX_COMBUSTIBLE = 50;

    /**
     * El factor de consumo de combustible por cada nudo navegando durante una
     * hora: 0.026.
     */
    public static final double FACTOR_COMBUSTIBLE = 0.026;

    /**
     * La velocidad mínima en nudos que una lancha puede tener: 1.
     */
    public static final int MIN_VELOCIDAD_LANCHA = 1;

    /**
     * La velocidad máxima en nudos que una lancha puede tener: 50.
     */
    public static final int MAX_VELOCIDAD_LANCHA = 50;

// ------------------------------------------------------------------------
// Atributos estáticos privados (mutables)
// ------------------------------------------------------------------------
    /**
     * El número total de lanchas creadas.
     */
    private static int numDeLanchas;

// ------------------------------------------------------------------------
// Atributos de objeto inmutables (privados)
// ------------------------------------------------------------------------
    /**
     * El número de motores de la lancha.
     */
    private final int numMotores;

// ------------------------------------------------------------------------
// Atributos de objeto variables (privados)
// ------------------------------------------------------------------------
    /**
     * El nivel actual de combustible de la lancha (en litros).
     */
    private int nivelCombustible;

// ------------------------------------------------------------------------
// Constructores de la clase
// ------------------------------------------------------------------------
    /**
     * Constructor principal para crear una nueva lancha.
     *
     * @param nombre El nombre de la lancha.
     * @param numMotores El número de motores de la lancha (debe estar entre
     * {@link Lancha#MIN_MOTORES} y {@link Lancha#MAX_MOTORES}).
     * @param nivelCombustible El nivel de combustible de la lancha (debe estar
     * entre {@link Lancha#MIN_COMBUSTIBLE} y {@link Lancha#MAX_COMBUSTIBLE}).
     * @param numMaxTripulantes El número máximo de tripulantes que puede tener
     * la lancha.
     * @throws IllegalArgumentException Si el número de motores o el nivel de
     * combustible no están en el rango válido.
     * @throws IllegalArgumentException Si el nombre está vacío o el número de
     * tripulantes es menor que el mínimo.
     * @throws NullPointerException Si el nombre es nulo.
     */
    public Lancha(String nombre, int numMotores, int nivelCombustible, int numMaxTripulantes) throws IllegalArgumentException {
        super(nombre, numMaxTripulantes);

        if (numMotores < Lancha.MIN_MOTORES || numMotores > Lancha.MAX_MOTORES) {
            throw new IllegalArgumentException(String.format("El número de motores debe estar entre %d y %d.\n", Lancha.MIN_MOTORES, Lancha.MAX_MOTORES));
        }

        if (nivelCombustible < Lancha.MIN_COMBUSTIBLE || nivelCombustible > Lancha.MAX_COMBUSTIBLE) {
            throw new IllegalArgumentException(String.format("El nivel de combustible debe estar entre %d y %d.\n", Lancha.MIN_COMBUSTIBLE, Lancha.MAX_COMBUSTIBLE));
        }

        this.numMotores = numMotores;
        this.nivelCombustible = nivelCombustible;
        Lancha.numDeLanchas++;
    }

    /**
     * Constructor por defecto para crear una lancha con parámetros
     * predeterminados.
     *
     * Utiliza el nombre por defecto, el número máximo de motores, el nivel de
     * combustible máximo y el número mínimo de tripulantes.
     */
    public Lancha() {
        this("Lancha " + Lancha.numDeLanchas, Lancha.MAX_MOTORES, Lancha.MAX_COMBUSTIBLE, Embarcacion.MIN_TRIPULANTES);
    }

// ------------------------------------------------------------------------
// Getters de objeto
// ------------------------------------------------------------------------
    /**
     * Obtiene el número de motores de la lancha.
     *
     * @return El número de motores.
     */
    public int getNumMotores() {
        return numMotores;
    }

    /**
     * Obtiene el nivel de combustible de la lancha.
     *
     * @return El nivel de combustible (en litros).
     */
    public int getCantidadCombustible() {
        return nivelCombustible;
    }

// ------------------------------------------------------------------------
// Métodos estáticos (acceden a los atributos estáticos de la clase)
// ------------------------------------------------------------------------
    /**
     * Obtiene el número total de lanchas creadas.
     *
     * @return El número total de lanchas.
     */
    public static int getNumLanchas() {
        return numDeLanchas;
    }

// ------------------------------------------------------------------------
// Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
// ------------------------------------------------------------------------
    /**
     * Cambia el rumbo de la lancha, asegurándose de que el nuevo rumbo sea
     * válido.
     *
     * @param nuevoRumbo El nuevo rumbo (norte, sur, este u oeste).
     * @throws IllegalArgumentException Si el rumbo no es válido.
     * @throws NullPointerException Si el rumbo es nulo.
     * @throws IllegalStateException Si la embarcación no está navegando.
     */
    @Override
    public void setRumbo(String nuevoRumbo) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        if (nuevoRumbo == null) {
            throw new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo (norte, sur, este u oeste) para poder modificarlo.\n");
        }

        if (!nuevoRumbo.equalsIgnoreCase("Norte")
                && !nuevoRumbo.equalsIgnoreCase("Sur")
                && !nuevoRumbo.equalsIgnoreCase("Este")
                && !nuevoRumbo.equalsIgnoreCase("Oeste")) {
            throw new IllegalArgumentException("El rumbo no es correcto, debes indicar el rumbo (norte, sur, este u oeste) para poder modificarlo.\n");
        }

        super.setRumbo(nuevoRumbo);
    }

    /**
     * Inicia la navegación de la lancha, verificando que el combustible y la
     * velocidad sean válidos.
     *
     * @param velocidad La velocidad de la lancha (en nudos).
     * @param rumbo El rumbo de la lancha (norte, sur, este u oeste).
     * @param patron El nombre del patrón de la lancha.
     * @param numTripulantes El número de tripulantes de la lancha.
     * @throws IllegalStateException Si la lancha no tiene suficiente
     * combustible o ya está navegando.
     * @throws IllegalArgumentException Si la velocidad está fuera del rango
     * válido.
     * @throws NullPointerException Si el rumbo o el patrón son nulos.
     * @throws IllegalStateException Si la embarcación ya está navegando.
     * @throws IllegalArgumentException Si el número de tripulantes es inferior
     * al permitido.
     * @throws NullPointerException Si el rumbo o patrón son invalidos o están
     * vacios.
     */
    @Override
    public void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        if (this.nivelCombustible < Lancha.MIN_COMBUSTIBLE || this.nivelCombustible > Lancha.MAX_COMBUSTIBLE) {
            throw new IllegalStateException(String.format("La lancha %s no tiene un nivel de combustible válido para iniciar la navegación (solo %d litros).\n", this.getNombreBarco(), this.nivelCombustible));
        }

        if (velocidad < Lancha.MIN_VELOCIDAD_LANCHA || velocidad > Lancha.MAX_VELOCIDAD_LANCHA) {
            throw new IllegalArgumentException(String.format("La velocidad de navegación de %d nudos asignada a %s es incorrecta.\n", velocidad, this.getNombreBarco()));
        }

        super.iniciarNavegacion(velocidad, rumbo, patron, numTripulantes);
    }

    /**
     * Detiene la navegación de la lancha y actualiza el nivel de combustible.
     *
     * @param tiempoNavegacion El tiempo total de navegación (en minutos).
     * @throws IllegalStateException Si la lancha no está navegando.
     * @throws IllegalArgumentException Si el tiempo de navegación es negativo.
     * @throws IllegalStateException Si la embarcación no está navegando.
     * @throws IllegalArgumentException Si el tiempo de navegación es negativo.
     */
    @Override
    public void pararNavegacion(int tiempoNavegacion) throws IllegalStateException, IllegalArgumentException {
        double cantidadCombustibleConsumido = this.velocidadBarco * tiempoNavegacion * Lancha.FACTOR_COMBUSTIBLE;
        super.pararNavegacion(tiempoNavegacion);
        this.nivelCombustible -= (int) Math.round(cantidadCombustibleConsumido);

        if (this.nivelCombustible < 0) {
            this.nivelCombustible = 0;
        }
    }

// ------------------------------------------------------------------------
// Método Abstracto sobreecrito
// ------------------------------------------------------------------------
    /**
     * Método que emite una señal de aviso de la lancha utilizando bocinas y
     * luces intermitentes.
     */
    @Override
    public void señalizar() {
        System.out.printf("AVISO de señalización de la lancha %s con bocinas y luces intermitentes.", this.getNombreBarco());
    }

// ------------------------------------------------------------------------
// Método toString (imprime el estado del objeto)
// ------------------------------------------------------------------------
    /**
     * Devuelve una representación en forma de cadena de la lancha
     *
     * @return Una cadena que representa el estado de la lancha.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Numero de motores: %d, Nivel de combustible: %d.", this.numMotores, this.nivelCombustible);
    }
    
}
