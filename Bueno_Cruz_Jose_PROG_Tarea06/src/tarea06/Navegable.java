package tarea06;

/**
 * Interfaz que define el comportamiento de una embarcación
 * <strong>Navegable</strong>.
 *
 * <p>
 * Las clases que implementen esta interfaz deben proporcionar una
 * implementación para iniciar y detener la navegación, estableciendo parámetros
 * como velocidad, rumbo y tripulación.</p>
 *
 * @author José Bueno Cruz
 */
public interface Navegable {

    /**
     * Inicia la navegación de la embarcación con los parámetros especificados.
     *
     * @param velocidad La velocidad de navegación en nudos.
     * @param rumbo El rumbo de la embarcación.
     * @param patron El nombre del patrón a cargo de la embarcación.
     * @param numTripulantes Número de tripulantes a bordo.
     */
    void iniciarNavegacion(int velocidad, String rumbo, String patron, int numTripulantes);

    /**
     * Detiene la navegación de la embarcación después del tiempo especificado.
     *
     * @param tiempoNavegacion El tiempo de navegación en minutos antes de
     * detenerse.
     */
    void pararNavegacion(int tiempoNavegacion);
    
}
