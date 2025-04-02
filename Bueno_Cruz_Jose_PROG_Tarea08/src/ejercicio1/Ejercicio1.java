package ejercicio1;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Ejercicio 1: Lectura/escritura de una biblioteca de libros en ficheros de texto.
 *
 * @author apellidos y nombre del alumno
 */
public class Ejercicio1 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaracion de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        // Variables auxiliares
        Biblioteca biblioteca = new Biblioteca();

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Abrimos archivo de contactos ListadoLibros.txt
        System.out.println("Abriendo archivo de libros...");
        
        
        String rutaFichero = System.getProperty("user.dir") + "/recursos/ListadoLibros.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atributos = linea.split(";");
                String titulo = atributos[0];
                String autor = atributos[1];
                String fechaCreacionStr = atributos[2];
                LocalDate fechaCreacion = LocalDate.parse(fechaCreacionStr, DateTimeFormatter.ISO_LOCAL_DATE);
                String genero = atributos[3];
                String[] capitulosArray = atributos[4].split(",");
                
                List<String> capitulos = new ArrayList<>();
                capitulos.addAll(Arrays.asList(capitulosArray));
                
                Libro libro = new Libro(titulo, autor, fechaCreacion, capitulos, genero);
                
                biblioteca.add(libro);
                
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        
        

        System.out.println("Cerrando archivo de libros...");

        System.out.println();

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
            // Abrimos el archivo de la Biblioteca de libros Biblioteca.txt
            System.out.println("Abriendo archivo de la biblioteca...");

           

            System.out.println("Cerrando archivo de la biblioteca...");

            System.out.println();
            System.out.println("Archivos cerrados y procesamiento finalizado");
            System.out.println("---------");
            System.out.println();
            System.out.println("Fin del programa.");
    }
}
