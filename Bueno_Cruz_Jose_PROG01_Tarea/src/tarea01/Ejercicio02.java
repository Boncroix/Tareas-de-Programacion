package tarea01;

/**
 * Ejercicio 2. Operaciones con constantes y variables.
 *
 * @author josebuenocruz
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //---------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        final double CONSTANTE1 = 80.3;
        final int CONSTANTE2 = 3;

        // Variables de entrada
        
        // Variables de salida
        
        // Variables auxiliares
        boolean valorBool;
        byte enteroByte;
        short enteroShort;
        int enteroInt, producto;
        long enteroLong, producto1;
        double decimalDoble, producto2;
        float decimalSimple;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay entrada de datos
        System.out.println("OPERACIONES CON CONSTANTES Y VARIABLES.");
        System.out.println("---------------------------------------");
        System.out.println(" ");

        //----------------------------------------------
        //     Procesamiento 
        //----------------------------------------------
        
        //----------------------------------------------
        // Ejemplos que se proporcionan como modelo:
        
        // Las variables booleanas solo pueden tener los valores true o false
        // valorBool = 0;
        
        // decimalSimple = 9.9 * 4.6;       
        // SOLUCIÓN: CASTING EXPLÍCITO
        decimalSimple = (float) (9.9 * 4.6);

        // CASTING IMPLÍCITO: de tipo char a tipo int
        enteroInt = 'a';
        //----------------------------------------------
        
        
        /*
        SOLUCIÓN: Es necesario utilizar punto para indicar la separación entre 
        la parte entera y la parte decimal por convención del lenguaje.
        */
        // decimalDoble = 5,17;                       
        decimalDoble = 5.17;                          
        System.out.println("decimalDoble = " + decimalDoble);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        SECUENCIA CORRECTA
        */
        enteroLong = 25_369L;
        System.out.println("enteroLong = " + enteroLong);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        SOLUCIÓN: Casting explícito. El resultado se castea a entero, aunque en
        la operación se podrían perder valores. Otra solución correcta hubiese 
        sido declarar producto como long para no perder precisión.
        */
        //producto = enteroLong * enteroInt;
        producto = (int) enteroLong * enteroInt;      
        producto1 = enteroLong * enteroInt;           
        System.out.println("producto = " + producto);
        System.out.println("producto1 = " + producto1);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        EXPLICACIÓN: Error de comparación de tipos, al comparar el primer 
        número con el caracter se convierte en un booleano después no es
        posible comparar un booleano con un entero.
        */
        //valorBool = (97 == 'a' == 97);              
        valorBool = (97 == 'a' && 'a' == 97);         
        System.out.println("valorBool = " + valorBool);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        EXPLICACIÓN: El valor de una constante no puede cambiar.
        */
        //CONSTANTE1 = 100.3;                         
        //----------------------------------------------
        
        
        /*
        CASTING IMPLÍCITO: de tipo char (ASCII) a tipo float
        */
        decimalSimple = 'c';
        System.out.println("decimalSimple = " + decimalSimple);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        SECUENCIA CORRECTA
        */
        decimalDoble = 3.2 * 4.7;                     
        System.out.println("decimalDoble = " + decimalDoble);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        SOLUCIÓN: Casting explícito
        */
        //decimalSimple = (float) 9.9 * 4.6;          
        decimalSimple = (float) (9.9 * 4.6);          
        System.out.println("decimalSimple = " + decimalSimple);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        SOLUCIÓN: Casting explícito. Se castea la primera constante para despues
        multiplicarla por la segunda, otra solución correcta hubiese 
        sido declarar producto como double, para no perder precisión.
        */
        //producto = CONSTANTE1 * CONSTANTE2;         
        producto = (int) CONSTANTE1 * CONSTANTE2;     
        producto2 = CONSTANTE1 * CONSTANTE2;          
        System.out.println("producto = " + producto);
        System.out.println("producto2 = " + producto2);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        CASTING IMPLÍCITO: del tipo float a tipo double
        */
        decimalDoble = 5.67F;
        System.out.println("decimalDoble = " + decimalDoble);
        System.out.println();
        //----------------------------------------------
        
        /*
        CASTING IMPLÍCITO: del tipo int a tipo double
        */
        decimalDoble = 8;
        System.out.println("decimalDoble = " + decimalDoble);
        System.out.println();
        //----------------------------------------------
        
        
        /*
        No hay ninguna conversión con lo cual la parte fraccionaria se perderá,
        se puede solucionar haciendo una conversión implícita para que la 
        división no sea entre enteros.
        */
        enteroInt = 1 / 2;
        decimalSimple = 1F / 2;
        System.out.println("enteroInt = " + enteroInt);
        System.out.println("decimalSimple = " + decimalSimple);
        System.out.println();
        //----------------------------------------------
        
        
    }
}
