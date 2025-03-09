package tarea07;

import java.util.*;

/**
 * Ejercicio 3. Mapa de Ciclos y sus módulos
 *
 * @author José Bueno Cruz
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        System.out.println("CÓDIGOS DE LOS MÓDULOS DE DAW POR CURSOS");
        System.out.println("----------------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Instanciamos las variables con las que vamos a trabajar
        String[] arrayCodigosModulosDAW = Utilidades.getArrayCodigosModulosDAW();
        List<String> modulosDAW = new ArrayList<>(Arrays.asList(arrayCodigosModulosDAW));
        Map<Integer, List<Integer>> mapCodigosPorCurso = new HashMap<>();

        // Recorremos la lista de códigos del ciclo de DAW (curso-codigo de modulo)
        for (String elemento : modulosDAW) {
            int curso = Integer.parseInt(elemento.split("-")[0]);
            int codigoModulo = Integer.parseInt(elemento.split("-")[1]);
            // insertamos en el mapa los datos
            mapCodigosPorCurso.putIfAbsent(curso, new ArrayList<>());
            mapCodigosPorCurso.get(curso).add(codigoModulo);
        }

        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido del mapa de códigos de módulos organizados por cursos:\n\n");
        for (int curso : mapCodigosPorCurso.keySet()) {
            System.out.printf("Modulos de %dº curso: %s\n", curso, mapCodigosPorCurso.get(curso));
        }
    }
}
