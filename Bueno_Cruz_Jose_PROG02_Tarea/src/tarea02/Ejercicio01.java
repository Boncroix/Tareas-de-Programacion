package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1. SUELDOS DE EMPLEADOS.
 *
 * @author José Bueno Cruz
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
        
        // Variables de entrada
        int seleccionUsuario = 0;
        int antiguedad;
        
        // Variables de salida
        float[] sueldos;
        
        // Variables auxiliares
        boolean salir = false;
       
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println("---------------- Ejercicio2: Sueldos de Empleados ------------------");
        System.out.println("--------------------------------------------------------------------");
        
        
        while (!salir) {
            // Entrada y verificación de datos de entrada.
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("1. Calcular el sueldo de los empleados en función de su antigüedad");
                System.out.println("2. Calcular el coste anual y mensual de un empleado nuevo");
                System.out.println("3. Salir");
                System.out.print("Elegir una opción: ");

                if (teclado.hasNextInt()) {
                    seleccionUsuario= teclado.nextInt();
                    entradaValida = true;
                } else {
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("-- Error en la entrada de datos, debe introducir un número entero --");
                    System.out.println("--------------------------------------------------------------------\n");
                    teclado.next();
                }
            }
            
            switch (seleccionUsuario) {
                case 1:
                    int contador = 1;
                    while (contador < NUMERO_EMPLEADOS + 1) {
                        // Calcular sueldo en función de su antiguedad
                        System.out.print("Introducir antigüedad empleado "+ contador +": ");
                        antiguedad= teclado.nextInt();
                        contador += 1;
                        // Plus quinquenio
                        sueldos[contador] = antiguedad > 5 ? 
                                SUELDO_BASE + EXTRA_MAS_5A : SUELDO_BASE + EXTRA_MENOS_5A;
                        // Plus por año trabajado
                        sueldos[contador] += antiguedad * PLUS_X_AÑO;
                    }
                    break;
                case 2:
                    System.out.println("Opción no 2.");
                    break;
                case 3:
                    // Salir del programa
                    salir = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("------ Opción no válida debe introducir un número entre 1 y 3 ------");
                    System.out.println("--------------------------------------------------------------------\n");
            }
            //----------------------------------------------
            //              Salida de resultados 
            //----------------------------------------------
            System.out.println();
            System.out.println("           RESULTADO            ");
            System.out.println("--------------------------------");
        }  
        System.out.println ();
        System.out.println ("Fin del programa. Bye!");
        System.out.println ();
    }
}

