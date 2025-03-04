package tarea06;

// ------------------------------------------------------------
//                   Clase Velero
// ------------------------------------------------------------
/**
 * @author nombre_apellidos_Alumno
 */
public final class Velero extends Embarcacion implements Regateable{

    // Atributos estáticos públicos (inmutables)
    public static final int MIN_MASTILES = 1;
    public static final int MAX_MASTILES = 4;
    public static final int MIN_VELOCIDAD_VELERO = 2;
    public static final int MAX_VELOCIDAD_VELERO = 30;

    // Atributos estáticos privados (mutables)
    private static int numVeleros;
    
    // Atributos de objeto inmutables (privados)
    private final int numMastiles;
    
    // Atributos de objeto variables (privados)
    
  

    // ------------------------------------------------------------------------
    // Constructores de la clase
    // ------------------------------------------------------------------------

    public Velero(String nombre, int numMastiles, int numMaxTripulantes) {
        
        super(nombre, numMaxTripulantes);
        
        if (numMastiles < Velero.MIN_MASTILES || numMastiles > Velero.MAX_MASTILES) {
            throw new IllegalArgumentException(String.format("El número de mástiles debe estar entre %d y %d.", Velero.MIN_MASTILES, Velero.MAX_MASTILES));
        }
        
        this.numMastiles = numMastiles;
        Velero.numVeleros++;
    }
    
    public Velero(){
        
        this("Velero " + Velero.numVeleros, Velero.MIN_MASTILES, Embarcacion.MIN_TRIPULANTES);
        
    }
    
    // ------------------------------------------------------------------------
    // Getters (consultan el estado del objeto)
    // ------------------------------------------------------------------------
    
    /**
     * @return the numMastiles
     */
    public int getNumMastiles() {
        return numMastiles;
    }

    // ------------------------------------------------------------------------
    // Métodos estáticos (acceden a los atributos estáticos de la clase)
    // ------------------------------------------------------------------------
    
    /**
     * @return the numVeleros
     */
    public static int getNumVeleros() {
        return numVeleros;
    }

    // ------------------------------------------------------------------------
    // Setters (modifican el estado del objeto)
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public void setRumbo(String nuevoRumbo){
        
        if (nuevoRumbo == null) {
            throw new NullPointerException("El rumbo no puede ser nulo, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.");
        }
        
        if (!nuevoRumbo.equalsIgnoreCase("Ceñida") &&
                !nuevoRumbo.equalsIgnoreCase("empopada")){
            throw new IllegalArgumentException("El rumbo no es correcto, debes indicar el rumbo (ceñida o empopada) para poder modificarlo.");
        }
            
        super.setRumbo(nuevoRumbo);
        
    }
    
    @Override
    public void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes){
        
        if (velocidad < Velero.MIN_VELOCIDAD_VELERO || velocidad > Velero.MAX_VELOCIDAD_VELERO) {
            throw  new IllegalArgumentException(String.format("La velocidad de navegación de %d nudos es incorrecta.", velocidad));
        }
        
        super.iniciarNavegacion(velocidad, rumbo, patron, numTripulantes);
    }
    
    @Override
    public String iniciarRegata(Velero oponente) {
        
        if (oponente == null) {
            throw new NullPointerException("El barco con el que se intenta regatear no existe");
        }
        
        if (!oponente.isNavegando() || !this.isNavegando()) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, el barco %s no está navegando.",
                    !oponente.isNavegando() ? oponente.getNombreBarco() : this.getNombreBarco()));
        }
        
        if (!oponente.getRumbo().equals(this.getRumbo())) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, los barcos %s y %s deben navegar con el mismo rumbo.", oponente.getNombreBarco(), this.getNombreBarco()));
        }
        
        if (oponente.numMastiles != this.numMastiles) {
            throw new IllegalStateException(String.format("No se puede iniciar la regata, los barcos %d y %d no tienen el mismo numero de mástiles.", oponente.getNumMastiles(), this.getNumMastiles()));
        }
        
        String salida;
        if (this.velocidadBarco == oponente.velocidadBarco) {
            salida = String.format("Los barcos %s y %s han llegado a la vez a la línea de llegada.", this.getNombreBarco(), oponente.getNombreBarco());
        } else {
            salida = String.format("El barco %s ha llegado antes a la línea de llegada.", (this.velocidadBarco > oponente.velocidadBarco) ? this.getNombreBarco() : oponente.getNombreBarco());
        }

         return salida;
           
    }

    // ------------------------------------------------------------------------
    // Método Abstracto sobreecrito
    // ------------------------------------------------------------------------
    
    @Override
    public void señalizar() {
        System.out.printf("AVISO del velero %s con banderas de señalización marítima.", this.getNombreBarco());
    }
    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public String toString(){
        return super.toString() + String.format(", Numero de mástiles: %d.", this.numMastiles);
    }

}
