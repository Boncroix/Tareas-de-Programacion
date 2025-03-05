package tarea06;

// ------------------------------------------------------------
//                   Clase Lancha
// ------------------------------------------------------------
/**
 * @author José Bueno Cruz
 */
public final class Lancha extends Embarcacion {
    
    // Atributos estáticos públicos (inmutables)
    public static final int MIN_MOTORES = 1;
    public static final int MAX_MOTORES = 2;
    public static final int MIN_COMBUSTIBLE = 8;
    public static final int MAX_COMBUSTIBLE = 50;
    public static final double FACTOR_COMBUSTIBLE = 0.026;
    public static final int MIN_VELOCIDAD_LANCHA = 1;
    public static final int MAX_VELOCIDAD_LANCHA = 50;

    // Atributos estáticos privados (mutables)
    private static int numDeLanchas;
    
    // Atributos de objeto inmutables (privados)
    private final int numMotores;
    
    // Atributos de objeto variables (privados)
    private int nivelCombustible;
    
    
    // ------------------------------------------------------------------------
    // Constructores de la clase
    // ------------------------------------------------------------------------

    public Lancha(String nombre, int numMotores, int nivelCombustible, int numMaxTripulantes) throws IllegalArgumentException {
        
        super(nombre, numMaxTripulantes);
        
        if (numMotores < Lancha.MIN_MOTORES || numMotores > Lancha.MAX_MOTORES) {
            throw new IllegalArgumentException(String.format("El número de motores debe estar entre %d y %d.\n", Lancha.MIN_MOTORES, Lancha.MAX_MOTORES));
        }
        
        if (nivelCombustible < Lancha.MIN_COMBUSTIBLE || nivelCombustible > Lancha.MAX_COMBUSTIBLE) {
            throw new IllegalArgumentException(String.format("El nivel de combustible debe estar entre %d y %d.\n", Lancha.MIN_COMBUSTIBLE, Lancha.MAX_MOTORES));
        }
        
        this.numMotores = numMotores;
        this.nivelCombustible = nivelCombustible;
        Lancha.numDeLanchas++;
          
    }
    
    public Lancha() {
        
        this("Lancha " + Lancha.numDeLanchas, Lancha.MAX_MOTORES, Lancha.MAX_COMBUSTIBLE, Embarcacion.MIN_TRIPULANTES);
        
    }
    
    
    
    // ------------------------------------------------------------------------
    // Getters (consultan el estado del objeto)
    // ------------------------------------------------------------------------
    
    /**
     * @return the numMotores
     */
    public int getNumMotores() {
        return numMotores;
    }

    /**
     * @return the nivelCombustible
     */
    public int getCantidadCombustible() {
        return nivelCombustible;
    }

    // ------------------------------------------------------------------------
    // Métodos estáticos (acceden a los atributos estáticos de la clase)
    // ------------------------------------------------------------------------

    /**
     * @return the numDeLanchas
     */
    public static int getNumLanchas() {
        return numDeLanchas;
    }
    
    // ------------------------------------------------------------------------
    // Setters (modifican el estado del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        
        if (this.nivelCombustible < Lancha.MIN_COMBUSTIBLE || this.nivelCombustible > Lancha.MAX_COMBUSTIBLE) {
            throw  new IllegalStateException(String.format("La lancha %s no tiene un nivel de combustible válido para iniciar la navegación (solo %d litros).\n", this.getNombreBarco(), this.nivelCombustible));
        }
        
        if (velocidad < Lancha.MIN_VELOCIDAD_LANCHA || velocidad > Lancha.MAX_VELOCIDAD_LANCHA) {
            throw  new IllegalArgumentException(String.format("La velocidad de navegación de %d nudos asignada a %s es incorrecta.\n", velocidad, this.getNombreBarco()));
        }
        
        super.iniciarNavegacion(velocidad, rumbo, patron, numTripulantes);
    }
    
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
    // Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public void setRumbo(String nuevoRumbo) throws IllegalStateException, IllegalArgumentException, NullPointerException{
        
        if (nuevoRumbo == null) {
            throw new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo (norte, sur, este u oeste) para poder modificarlo.\n");
        }
        
        if (!nuevoRumbo.equalsIgnoreCase("Norte") &&
                !nuevoRumbo.equalsIgnoreCase("Sur") &&
                !nuevoRumbo.equalsIgnoreCase("Este") &&
                !nuevoRumbo.equalsIgnoreCase("Oeste")){
            throw new IllegalArgumentException("El rumbo no es correcto, debes indicar el rumbo (norte, sur, este u oeste) para poder modificarlo.\n");
        }
            
        super.setRumbo(nuevoRumbo);
        
    }
    
    // ------------------------------------------------------------------------
    // Método Abstracto sobreecrito
    // ------------------------------------------------------------------------
    @Override
    public void señalizar() {
        System.out.printf("AVISO de señalización de la lancha %s con bocinas y luces intermitentes.", this.getNombreBarco());
    }
    
    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public String toString(){
        return super.toString() + String.format(", Numero de motores: %d, Nivel de combustible: %d.", this.numMotores, this.nivelCombustible);
                        
    }

    
}
