package tarea07;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Ejercicio 1. Creando conjuntos de ciclos DAW y DAM con sus módulos
 * @author 
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes

        // Variables de entrada

        // Variables auxiliares

                
        // Variables de salida

     
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        // No hay entrada de datos, pues se usa un número fijo de elementos
        
        System.out.println("CONJUNTOS DE MÓDULOS DE DAW Y DAM");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Inicializamos los arrays que vamos a utilizar
        String[] arrayModulosDAM = Utilidades.getArrayModulosDAM();
        String[] arrayModulosDAW = Utilidades.getArrayModulosDAW();

        
        // Inicialimando las colecciones que vamos autilizar
        // Al usar conjuntos (Set) garantizamos que no se pueden repetir elementos
        Set<String> modulosDAM = new HashSet<>();
        Set<String> modulosDAW = new HashSet<>();
        
        
        // Rellenamos los conjuntos de los ciclos con sus módulos correspondientes
        for (String modulo : arrayModulosDAM) {
            if (!modulosDAM.add(modulo)) {
                System.out.printf("No se pudo añadir. El módulo %s ya está en la lista", modulo);
            }
        }
        
        for (String modulo : arrayModulosDAW) {
            if (!modulosDAW.add(modulo)) {
                System.out.printf("No se pudo añadir. El módulo %s ya está en la lista", modulo);
            }
        }
       

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
        
        System.out.printf ("Conjunto C1 (módulos DAW):\n");
        int index = 1;
        for (String modulo : modulosDAW) {
            System.out.printf("%d. %s\n", index, modulo);
            index++;
        }


        System.out.printf ("\nConjunto C2 (módulos DAM):\n");
        index = 1;
        for (String modulo : modulosDAM) {
            System.out.printf("%d. %s\n", index, modulo);
            index++;
        }

        
        System.out.printf ("\nUnión C1 y C2:\n");
        index = 1;
        for (String modulo : union) {
            System.out.printf("%d. %s\n", index, modulo);
            index++;
        }

        
        System.out.printf ("\nInterseccion C1 y C2:\n");
        index = 1;
        for (String modulo : interseccion) {
            System.out.printf("%d. %s\n", index, modulo);
            index++;
        }
        
        System.out.printf ("\nDiferencia C1 y C2:\n");
        index = 1;
        for (String modulo : diferencia) {
            System.out.printf("%d. %s\n", index, modulo);
            index++;
        }
    }
}