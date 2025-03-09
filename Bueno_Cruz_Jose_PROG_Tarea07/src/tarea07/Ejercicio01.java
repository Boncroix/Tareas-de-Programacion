package tarea07;

import java.util.*;

/**
 * Ejercicio 1. Creando conjuntos de ciclos DAW y DAM con sus módulos
 *
 * @author José Bueno Cruz
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {
        
        System.out.println("CONJUNTOS DE MÓDULOS DE DAW Y DAM");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Inicializamos los arrays que vamos a utilizar
        String[] arrayModulosDAM = Utilidades.getArrayModulosDAM();
        String[] arrayModulosDAW = Utilidades.getArrayModulosDAW();

        // Inicialimando y rellenamos las colecciones que vamos autilizar
        // Al usar conjuntos (Set) garantizamos que no se pueden repetir elementos
        Set<String> modulosDAM = new HashSet<>(Arrays.asList(arrayModulosDAM));
        Set<String> modulosDAW = new HashSet<>(Arrays.asList(arrayModulosDAW));

        // Unión de los dos conjuntos
        Set<String> union = new HashSet<>(modulosDAM);
        union.addAll(modulosDAW);

        // Intersección de los conjuntos
        Set<String> interseccion = new HashSet<>(modulosDAM);
        interseccion.retainAll(modulosDAW);

        // Diferencia de los conjuntos
        Set<String> diferencia = new HashSet<>(modulosDAM);
        diferencia.removeAll(modulosDAW);

        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        // Recorremos los conjuntos y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1 (módulos DAW):\n");
        Utilidades.mostrarModulos(modulosDAW);
        
        System.out.printf("\nConjunto C2 (módulos DAM):\n");
        Utilidades.mostrarModulos(modulosDAM);
        
        System.out.printf("\nUnión C1 y C2:\n");
        Utilidades.mostrarModulos(union);
        
        System.out.printf("\nInterseccion C1 y C2:\n");
        Utilidades.mostrarModulos(interseccion);
        
        System.out.printf("\nDiferencia C1 y C2:\n");
        Utilidades.mostrarModulos(diferencia);
    }

}
