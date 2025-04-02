package ejercicio1;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Ejercicio 1: Lectura/escritura de una biblioteca de libros en ficheros de texto.
 *
 * @author Bueno Cruz Jos�
 */
public class Ejercicio1 {

    /**
     * M�todo principal.
     *
     * @param args argumentos que recibe el m�todo
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
        // Leemos el archivo "ListadoLibros.txt" que contiene la informaci�n de los libros
        System.out.println("Abriendo archivo de libros...");
        // Definimos la ruta del archivo de entrada
        rutaFichero = System.getProperty("user.dir") + "/recursos/ListadoLibros.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))){
            
            String linea; 
            // Leemos cada l�nea del archivo
            while ((linea = br.readLine()) != null) {  
                // Dividimos la l�nea usando el delimitador ";"
                atributos = linea.split(";");
                String titulo = atributos[0];
                String autor = atributos[1];
                String fechaCreacionStr = atributos[2];
                // Parseamos la fecha de creaci�n
                LocalDate fechaCreacion = LocalDate.parse(fechaCreacionStr, DateTimeFormatter.ISO_LOCAL_DATE);
                String genero = atributos[3];
                // Creamos una lista con los cap�tulos, separando por comas
                List<String> capitulos = Arrays.asList(atributos[4].split(","));
                // Creamos un objeto 'Libro' y lo a�adimos a la 'biblioteca'
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
        
        // Ahora generamos el archivo "biblioteca.txt" con la informaci�n de la biblioteca
        System.out.println("Abriendo archivo de la biblioteca...");
        // Definimos la ruta del archivo de salida
        rutaFichero = System.getProperty("user.dir") + "/recursos/biblioteca.txt";
        // Obtenemos la representaci�n en cadena de la biblioteca
        String toString = biblioteca.toString();
        
        try (OutputStreamWriter fichero = new OutputStreamWriter(new FileOutputStream(rutaFichero), "UTF-8")) {
            // Escribimos un encabezado en el archivo
            fichero.write("**********************************************************************************************\n"); 
            fichero.write("LIBRO DE LIBROS \n"); 
            fichero.write("**********************************************************************************************\n"); 
            // Dividimos el string resultante de la biblioteca en l�neas
            String[] lineas = toString.split("\n");
            // Recorremos cada l�nea para escribir la informaci�n de cada libro
            for (String linea : lineas) {
                // Dividimos la l�nea usando el delimitador ","
                atributos = linea.split(";");
                // Escribimos los detalles de cada libro en el archivo
                fichero.write("TITULO DEL LIBRO:" + atributos[0] + "\n"); 
                fichero.write("AUTOR:" + atributos[1] + "\n"); 
                fichero.write("FECHA DE CREACI�N:" + atributos[2] + "\n"); 
                fichero.write("GENERO:" + atributos[3] + "\n"); 
                fichero.write("CAPITULOS:" + atributos[4] + "\n");
                fichero.write("**********************************************************************************************\n");
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
