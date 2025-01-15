package tarea05;

/**
 * Clase que representa un <strong>Velero</strong>.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li><strong>Nombre</strong> del velero.</li>
 * <li><strong>Máxima cantidad de tripulantes</strong> que puede llevar.</li>
 * <li><strong>Número de mástiles</strong> del velero.</li>
 * <li><strong>Estado de navegación</strong> del velero
 * (<strong>navegando</strong> o <strong>detenido</strong>).</li>
 * <li><strong>Velocidad</strong> actual del velero (nudos).</li>
 * <li><strong>Tiempo total de navegación</strong> del velero (minutos).</li>
 * <li><strong>Número actual de tripulantes</strong> a bordo.</li>
 * <li><strong>Rumbo</strong> actual del velero.</li>
 * <li><strong>Nombre del patrón</strong> que comanda el velero.</li>
 * </ul>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>Número total de veleros</strong> creados.</li>
 * <li><strong>Número de veleros navegando</strong> en el momento actual.</li>
 * <li><strong>Tiempo total de navegación</strong> acumulado por todos los
 * veleros creados (minutos).</li>
 * </ul>
 * <p>
 * Esta clase está diseñada para su uso en simulaciones de navegación, regatas y
 * otras aplicaciones que requieran el modelado de veleros en un entorno de
 * navegación.</p>
 *
 * @author José Bueno Cruz
 */
public class Velero {

// ATRIBUTOS ESTÁTICOS (de clase)
// ------------------------------------------------------------------------
// Atributos estáticos publicos y constantes
    static public final int MIN_MASTILES = 1;           // Número mínimo de mástiles permitido para un velero
    static public final int MAX_MASTILES = 4;           // Número máximo de mástiles permitido para un velero
    static public final int MIN_VELOCIDAD = 2;          // Velocidad mínima permitida para el velero (nudos)
    static public final int MAX_VELOCIDAD = 30;         // Velocidad máxima permitida para el velero (nudos)
    static public final int MIN_TRIPULANTES = 0;        // Número mínimo de tripulantes permitido
    static public final String PATRON_POR_DEFECTO = "Sin patrón";  // Nombre por defecto del patrón del velero
    static public final String RUMBO_POR_DEFECTO = "Sin rumbo";    // Rumbo por defecto del velero

// Atributos estáticos privados y variables
    static private int numDeVelerosClase;               // Número total de veleros creados hasta el momento
    static private int numDeVelerosNavegandoClase;      // Número de veleros que están navegando actualmente
    static private double tiempoTotalDeNavegacionClase; // Tiempo total acumulado de navegación de todos los veleros (en minutos)

// ATRIBUTOS DE OBJETO
// ------------------------------------------------------------------------
// Atributos constantes durante la vida del velero (desde que se crea el objeto)
    private final String nombre;                        // Nombre único que identifica al velero
    private final int maxTripulantes;                   // Número máximo de tripulantes que puede llevar el velero
    private final int numMastiles;                      // Número de mástiles que tiene el velero

// Atributos variables del estado del barco
    private boolean isNavegando;                        // Estado del velero: navegando (true) o detenido (false)
    private int velocidad;                              // Velocidad actual del velero (en nudos)
    private int tiempoTotalDeNavegacion;                // Tiempo total de navegación de este velero (en minutos)
    private int numDeTripulantes;                       // Número actual de tripulantes a bordo del velero
    private String rumbo;                               // Rumbo actual del velero (dirección en la que navega)
    private String nombreDelPatron;                     // Nombre del patrón que comanda el velero

    
    /**
     * Constructor con parámetros para crear una nueva instancia de un velero
     * con valores específicos. Este constructor permite inicializar un velero
     * con su nombre, número de mástiles y número máximo de tripulantes.
     *
     * Realiza las siguientes comprobaciones para garantizar la validez de los
     * datos de entrada: - Si el nombre es nulo o vacío, lanza una excepción
     * {@link NullPointerException} o {@link IllegalArgumentException}. - Si el
     * número de mástiles está fuera del rango permitido (entre
     * {@link Velero#MIN_MASTILES} y {@link Velero#MAX_MASTILES}), lanza una
     * excepción {@link IllegalArgumentException}. - Si el número máximo de
     * tripulantes es menor que el mínimo permitido
     * ({@link Velero#MIN_TRIPULANTES}), lanza una excepción
     * {@link IllegalArgumentException}.
     *
     * Además, asigna valores predeterminados para el patrón y el rumbo: - El
     * patrón por defecto es {@link Velero#PATRON_POR_DEFECTO}. - El rumbo por
     * defecto es {@link Velero#RUMBO_POR_DEFECTO}.
     *
     * Finalmente, incrementa el contador de veleros creados
     * {@link Velero#numDeVelerosClase}.
     *
     * @param nombre El nombre del velero. No puede ser nulo ni vacío.
     * @param numDeMastiles El número de mástiles del velero. Debe estar entre
     * {@link Velero#MIN_MASTILES} y {@link Velero#MAX_MASTILES}.
     * @param numMaxDeTripulantes El número máximo de tripulantes del velero.
     * Debe ser al menos {@link Velero#MIN_TRIPULANTES}.
     *
     * @throws NullPointerException Si el nombre es nulo.
     * @throws IllegalArgumentException Si el nombre está vacío, el número de
     * mástiles está fuera de rango, o el número máximo de tripulantes es menor
     * que el mínimo permitido.
     */
    public Velero(String nombre, int numDeMastiles, int numMaxDeTripulantes) throws NullPointerException, IllegalArgumentException {

        //Comprobación entrada nombre
        if (nombre == null || nombre.isEmpty()) {
            throw new NullPointerException("El nombre del velero no puede ser nulo.");
        } else if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del velero no puede estar vacío.");
        }

        // Comprobación entrada número de mastiles
        if (numDeMastiles < Velero.MIN_MASTILES || numDeMastiles > MAX_MASTILES) {
            throw new IllegalArgumentException(String.format("El número de mástiles debe estar entre %d y %d.", Velero.MIN_MASTILES, Velero.MAX_MASTILES));
        }

        // Comprobación entrada número máximo de tripulantes
        if (numMaxDeTripulantes < Velero.MIN_TRIPULANTES) {
            throw new IllegalArgumentException(String.format("El número de tripulantes debe ser, como mínimo, %d.", Velero.MIN_TRIPULANTES));
        }

        // Asignación de atributos constantes de objeto
        this.nombre = nombre;
        this.numMastiles = numDeMastiles;
        this.maxTripulantes = numMaxDeTripulantes;
        this.nombreDelPatron = Velero.PATRON_POR_DEFECTO;
        this.rumbo = Velero.RUMBO_POR_DEFECTO;
        // Incrementación atributo variable de clase
        Velero.numDeVelerosClase++;
    }

    /**
     * Constructor por defecto para crear una nueva instancia de un velero con
     * valores predeterminados. Este constructor utiliza el constructor con
     * parámetros para asignar los valores predeterminados al velero.
     *
     * - El nombre del velero se genera automáticamente como "Velero X", donde X
     * es el número del velero en la secuencia, determinado por
     * {@link Velero#numDeVelerosClase}. - El número de mástiles se establece al
     * valor mínimo permitido, {@link Velero#MIN_MASTILES}. - El número máximo
     * de tripulantes se establece al valor mínimo permitido,
     * {@link Velero#MIN_TRIPULANTES}.
     *
     * Además, este constructor invoca el constructor con parámetros para
     * asegurar que se apliquen todas las validaciones necesarias.
     */
    public Velero() {
        this(String.format("Velero %d", Velero.numDeVelerosClase + 1), Velero.MIN_MASTILES, Velero.MIN_TRIPULANTES);
    }

    // Método fábrica.
    public static Velero[] crearArrayVelero(int cantidadDeVeleros) {
        // Comprobación de entrada cantidad de veleros
        if (cantidadDeVeleros < 1 || cantidadDeVeleros > 10) {
            throw new IllegalArgumentException(String.format("Número de barcos incorrecto %d, debe ser mayor o igual que 1 y menor o igual que 10.", cantidadDeVeleros));
        }
        // 
        Velero[] arrayVeleros = new Velero[cantidadDeVeleros];
        for (int i = 0; i < cantidadDeVeleros; i++) {
            arrayVeleros[i] = new Velero();
        }
        return arrayVeleros;
    }

    /**
     * Método getter para obtener el nombre del velero.
     *
     * Este método devuelve el nombre del velero, que fue asignado al crear la
     * instancia del objeto.
     *
     * @return El nombre del velero.
     */
    public String getNombreBarco() {
        return this.nombre;
    }

    /**
     * Método getter para obtener el número de mástiles del velero.
     *
     * Este método devuelve el número de mástiles del velero, que fue asignado
     * al crear la instancia del objeto.
     *
     * @return El número de mástiles del velero.
     */
    public int getNumMastiles() {
        return this.numMastiles;
    }

    /**
     * Método getter para obtener el número máximo de tripulantes del velero.
     *
     * Este método devuelve el número máximo de tripulantes que puede tener el
     * velero, que fue asignado al crear la instancia.
     *
     * @return El número máximo de tripulantes del velero.
     */
    public int getMaxTripulantes() {
        return this.maxTripulantes;
    }

    /**
     * Método getter para saber si el velero está navegando.
     *
     * Este método devuelve el estado de navegación del velero, indicando si
     * está en movimiento o detenido.
     *
     * @return true si el velero está navegando, false si no lo está.
     */
    public boolean isNavegando() {
        return this.isNavegando;
    }

    /**
     * Método getter para obtener el tiempo total de navegación del velero.
     *
     * Este método devuelve el tiempo total acumulado de navegación del velero
     * en minutos.
     *
     * @return El tiempo total de navegación del velero, en minutos.
     */
    public int getTiempoTotalNavegacionBarco() {
        return this.tiempoTotalDeNavegacion;
    }

    /**
     * Método getter para obtener la velocidad actual del velero.
     *
     * Este método devuelve la velocidad actual del velero en nudos.
     *
     * @return La velocidad actual del velero, en nudos.
     */
    public int getVelocidad() {
        return this.velocidad;
    }

    /**
     * Método getter para obtener el rumbo actual del velero.
     *
     * Este método devuelve el rumbo actual del velero, que puede ser "ceñida" o
     * "empopada".
     *
     * @return El rumbo actual del velero.
     */
    public String getRumbo() {
        return this.rumbo;
    }

    /**
     * Método getter para obtener el nombre del patrón del velero.
     *
     * Este método devuelve el nombre del patrón que está al mando del velero.
     *
     * @return El nombre del patrón del velero.
     */
    public String getPatron() {
        return this.nombreDelPatron;
    }

    /**
     * Método getter para obtener el número de tripulantes actuales del velero.
     *
     * Este método devuelve el número actual de tripulantes a bordo del velero.
     *
     * @return El número de tripulantes a bordo del velero.
     */
    public int getTripulacion() {
        return this.numDeTripulantes;
    }

    // ------------------------------------------------------------------------
    // Métodos getter estáticos (acceden a los atributos estáticos de la clase)
    // ------------------------------------------------------------------------
    /**
     * Método getter para obtener el número total de veleros creados.
     *
     * Este método devuelve el número total de veleros creados a lo largo de la
     * ejecución del programa.
     *
     * @return El número total de veleros creados.
     */
    public static int getNumBarcos() {
        return Velero.numDeVelerosClase;
    }

    /**
     * Método getter para obtener el número total de veleros actualmente
     * navegando.
     *
     * Este método devuelve el número total de veleros que están actualmente en
     * navegación.
     *
     * @return El número total de veleros actualmente navegando.
     */
    public static int getNumBarcosNavegando() {
        return Velero.numDeVelerosNavegandoClase;
    }

    /**
     * Método getter para obtener el tiempo total de navegación acumulado por
     * todos los veleros.
     *
     * Este método devuelve el tiempo total acumulado de navegación de todos los
     * veleros en el sistema, medido en minutos.
     *
     * @return El tiempo total de navegación acumulado de todos los veleros, en
     * minutos.
     */
    public static double getTiempoTotalNavegacion() {
        return Velero.tiempoTotalDeNavegacionClase;
    }
    // ------------------------------------------------------------------------
    // Setters (modifican el estado del objeto)
    // ------------------------------------------------------------------------

    /**
     * Inicia la navegación del velero, configurando los parámetros de
     * velocidad, rumbo, patrón y número de tripulantes.
     *
     * Este método modifica el estado del velero para reflejar que está en
     * navegación. Asegura que todos los parámetros sean válidos antes de
     * proceder. Si alguno de los parámetros es inválido o si el velero ya está
     * navegando, lanza una excepción.
     *
     * Realiza las siguientes comprobaciones antes de iniciar la navegación: -
     * **Velocidad**: Verifica que la velocidad esté dentro del rango permitido
     * entre {@link Velero#MIN_VELOCIDAD} y {@link Velero#MAX_VELOCIDAD}. -
     * **Estado de navegación**: Si el velero ya está navegando, lanza una
     * {@link IllegalStateException} indicando que ya está fuera de puerto. -
     * **Rumbo**: Verifica que el rumbo no sea nulo ni vacío. - **Patrón**:
     * Verifica que el nombre del patrón no sea nulo ni vacío. - **Número de
     * tripulantes**: Verifica que el número de tripulantes esté dentro del
     * rango permitido, entre {@link Velero#MIN_TRIPULANTES} y el número máximo
     * de tripulantes del velero.
     *
     * Si todas las comprobaciones son exitosas, actualiza los atributos del
     * velero: - Asigna la velocidad, rumbo, nombre del patrón y número de
     * tripulantes. - Marca el velero como "navegando" (isNavegando = true). -
     * Incrementa el contador de veleros navegando
     * {@link Velero#numDeVelerosNavegandoClase}.
     *
     * @param velocidad La velocidad del velero en nudos, debe estar entre
     * {@link Velero#MIN_VELOCIDAD} y {@link Velero#MAX_VELOCIDAD}.
     * @param rumbo El rumbo del velero, debe ser un valor no nulo y no vacío.
     * @param nombreDelPatron El nombre del patrón del velero, debe ser un valor
     * no nulo y no vacío.
     * @param numDeTripulantes El número de tripulantes a bordo, debe estar
     * entre {@link Velero#MIN_TRIPULANTES} y el número máximo de tripulantes
     * del velero.
     *
     * @throws IllegalArgumentException Si la velocidad, el número de
     * tripulantes o el rumbo son inválidos.
     * @throws NullPointerException Si el rumbo o el nombre del patrón son
     * nulos.
     * @throws IllegalStateException Si el velero ya está navegando.
     */
    public void iniciarNavegacion(int velocidad, String rumbo, String nombreDelPatron, int numDeTripulantes) {
        // Comprobación parámetro velocidad
        if (velocidad < Velero.MIN_VELOCIDAD || velocidad > Velero.MAX_VELOCIDAD) {
            throw new IllegalArgumentException(String.format("La velocidad de navegación de %d nudos es incorrecta.", velocidad));
        }

        // Comprueba si el velero ya está navegando
        if (this.isNavegando) {
            throw new IllegalStateException(String.format("El velero %s ya está navegando y se encuentra fuera de puerto.", this.nombre));
        }

        // Comprobación parámetro rumbo
        if (rumbo == null) {
            throw new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo para iniciar la navegación.");
        } else if (rumbo.isEmpty()) {
            throw new IllegalArgumentException("El rumbo no puede estar vacío, debes indicar el rumbo para iniciar la navegación.");
        }

        // Comprobación parámetro nombre del patrón
        if (nombreDelPatron == null) {
            throw new NullPointerException("El patrón del barco no puede ser nulo, se necesita un patrón para iniciar la navegación.");
        } else if (nombreDelPatron.isEmpty()) {
            throw new IllegalArgumentException("El patrón del barco no puede estar vacío, se necesita un patrón para iniciar la navegación.");
        }

        // Comprobación parámetro numero de tripulantes 
        if (numDeTripulantes < Velero.MIN_TRIPULANTES || numDeTripulantes > this.maxTripulantes) {
            throw new IllegalArgumentException(String.format("El número de tripulantes debe estar entre %d y %d.", Velero.MIN_TRIPULANTES, this.maxTripulantes));
        }

        // Asistar atributos
        this.velocidad = velocidad;
        this.rumbo = rumbo;
        this.nombreDelPatron = nombreDelPatron;
        this.numDeTripulantes = numDeTripulantes;
        this.isNavegando = true;
        Velero.numDeVelerosNavegandoClase++;
    }

    /**
     * Detiene la navegación del velero y actualiza su estado, incluyendo el
     * tiempo total de navegación.
     *
     * Este método modifica el estado del velero para reflejar que ha detenido
     * su navegación. Asegura que el velero esté navegando antes de proceder. Si
     * el velero no está navegando, lanza una excepción. Además, actualiza el
     * tiempo total de navegación del velero y de la clase, y reinicia varios
     * atributos del velero.
     *
     * Realiza las siguientes comprobaciones antes de detener la navegación: -
     * **Estado de navegación**: Si el velero no está navegando, lanza una
     * {@link IllegalStateException} indicando que no está en movimiento. -
     * **Tiempo de navegación**: Verifica que el tiempo de navegación pasado
     * como parámetro sea mayor que cero. Si es negativo, lanza una
     * {@link IllegalArgumentException}.
     *
     * Si las comprobaciones son exitosas, realiza las siguientes acciones: -
     * Asigna la velocidad a 0, el rumbo al valor por defecto y el nombre del
     * patrón al valor por defecto. - Establece el número de tripulantes a 0. -
     * Acumula el tiempo de navegación en el atributo
     * {@link Velero#tiempoTotalDeNavegacionClase}. - Marca el velero como no
     * navegando (isNavegando = false). - Decrementa el contador de veleros
     * navegando {@link Velero#numDeVelerosNavegandoClase}.
     *
     * @param tiempoNavegando El tiempo que el velero ha estado navegando, en
     * minutos. Debe ser mayor que cero.
     *
     * @throws IllegalStateException Si el velero no está navegando.
     * @throws IllegalArgumentException Si el tiempo de navegación es menor que
     * cero.
     */
    public void pararNavegacion(int tiempoNavegando) {
        // Comprueba si el velero ya está parado
        if (!this.isNavegando) {
            throw new IllegalStateException(String.format("El velero %s no está navegando.", this.nombre));
        }

        // Comprobación parámetro tiempo navegando
        if (tiempoNavegando < 0) {
            throw new IllegalArgumentException("Tiempo navegando incorrecto, debe ser mayor que cero.");
        }

        // Asignación de parámetros
        this.velocidad = 0;
        this.rumbo = Velero.RUMBO_POR_DEFECTO;
        this.nombreDelPatron = Velero.PATRON_POR_DEFECTO;
        this.numDeTripulantes = 0;
        this.tiempoTotalDeNavegacion += tiempoNavegando;
        this.isNavegando = false;
        Velero.numDeVelerosNavegandoClase--;
        Velero.tiempoTotalDeNavegacionClase += tiempoNavegando;
    }

    /**
     * Cambia el rumbo del velero mientras esté en navegación.
     *
     * Este método permite modificar el rumbo del velero si está actualmente
     * navegando. Asegura que el nuevo rumbo proporcionado sea válido, no nulo,
     * y que el velero aún no esté navegando con el mismo rumbo. Si el velero no
     * está navegando o el rumbo es inválido, lanza una excepción.
     *
     * Realiza las siguientes comprobaciones antes de cambiar el rumbo: -
     * **Estado de navegación**: Si el velero no está navegando, lanza una
     * {@link IllegalStateException} indicando que no se puede cambiar el rumbo.
     * - **Nuevo rumbo**: Verifica que el rumbo proporcionado no sea nulo, vacío
     * ni diferente de los valores esperados ("ceñida" o "empopada"). - **Rumbo
     * actual**: Si el velero ya está navegando con el mismo rumbo, lanza una
     * {@link IllegalStateException}.
     *
     * Si todas las comprobaciones son exitosas, se actualiza el rumbo del
     * velero con el nuevo valor proporcionado.
     *
     * @param nuevoRumbo El nuevo rumbo que se le desea asignar al velero. Debe
     * ser "ceñida" o "empopada".
     *
     * @throws IllegalStateException Si el velero no está navegando o si el
     * velero ya está navegando con el mismo rumbo.
     * @throws NullPointerException Si el nuevo rumbo es nulo.
     * @throws IllegalArgumentException Si el nuevo rumbo es vacío o no es uno
     * de los valores válidos ("ceñida" o "empopada").
     */
    public void setRumbo(String nuevoRumbo) {
        // Comprueba si el velero está navegando
        if (!this.isNavegando) {
            throw new IllegalStateException(String.format("El velero %s no está navegando, no se puede cambiar el rumbo.", this.nombre));
        }

        // Coprobación parámetro nuevo rumbo
        if (nuevoRumbo == null) {
            throw new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.");
        } else if (nuevoRumbo.isEmpty() || (!nuevoRumbo.equals("ceñida") && !nuevoRumbo.equals("empopada"))) {
            throw new IllegalArgumentException("El rumbo no es correcto, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.");
        } else if (nuevoRumbo.equals(this.rumbo)) {
            throw new IllegalStateException(String.format("El velero %s ya está navegando con ese rumbo (%s), debes indicar un rumbo distinto para poder modificarlo.", this.nombre, this.rumbo));
        }
        // Asignación de parámetros
        this.rumbo = nuevoRumbo;
    }
    // ------------------------------------------------------------------------
    // Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------

    /**
     * Inicia una regata entre este velero y otro velero oponente, comparando
     * sus velocidades y condiciones previas.
     *
     * Este método evalúa varias condiciones antes de permitir que se inicie una
     * regata entre dos veleros: - Ambos veleros deben estar navegando. - Los
     * veleros deben tener el mismo rumbo. - Los veleros deben tener el mismo
     * número de mástiles. Si alguna de estas condiciones no se cumple, se lanza
     * una excepción.
     *
     * Si todas las condiciones se cumplen, el método determina cuál de los dos
     * veleros ha llegado primero a la línea de llegada, comparando sus
     * velocidades. Si ambos veleros tienen la misma velocidad, se considera que
     * han llegado al mismo tiempo.
     *
     * @param oponente El velero con el que se desea competir en la regata. No
     * puede ser nulo.
     *
     * @return Una cadena de texto indicando el resultado de la regata,
     * especificando cuál de los veleros ha llegado primero, o si ambos han
     * llegado al mismo tiempo.
     *
     * @throws NullPointerException Si el velero oponente es nulo.
     * @throws IllegalStateException Si alguno de los veleros no está navegando,
     * si tienen rumbos diferentes o si tienen un número de mástiles diferente.
     */
    public String iniciarRegata(Velero oponente) {
        // Comprobar parámetro oponente 
        if (oponente == null) {
            throw new NullPointerException("El barco con el que se intenta regatear no existe.");
        }

        // Comprobar que los 2 barcos están navegando
        if (!this.isNavegando) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, el barco %s no está navegando.", this.nombre));
        } else if (!oponente.isNavegando) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, el barco %s no está navegando.", oponente.nombre));
        }

        // Comprobar que los 2 barcos tienen el mismo rumbo
        if (!this.rumbo.equals(oponente.rumbo)) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, los barcos %s y %s deben navegar con el mismo rumbo.", this.nombre, oponente.nombre));
        }

        // Comprobar que los 2 barcos tienen el mismo número de mastiles
        if (this.numMastiles != oponente.numMastiles) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, los barcos %s y %s no tienen el mismo numero de mástiles.", this.nombre, oponente.nombre));
        }

        String salida;
        // salida de datos
        if (this.velocidad == oponente.velocidad) {
            salida = String.format("Los barcos %s y %s han llegado a la vez a la línea de llegada.", this.nombre, oponente.nombre);
        } else {
            salida = String.format("El barco %s ha llegado antes a la línea de llegada.", this.velocidad > oponente.velocidad ? this.nombre : oponente.nombre);
        }

        return salida;

    }
    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------

    /**
     * Devuelve una representación en cadena del velero.
     *
     * Este método sobrescribe el método `toString` de la clase `Object` y
     * proporciona una cadena de texto que representa el estado actual del
     * velero, incluyendo su nombre, número de mástiles, tripulación, estado de
     * navegación y tiempo total de navegación acumulado. La representación
     * incluye información detallada solo si el velero está navegando, como el
     * patrón, rumbo y velocidad.
     *
     * La cadena devuelta tiene el siguiente formato:
     *
     * - Si el velero no está navegando: "{ Nombre del barco: [nombre], Número
     * de mástiles: [numMastiles], Tripulación: [numDeTripulantes], Navegando:
     * No, Tiempo total de navegación del barco: [tiempoTotalDeNavegacion] horas
     * }"
     *
     * - Si el velero está navegando: "{ Nombre del barco: [nombre], Número de
     * mástiles: [numMastiles], Tripulación: [numDeTripulantes], Navegando: Sí,
     * con el patrón [nombreDelPatron] en [rumbo] a [velocidad] nudos, Tiempo
     * total de navegación del barco: [tiempoTotalDeNavegacion] horas }"
     *
     * @return Una cadena de texto que representa el estado actual del velero.
     */
    @Override
    public String toString() {
        return String.format("{ Nombre del barco: %s, Número de mástiles: %d, Tripulación: %d, Navegando: %s, Tiempo total de navegación del barco: %s horas }",
                this.nombre, this.numMastiles, this.numDeTripulantes,
                !this.isNavegando ? "No" : String.format("Si, con el patrón %s en %s a %d nudos",
                                this.nombreDelPatron, this.rumbo, this.velocidad), this.tiempoTotalDeNavegacion / 60.0);
    }

}