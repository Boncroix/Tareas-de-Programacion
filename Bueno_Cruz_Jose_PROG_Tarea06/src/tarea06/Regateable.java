package tarea06;

/**
 * Interfaz que define el comportamiento de una embarcación que puede participar en regatas.
 * 
 * <p>Las clases que implementen esta interfaz deben proporcionar una implementación 
 * del método para iniciar una regata contra otro velero.</p>
 * 
 * @author José Bueno Cruz
 */
public interface Regateable {
    
    /**
     * Inicia una regata contra otra embarcación de tipo {@link Velero}.
     * 
     * @param oponente El velero con el que se realizará la regata.
     * @return Un mensaje indicando el resultado o el estado de la regata.
     */
    String iniciarRegata(Velero oponente);
    
}

