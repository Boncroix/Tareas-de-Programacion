package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1. SUELDOS DE EMPLEADOS.
 *
 * @author Indica el nombre del alumno/a
 */
public class Ejercicio01 {   
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        int NUMERO_EMPLEADOS = 3;
        int EXTRA_MAS_5A = 100;
        int EXTRA_MENOS_5A = 20;
        int PLUS_X_AÑO = 50;
        int SUELDO_BASE = 1500;
        int PAGAS = 14;
        
        // Variables de entrada
        int seleccionUsuario = 0;
        int antiguedad = 0;
                
        // Variables de salida
        double[] sueldos = new double[NUMERO_EMPLEADOS];
        
        //Variables auxiliares
        boolean salir = false;
        double sueldoAnual;
        double sueldoMensual;
               
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        System.out.println("[------------------------------------------------------------------]");
        System.out.println("[--------------- Ejercicio2: Sueldos de Empleados -----------------]");
        System.out.println("[------------------------------------------------------------------]");      

        // Bucle hasta selección de opción salir
        while (!salir) {
            // Entrada de datos
            boolean entradaValida = false;
            // Bucle validación entrada de datos
            while (!entradaValida) {
                System.out.println();
                System.out.println("1. Calcular el sueldo de los empleados en función de su antigüedad");
                System.out.println("2. Calcular el coste anual y mensual de un empleado nuevo");
                System.out.println("3. Salir");
                System.out.print("Elegir una opción: ");
                // Comprobar que la entrada de datos es un número entero
                if (teclado.hasNextInt()) {
                    seleccionUsuario= teclado.nextInt();
                    entradaValida = true;
                } else {
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[- Error en la entrada de datos, debe introducir un número entero -]");
                    System.out.println("[------------------------------------------------------------------]\n");
                    teclado.next();
                }
            }
            // Switch de la selección del usuario
            switch (seleccionUsuario) {
                case 1:
                    System.out.println();
                    // Bucle para calcular sueldo para cada uno de los empleados
                    for (int i = 0; i < NUMERO_EMPLEADOS; i++) {
                        // Entrada de datos
                        entradaValida = false;
                        // Bucle validación entrada de datos
                        while (!entradaValida) {
                            System.out.print("Introducir antigüedad empleado "+ (i + 1) +": ");
                            // Comprobar que la entrada de datos es un número entero
                            if (teclado.hasNextInt()) {
                                antiguedad= teclado.nextInt();
                                entradaValida = true;
                            } else {
                                System.out.println();
                                System.out.println("[------------------------------------------------------------------]");
                                System.out.println("[- Error en la entrada de datos, debe introducir un número entero -]");
                                System.out.println("[------------------------------------------------------------------]\n");
                                teclado.next();
                            }
                        }
                        // Calculo plus si el trabajador lleva más de 5 años trabajados
                        sueldos[i] = antiguedad > 5 ? 
                                SUELDO_BASE + EXTRA_MAS_5A : SUELDO_BASE + EXTRA_MENOS_5A;
                        // Calculo plus por año trabajado
                        sueldos[i] += antiguedad * PLUS_X_AÑO;
                    }
  
                    // Resultado para opción 1
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[--------------------------- RESULTADO ----------------------------]");
                    System.out.println("[------------------------------------------------------------------]");
                    for (int i = 0; i < NUMERO_EMPLEADOS; i++) {
                        System.out.println("Sueldo empleado" + (i + 1) + ": -------------------------------------- " + sueldos[i] + " Euros");
                    }
                    break;
                case 2:
                    // Calculo sueldo anual y sueldo mensual para la opción 2
                    sueldoAnual = SUELDO_BASE * PAGAS;
                    sueldoMensual = sueldoAnual / 12;
                    
                    // Resultado opción 2
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[--------------------------- RESULTADO ----------------------------]");
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("Sueldo anual para un empleado recien incorporado: ----- " + sueldoAnual + " Euros");
                    System.out.println("Sueldo mensual para un empleado recien incorporado: ---- " + sueldoMensual + " Euros");
                    break;
                case 3:
                    // Salir del programa opción 3
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[--------------------- Fin del programa. Bye! ---------------------]");
                    System.out.println("[------------------------------------------------------------------]\n");
                    salir = true;
                    break;
                default:
                    // Opción por defecto, en caso de que la selección de usuario no coincida con ninguna opción.
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[----- Opción no válida debe introducir un número entre 1 y 3 -----]");
                    System.out.println("[------------------------------------------------------------------]\n");
            }
        }
    }                
}
