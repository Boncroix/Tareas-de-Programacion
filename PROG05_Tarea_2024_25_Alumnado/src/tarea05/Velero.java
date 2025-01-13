package tarea05;

/** Clase que representa un <strong>Velero</strong>.
 * Esta clase gestiona las propiedades de un velero
 *
 * <p>Está diseñada para su uso en simulaciones de navegación, regatas y otras aplicaciones que
 * requieran el modelado de veleros en un entorno de navegación.</p>
 *
 * @author José Bueno Cruz
 */

public class Velero {
/**
 * Atributos estáticos, públicos e inmutables de clase.
 * Estas constantes definen los límites y valores predeterminados utilizados para crear y configurar un velero.
 * Son inmutables (finales) y se usan principalmente para validar las propiedades de los veleros al ser creados.
 * 
 * - MIN_MASTILES: valor mínimo permitido para el número de mástiles (1). 
 *   Indica que un velero no puede tener menos de este número de mástiles.
 * - MAX_MASTILES: valor máximo permitido para el número de mástiles (4).
 *   Indica que un velero no puede tener más de este número de mástiles.
 * - MIN_VELOCIDAD: velocidad mínima permitida en nudos (2).
 *   Define la velocidad más baja a la que un velero puede navegar de manera segura.
 * - MAX_VELOCIDAD: velocidad máxima permitida en nudos (30).
 *   Limita la velocidad máxima que puede alcanzar un velero por razones de seguridad y operatividad.
 * - MIN_TRIPULANTES: número mínimo de tripulantes requerido para operar el velero (0).
 *   Este valor representa el mínimo necesario para la operatividad básica del velero.
 * - PATRON_POR_DEFECTO: valor por defecto del patrón del velero ("Sin patrón").
 *   Se asigna cuando no se especifica un patrón al crear un velero.
 * - RUMBO_POR_DEFECTO: valor por defecto del rumbo del velero ("Sin rumbo").
 *   Se asigna cuando no se especifica un rumbo al crear un velero.
 */
  
  static public final int MIN_MASTILES = 1;
  static public final int MAX_MASTILES = 4;
  static public final int MIN_VELOCIDAD = 2;
  static public final int MAX_VELOCIDAD = 30;
  static public final int MIN_TRIPULANTES = 0;
  static public final String PATRON_POR_DEFECTO = "Sin patrón";
  static public final String RUMBO_POR_DEFECTO = "Sin rumbo";

/**
 * Atributos estáticos, privados de clase.
 * Estas variables almacenan información relacionada con la clase en su conjunto,
 * y se actualizan a medida que se crean veleros o se modifican sus estados de navegación.
 * 
 * - numDeVelerosClase: el número total de veleros creados a lo largo de la ejecución del programa.
 *   Este valor se incrementa cada vez que se crea un nuevo velero.
 * - numDeVelerosNavegandoClase: el número total de veleros actualmente navegando.
 *   Este valor se incrementa o decrementa según el estado de navegación de los veleros.
 * - tiempoTotalDeNavegacionClase: el tiempo total acumulado de navegación de todos los veleros
 *   (en minutos). Este valor se actualiza cada vez que un velero termina su navegación.
 */
  
  static private int numDeVelerosClase;
  static private int numDeVelerosNavegandoClase;
  static private double tiempoTotalDeNavegacionClase;

  // ------------------------------------------------------------------------
  // Atributos de objeto inmutables (privados)
  // Representan el estado del objeto pero no pueden cambiar su valor
  // ------------------------------------------------------------------------
  private final String nombre;
  private final int maxTripulantes;
  private final int numMastiles;

  // ------------------------------------------------------------------------
  // Atributos de objeto variables (privados)
  // Representan el estado del objeto y pueden cambiar su valor
  // ------------------------------------------------------------------------
  // ------------------------------------------------------------------------
  // Atributos del estado del barco
  // ------------------------------------------------------------------------
  // Representan el estado básico del barco en un momento dado
  // ------------------------------------------------------------------------
  private boolean isNavegando;
  private int velocidad;
  private double tiempoTotalDeNavegacion;

  // ------------------------------------------------------------------------
  // Atributos de la información de navegación
  // ------------------------------------------------------------------------
  // Almacenan información sobre los parámetros de navegación
  // ------------------------------------------------------------------------
  private int numDeTripulantes;
  private String rumbo;
  private String nombreDelPatron;

  // ------------------------------------------------------------------------
  // Constructores de la clase
  // ------------------------------------------------------------------------
  // Constructor con tres parámetros
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

  // Constructor por defecto.
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

  // ------------------------------------------------------------------------
  // Getters (consultan el estado del objeto)
  // ------------------------------------------------------------------------
  public String getNombreBarco() {
    return this.nombre;
  }

  public int getNumMastiles() {
    return this.numMastiles;
  }

  public int getMaxTripulantes() {
    return this.maxTripulantes;
  }

  // ------------------------------------------------------------------------
  //Getters que consultan el estado en un momento dado
  // ------------------------------------------------------------------------
  public boolean isNavegando() {
    return this.isNavegando;
  }

  public double getTiempoTotalNavegacionBarco() {
    return this.tiempoTotalDeNavegacion;
  }

  public int getVelocidad() {
    return this.velocidad;
  }

  public String getRumbo() {
    return this.rumbo;
  }

  public String getPatron() {
    return this.nombreDelPatron;
  }

  public int getTripulacion() {
    return this.numDeTripulantes;
  }

  // ------------------------------------------------------------------------
  // Métodos getter estáticos (acceden a los atributos estáticos de la clase)
  // ------------------------------------------------------------------------
  public static int getNumBarcos() {
    return Velero.numDeVelerosClase;
  }

  public static int getNumBarcosNavegando() {
    return Velero.numDeVelerosNavegandoClase;
  }

  public static double getTiempoTotalNavegacion() {
    return Velero.tiempoTotalDeNavegacionClase;
  }
  // ------------------------------------------------------------------------
  // Setters (modifican el estado del objeto)
  // ------------------------------------------------------------------------
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
  @Override
  public String toString() {
    return String.format("{ Nombre del barco: %s, Número de mástiles: %d, Tripulación: %d, Navegando: %s, Tiempo total de navegación del barco: %.2f horas }", 
            this.nombre, this.numMastiles, this.numDeTripulantes, 
            !this.isNavegando ? "No" : String.format("Si, con el patrón %s en %s a %d nudos,", 
            this.nombreDelPatron, this.rumbo, this.velocidad), this.tiempoTotalDeNavegacion / 60);
  }
  
}
