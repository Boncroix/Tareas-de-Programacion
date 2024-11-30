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
        int PAGAS = 14;
        
        // Variables de entrada
        int seleccionUsuario = 0;
        int antiguedad = 0;
                
        // Variables de salida
        float[] sueldos = new float[NUMERO_EMPLEADOS];
        float sueldoAnual;
        float sueldoMensual;
        
        //Variables auxiliares
        boolean salir = false;
               
        // Clase Scanner para petición de datos de entrada2
        Scanner teclado = new Scanner(System.in);

        // Enunciado del ejercicio
        System.out.println("[------------------------------------------------------------------]");
        System.out.println("[--------------- Ejercicio2: Sueldos de Empleados -----------------]");
        System.out.println("[------------------------------------------------------------------]");      

        // Bucle repetitivo hasta que el usuario seleccione salir
        while (!salir) {
            // Bucle entrada y validación de datos
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("1. Calcular el sueldo de los empleados en función de su antigüedad");
                System.out.println("2. Calcular el coste anual y mensual de un empleado nuevo");
                System.out.println("3. Salir");
                System.out.print("Elegir una opción: ");
                // Comprobar que la entrada de datos es un número entero
                try {
                    seleccionUsuario= teclado.nextInt();
                    entradaValida = true;
                } catch (Exception e) {
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[- Error en la entrada de datos, debe introducir un número entero -]");
                    System.out.println("[------------------------------------------------------------------]\n");
                    teclado.next();
                }
            }
            // Switch según selección del usuario
            switch (seleccionUsuario) {
                // Opción 1
                case 1:
                    System.out.println();
                    // Bucle para calcular sueldo para cada uno de los empleados
                    for (int i = 0; i < NUMERO_EMPLEADOS; i++) {
                        // Bucle entrada y validación de datos
                        entradaValida = false;
                        while (!entradaValida) {
                            System.out.printf("Introducir antigüedad empleado %d: ", i + 1);
                            try {
                                antiguedad= teclado.nextInt();
                                entradaValida = true;
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("[------------------------------------------------------------------]");
                                System.out.println("[- Error en la entrada de datos, debe introducir un número entero -]");
                                System.out.println("[------------------------------------------------------------------]\n");
                                teclado.next();
                            }       
                        }
                        // Calculo plus más de 5 años trabajados, opción 1
                        sueldos[i] = antiguedad > 5 ? 
                                SUELDO_BASE + EXTRA_MAS_5A : SUELDO_BASE + EXTRA_MENOS_5A;
                        // Calculo plus por año trabajado, opción 1
                        sueldos[i] += antiguedad * PLUS_X_AÑO;
                    }
  
                    // Resultado para opción 1
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[--------------------------- RESULTADO ----------------------------]");
                    System.out.println("[------------------------------------------------------------------]");
                    for (int i = 0; i < NUMERO_EMPLEADOS; i++) {
                        System.out.printf("Sueldo empleado %d ----------------------------------- %,.2f Euros\n",(i + 1), sueldos[i]);
                    }
                    System.out.println();
                    break;
                // Opción 2
                case 2:
                    // Calculo sueldo anual y sueldo mensual, opción 2
                    sueldoAnual = SUELDO_BASE * PAGAS;
                    sueldoMensual = sueldoAnual / 12;
                    // Resultado opción 2
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[--------------------------- RESULTADO ----------------------------]");
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.printf("Sueldo  anual  nueva incorporación: ---------------- %,.2f Euros\n",sueldoAnual);
                    System.out.printf("Sueldo mensual nueva incorporación: ----------------- %,.2f Euros\n",sueldoMensual);
                    System.out.println();
                    break;
                // Salir del programa, opción 3
                case 3:
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.println("[--------------------- Fin del programa. Bye! ---------------------]");
                    System.out.println("[------------------------------------------------------------------]");
                    salir = true;
                    break;
                // Opción por defecto, en caso de que la selección de usuario no coincida con ningún case.
                default:
                    System.out.println();
                    System.out.println("[------------------------------------------------------------------]");
                    System.out.printf("[----- Opción no válida debe introducir un número entre 1 y %d -----]\n", NUMERO_EMPLEADOS);
                    System.out.println("[------------------------------------------------------------------]\n");
            }
        }
    }                
}
