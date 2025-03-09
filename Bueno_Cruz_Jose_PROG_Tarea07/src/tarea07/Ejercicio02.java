package tarea07;

import java.util.*;

/**
 * Ejercicio 2. Trabajando con listas de módulos
 *
 * @author José Bueno Cruz
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        System.out.println("LISTAS DE MÓDULOS");
        System.out.println("-----------------------------");

        // Inicializamos los arrays que vamos a utilizar
        String[] arrayModulosDAM = Utilidades.getArrayModulosDAM();
        String[] arrayModulosDAW = Utilidades.getArrayModulosDAW();

        // Instanciamos e inicializamos las colecciones para trabajar con ellas
        List<String> modulosDAM = new ArrayList<>(Arrays.asList(arrayModulosDAM));
        List<String> modulosDAW = new ArrayList<>(Arrays.asList(arrayModulosDAW));

        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        //Instanciamos las variables necesarias
        List<String> modulosmatriculadosList = new ArrayList<>();
        Set<String> modulosMatriculadosSet = new HashSet<>();
        Iterator<String> iterDAW = modulosDAW.iterator();

        System.out.println();
        System.out.printf("Contenido inicial de la lista de módulos de DAW:  \n");
        Utilidades.mostrarModulos(modulosDAW);

        System.out.println();
        System.out.printf("Contenido inicial de la lista de módulos de DAM:  \n");
        Utilidades.mostrarModulos(modulosDAM);

        // Recorremos la lista de modulos de DAW
        int index = 0;
        while (iterDAW.hasNext()) {
            String elemento = iterDAW.next();
            if (!elemento.contains("i")) {
                modulosMatriculadosSet.add(elemento);
                modulosmatriculadosList.add(elemento);
                elemento = "**" + elemento + "**";
                modulosDAW.set(index, elemento);
            }
            index++;
        }

        // Ordenación de la lista por nombre del módulo (alfabético) y la mostramos por pantalla
        System.out.println();
        System.out.printf("Ordenación de la lista de módulos de DAM por nombre (alfabético):\n");
        Collections.sort(modulosDAM, new ComparadorModuloPorNombre());
        Utilidades.mostrarModulos(modulosDAM);

        // Ordenación de la lista por código del módulo y la mostramos por pantalla
        System.out.println();
        System.out.printf("Ordenación de la lista de módulos de DAM por código:\n");
        Collections.sort(modulosDAM, new ComparadorModuloPorCodigo());
        Utilidades.mostrarModulos(modulosDAM);

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.println();
        System.out.printf("Contenido final de la lista de módulos de DAW:  \n");
        Utilidades.mostrarModulos(modulosDAW);

        System.out.println();
        System.out.printf("Contenido final de la lista de módulos matriculados (DAW): \n");
        Utilidades.mostrarModulos(modulosmatriculadosList);

        System.out.println();
        System.out.printf("Contenido final del conjunto de módulos matriculados (DAW): \n");
        Utilidades.mostrarModulos(modulosMatriculadosSet);

    }

}

/**
 * Clase que permite comparar dos módulos usando como criterio de comparación su
 * nombre. Se trata de una comparación alfabética.
 *
 * @author José Bueno Cruz
 */
class ComparadorModuloPorNombre implements Comparator<String> {

    @Override
    public int compare(String modulo1, String modulo2) {

        String nombre1 = modulo1.split("-")[1];
        String nombre2 = modulo2.split("-")[1];

        return nombre1.compareTo(nombre2);

    }

}

/**
 * Clase que permite comparar dos módulos usando como criterio de comparación su
 * código.
 *
 * @author José bueno Cruz
 */
class ComparadorModuloPorCodigo implements Comparator<String> {

    @Override
    public int compare(String modulo1, String modulo2) {
        
        String codigo1 = modulo1.split("-")[0];
        String codigo2 = modulo2.split("-")[0];

        return codigo1.compareTo(codigo2);
        
    }

}

