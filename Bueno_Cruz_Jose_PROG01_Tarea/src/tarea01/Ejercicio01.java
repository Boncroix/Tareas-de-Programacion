package tarea01;

import java.util.Scanner;

/**
 * Ejercicio 1. Cálculos aritméticos.
 *
 * @author josebuenocruz
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        double valorX, valorY, valorZ;
        
        // Variables de salida
        
        
        // Variables auxiliares
        enum Operaciones {OPERACION_1, OPERACION_2, OPERACION_3};
        double expresion1, expresion2, expresion3;
        double cuadradoX, cuadradoY, cuadradoZ;
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("      CÁLCULOS ARITMÉTICOS      ");
        System.out.println("--------------------------------");
        System.out.println("Introduzca tres números reales: ");
        System.out.print("Valor para X: ");
        valorX= teclado.nextDouble();
        
        System.out.print("Valor para Y: ");
        valorY= teclado.nextDouble();
        
        System.out.print("Valor para Z: ");
        valorZ= teclado.nextDouble();
        
        

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Calculo de cuadrados
        cuadradoX = valorX * valorX;
        cuadradoY = valorY * valorY;
        cuadradoZ = valorZ * valorZ;
        
        // Primera expresión
        expresion1 = valorX / 3.0 + 8.0;
        
        // Segunda expresión
        expresion2 = cuadradoX / cuadradoY + cuadradoY / cuadradoZ;
        
        // Tercera expresión
        expresion3 = (cuadradoX + 3 * valorX * valorY + cuadradoY) / 
                (1 / cuadradoX);
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("           RESULTADO            ");
        System.out.println("--------------------------------");
        System.out.println(Operaciones.OPERACION_1 + ": " + expresion1);
        System.out.println(Operaciones.OPERACION_2 + ": " + expresion2);
        System.out.println(Operaciones.OPERACION_3 + ": " + expresion3);
        
        System.out.println ();
        System.out.println ("Fin del programa. Bye!");
        System.out.println ();
        
    }
}

