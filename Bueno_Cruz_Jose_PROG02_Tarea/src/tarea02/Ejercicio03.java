package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 3. Validación de contraseñas.
 *
 * @author josebuenocruz
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        
        // Constantes
        int LONGITUD_MINIMA = 12;
        
        
        // Variables de entrada
        String contraseña;
        
        
        // Variables de salida
        boolean resultado;
        boolean longitudCorrecta;
        boolean comienzaPorVocal;
        boolean terminaPorConsonante;
        boolean contieneCaracteresEspeciales;
        
        
        // Variables auxiliares
        int longitudCadena;
        String primerCaracter;
        String ultimoCaracter;
        
    
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println(" .  VALIDACIÓN DE CONTRASEÑAS .  ");
        System.out.println("---------------------------------");
        System.out.print("Introduzca la contraseña: ");
        contraseña= teclado.nextLine();
        System.out.println();
        

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        
        // Cálculo de información auxiliar previa
        longitudCadena = contraseña.length();
        primerCaracter = contraseña.substring(0, 1);
        ultimoCaracter = contraseña.substring(longitudCadena -1, 
                longitudCadena);
        
        
        // Comprobamos si tiene como mínimo 12 caracteres
        longitudCorrecta = longitudCadena >= LONGITUD_MINIMA;
        System.out.println("Longitud correcta: " + longitudCorrecta);
        
        
        // Comprobamos si comienza por una vocal (mayúscula o minúscula)
        comienzaPorVocal = 
                (primerCaracter.equalsIgnoreCase("A")) ||
                (primerCaracter.equalsIgnoreCase("E")) ||
                (primerCaracter.equalsIgnoreCase("I")) ||
                (primerCaracter.equalsIgnoreCase("O")) ||
                (primerCaracter.equalsIgnoreCase("U"));
        System.out.println("Comienza por Vocal: " + comienzaPorVocal);
        
        
        // Comprobamos si termina con una consonante (mayúscula o minúscula)
        terminaPorConsonante = 
                Character.isLetter(ultimoCaracter.charAt(0)) &&
                !(ultimoCaracter.equalsIgnoreCase("A") ||
                ultimoCaracter.equalsIgnoreCase("E") ||
                ultimoCaracter.equalsIgnoreCase("I") ||
                ultimoCaracter.equalsIgnoreCase("O") ||
                ultimoCaracter.equalsIgnoreCase("U"));
        System.out.println("Termina por consonante: " + terminaPorConsonante);
        
        
        // Comprobamos si contiene al menos uno de los caracteres especiales requeridos
        contieneCaracteresEspeciales = 
                contraseña.contains("@") || 
                contraseña.contains("#") || 
                contraseña.contains("_") || 
                contraseña.contains(".") || 
                contraseña.contains(";");
        System.out.println("Contiene caracteres especiales: " 
                + contieneCaracteresEspeciales);
        
        
        // Concatenación de resultados
        resultado = 
                longitudCorrecta & 
                comienzaPorVocal & 
                terminaPorConsonante & 
                contieneCaracteresEspeciales;
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println(" .         RESULTADO          .  ");
        System.out.println("---------------------------------");
        System.out.println(resultado ? "La contraseña es VÁLIDA" : "La contraseña no es VÁLIDA");
        System.out.println();
        
        System.out.println ();
        System.out.println ("Fin del programa. Bye!");
        System.out.println ();
        
    }
}
