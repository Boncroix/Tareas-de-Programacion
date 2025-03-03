package tarea06;

// ------------------------------------------------------------
//                   Clase Velero
// ------------------------------------------------------------
/**
 * @author nombre_apellidos_Alumno
 */
public final class Velero extends Embarcacion implements Regateable{

    // ------------------------------------------------------------------------
    // Atributos de la clase
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Constructores de la clase
    // ------------------------------------------------------------------------

    public Velero(String nombre, int numMaxTripulantes) {
        super(nombre, numMaxTripulantes);
    }
    
    // ------------------------------------------------------------------------
    // Getters (consultan el estado del objeto)
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Métodos estáticos (acceden a los atributos estáticos de la clase)
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Setters (modifican el estado del objeto)
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // Métodos de "acción" (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------
    
    @Override
    public String iniciarRegata(Velero oponente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // ------------------------------------------------------------------------
    // Método Abstracto sobreecrito
    // ------------------------------------------------------------------------
    
    @Override
    public void señalizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------

}
