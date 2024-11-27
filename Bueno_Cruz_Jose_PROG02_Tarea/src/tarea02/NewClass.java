/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

/**
 *
 * @author josebuenocruz
 */
public class NewClass {
            //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        switch (seleccionUsuario) {
            case 1:
                int contador = 0;
                while (contador < NUMERO_EMPLEADOS) {
                    // Calcular sueldo en función de su antiguedad
                    System.out.print("Introducir antigüedad empleado"+ contador +": ");
                    antiguedad= teclado.nextInt();
                    contador += 1;
                    // Plus quinquenio
                    if (antiguedad > 5) {
                        sueldo += 100;
                    } else {
                        sueldo += 20;
                    }   
                    // Plus por año trabajado
                    sueldo += antiguedad * 50;
                }
                break;
            case 2:
                System.out.println("Opción no 2.");
                break;
            case 3:
                // Salir del programa
                break;
            default:
                System.out.println("Opción no válida.");
        }
                
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("           RESULTADO            ");
        System.out.println("--------------------------------");

        
        System.out.println ();
        System.out.println ("Fin del programa. Bye!");
        System.out.println ();
}
