package tarea06;

/**
 * 
 * @author José Bueno Cruz
 */
public interface Navegable {
    void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes);
    void pararNavegacion(int tiempoNavegacion);
}
