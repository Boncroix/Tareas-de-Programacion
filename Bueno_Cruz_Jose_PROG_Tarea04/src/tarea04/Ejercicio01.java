/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea04;

import java.util.Scanner;

/**
 * Ejercicio 1. Comprimir cadenas.
 *
 * @author José Bueno Cruz
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        String PATRON = "[A-Za-z]+";

        // Variables de entrada
        String entrada;

        // Variables de salida
        String salida = "";

        // Variables auxiliares
        boolean entradaCorrecta = false;
        int contador = 1;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("-------------------------------------------------");
        System.out.println("         Ejercicio 1. Comprimir cadenas.         ");
        System.out.println("-------------------------------------------------");

        // Bucle entrada correcta de datos según el patrón "[A-Za-z]+"
        do {
            System.out.print("Escribe una cadena de texto: ");
            entrada = teclado.nextLine();
            if (entrada.matches(PATRON)) {
                entradaCorrecta = true;
            } else {
                System.err.println("\n-------------------------------------------------");
                System.err.println("     Error: ingresa solo Letras A-z, sin la Ñ.   ");
                System.err.println("-------------------------------------------------");
            }
        } while (!entradaCorrecta);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Bucle comprobación de letras repetidas
        for (int i = 0; i < entrada.length(); i++) {
            if (i + 1 < entrada.length() && entrada.charAt(i) == entrada.charAt(i + 1)) {
                contador++;
            } else {
                salida += entrada.charAt(i);
                if (contador > 1) {
                    salida += contador;
                }
                contador = 1;
            }
        }

        //----------------------------------------------
        //              Salida de resultados
        //----------------------------------------------
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("                    RESULTADO                    ");
        System.out.println("-------------------------------------------------");
        System.out.printf("Cadena comprimida: %s\n\n", (entrada.length() == salida.length()) ? entrada : salida);
    }
}
