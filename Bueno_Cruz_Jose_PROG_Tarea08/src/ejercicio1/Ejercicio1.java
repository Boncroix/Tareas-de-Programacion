package ejercicio1;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Ejercicio 1: Lectura/escritura de una biblioteca de libros en ficheros de texto.
 *
 * @author Bueno Cruz José
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
        String rutaFichero;
        Biblioteca biblioteca = new Biblioteca();
        String[] atributos;

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Leemos el archivo "ListadoLibros.txt" que contiene la información de los libros
        System.out.println("Abriendo archivo de libros...");
        // Definimos la ruta del archivo de entrada
        rutaFichero = System.getProperty("user.dir") + "/recursos/ListadoLibros.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))){
            
            String linea; 
            // Leemos cada línea del archivo
            while ((linea = br.readLine()) != null) {  
                // Dividimos la línea usando el delimitador ";"
                atributos = linea.split(";");
                String titulo = atributos[0];
                String autor = atributos[1];
                String fechaCreacionStr = atributos[2];
                // Parseamos la fecha de creación
                LocalDate fechaCreacion = LocalDate.parse(fechaCreacionStr, DateTimeFormatter.ISO_LOCAL_DATE);
                String genero = atributos[3];
                // Creamos una lista con los capítulos, separando por comas
                List<String> capitulos = Arrays.asList(atributos[4].split(","));
                // Creamos un objeto 'Libro' y lo añadimos a la 'biblioteca'
                Libro libro = new Libro(titulo, autor, fechaCreacion, capitulos, genero);
                biblioteca.add(libro);
            }
            
        } catch (Exception e) {
            // En caso de error, imprimimos el mensaje correspondiente
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }

        System.out.println("Cerrando archivo de libros...");

        System.out.println();

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        // Ahora generamos el archivo "biblioteca.txt" con la información de la biblioteca
        System.out.println("Abriendo archivo de la biblioteca...");
        // Definimos la ruta del archivo de salida
        rutaFichero = System.getProperty("user.dir") + "/recursos/biblioteca.txt";
        // Obtenemos la representación en cadena de la biblioteca
        String toString = biblioteca.toString();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero))) {
            // Escribimos un encabezado en el archivo
            writer.write("**********************************************************************************************\n"); 
            writer.write("LIBRO DE LIBROS \n"); 
            writer.write("**********************************************************************************************\n"); 
            // Dividimos el string resultante de la biblioteca en líneas
            String[] lineas = toString.split("\n");
            // Recorremos cada línea para escribir la información de cada libro
            for (String linea : lineas) {
                // Dividimos la línea usando el delimitador ","
                atributos = linea.split(";");
                // Escribimos los detalles de cada libro en el archivo
                writer.write("TITULO DEL LIBRO:" + atributos[0] + "\n"); 
                writer.write("AUTOR:" + atributos[1] + "\n"); 
                writer.write("FECHA DE CREACION:" + atributos[2] + "\n"); 
                writer.write("GENERO:" + atributos[3] + "\n"); 
                writer.write("CAPITULOS:" + atributos[4] + "\n");
                writer.write("**********************************************************************************************\n");
            }

        } catch (IOException e) {
            // En caso de error, imprimimos el mensaje correspondiente
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }

        System.out.println("Cerrando archivo de la biblioteca...");

        System.out.println();
        System.out.println("Archivos cerrados y procesamiento finalizado");
        System.out.println("---------");
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
