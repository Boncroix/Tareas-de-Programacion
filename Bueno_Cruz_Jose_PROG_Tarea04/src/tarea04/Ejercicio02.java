/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea04;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Ejercicio 2. Rotar matrices cuadradas.
 *
 * @author José Bueno Cruz
 */
public class Ejercicio02 {

    // Variables auxiliares
    static StringTokenizer arrayEntrada;

    // Variables de salida
    static String[][] matriz;
    static String[][] matrizRotada;

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        String PATRON = "([A-Za-z0-9],?)*[A-Za-z0-9]";

        // Variables de entrada
        String entrada;

        // Variables auxiliares
        boolean entradaCorrecta;
        int dimensiónMatriz = 2; // Se establece la dimensión mínima de la matriz (2x2)

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("-----------------------------------------------------------");
        System.out.println("           Ejercicio 2. Rotar matrices cuadradas.          ");
        System.out.println("-----------------------------------------------------------");

        // Bucle para capturar la matriz según su dimensión
        for (int fila = 0; fila < dimensiónMatriz; fila++) {
            entradaCorrecta = false;

            // Bucle introducción de datos según patrón y dimensiones
            do {
                // Pedir fila de datos de la matriz
                System.out.printf("Introduce la fila %d de valores separados por comas: ", fila + 1);
                entrada = teclado.nextLine();

                // Verificar entrada de datos según patrón y dimensión de la matriz
                if (entrada.matches(PATRON)) {
                    arrayEntrada = new StringTokenizer(entrada, ",");
                    int tokens = arrayEntrada.countTokens();

                    // Verificar si la matriz es rotable, solo en la inserción de la primera fila
                    if (fila == 0 && tokens >= dimensiónMatriz) {
                        dimensiónMatriz = tokens;
                        matriz = new String[tokens][tokens];
                        matrizRotada = new String[tokens][tokens];
                        System.out.printf("Vamos a trabajar con una matriz de %d x %d\n", dimensiónMatriz, dimensiónMatriz);
                        entradaCorrecta = true;

                        // Verificar dimensión de la matriz según la ultima fila insertada
                    } else if (tokens == dimensiónMatriz) {
                        entradaCorrecta = true;

                        // Error si la dimensión no coincide   
                    } else {
                        System.err.println("-----------------------------------------------------------");
                        System.err.printf("%s Error: El tamaño de la matriz debe de ser %sde %d x %d \n",
                                fila == 0 ? "" : "   ", fila == 0 ? "mínimo " : "", dimensiónMatriz, dimensiónMatriz);
                        System.err.println("-----------------------------------------------------------");
                    }

                    // Error si el patrón de la expresión regular no se cumple 
                } else {
                    System.err.println("-----------------------------------------------------------");
                    System.err.println("        Error: La matriz tiene valores no validos.         ");
                    System.err.println("       Los únicos elementos permitidos en la matriz        ");
                    System.err.println("        son números y letras separados por comas.          ");
                    System.err.println("-----------------------------------------------------------");
                }

            } while (!entradaCorrecta);

            // Insertar datos en la matriz
            for (int columna = 0; columna < dimensiónMatriz; columna++) {
                matriz[fila][columna] = arrayEntrada.nextToken();
            }
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Leer datos de la matriz e insertarlos en la matriz rotada
        for (int fila = 0; fila < dimensiónMatriz; fila++) {
            for (int columna = 0; columna < dimensiónMatriz; columna++) {
                matrizRotada[columna][dimensiónMatriz - 1 - fila] = matriz[fila][columna];
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("                         Resultado                         ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Matriz Original: ");
        for (int fila = 0; fila < dimensiónMatriz; fila++) {
            for (int columna = 0; columna < dimensiónMatriz; columna++) {
                System.out.printf("%-20s   ", matriz[fila][columna]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matriz Rotada: ");
        for (int fila = 0; fila < dimensiónMatriz; fila++) {
            for (int columna = 0; columna < dimensiónMatriz; columna++) {
                System.out.printf("%-20s   ", matrizRotada[fila][columna]);
            }
            System.out.println();
        }
    }
}
