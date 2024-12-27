
package tarea03;

//Importacion de librerías utilizadas
import libtarea3.Aeronave;
import libtarea3.Aeropuerto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ------------------------------------------------------------
//                   Clase Controlador
// ------------------------------------------------------------
/**
 * <p>
 * Clase que representa al <strong>controlador</strong>,
 * que será la clase que utilizaremos y donde se escribirán las diferentes 
 * operaciones en aeronaves y aeropuertos que se nos pide en 
 * el enunciado de la tarea.</p>
 *
 * @author José Bueno Cruz
 */
public class Controlador {
    public static void main(String[] args) {
      
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
       LocalDateTime ahora;
       DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        //----------------------------------------------
        //          Creación de objetos
        //----------------------------------------------
        System.out.println("--------------------------------------------------------");
        System.out.println("----------------- Creando Aeropuertos ------------------");
        System.out.println("--------------------------------------------------------\n");
       
        // Instanciar los 3 aeropuertos: Barcelona, Madrid, Granada.
        Aeropuerto prat = new Aeropuerto("El Prat", "Barcelona");
        Aeropuerto barajas = new Aeropuerto("Barajas", "Madrid");
        Aeropuerto fedeciroGL = new Aeropuerto("Federico Garcia Lorca", "Granada");
        
        System.out.println("                **Aeropuertos creados**                 \n");
        
        System.out.println("--------------------------------------------------------");
        System.out.println("------------------- Creando Aeronaves ------------------");
        System.out.println("--------------------------------------------------------\n");
        
        // Instanciar las 3 aeronaves: Avion1, Avion2, Avion3.
        Aeronave avion1 = new Aeronave();
        Aeronave avion2 = new Aeronave("EC-123","Boing747");
        Aeronave avion3 = new Aeronave("EC-456","Boing787",barajas);
        
        System.out.println("                **Aeronaves creadas**                  \n");
        
        //----------------------------------------------
        //   Inicio de la secuencia de instrucciones
        //----------------------------------------------
        System.out.println("--------------------------------------------------------");
        System.out.println("------------- Secuencia de instrucciones ---------------");
        System.out.println("--------------------------------------------------------\n");
        
        //Avion1 despega con velocidad 1500, altitud 1750, rumbo 50 y fechaHora actual
        ahora = LocalDateTime.now();
        avion1.despegar(1500, 1750, 50, ahora.format(formato));
        System.out.printf("              **Avión 1 %s ha despegado**             \n\n", (avion1.isVolando()) ? "" : "no");
        
        //Avion2 despega con velocidad 1500, altitud 1850 y rumbo 75
        ahora = LocalDateTime.now();
        avion2.despegar(1500, 1850, 75, ahora.format(formato));
        System.out.printf("              **Avión 2 %s ha despegado**             \n\n", (avion2.isVolando()) ? "" : "no");
        
        //Avion3 despega con velocidad 1500, altitud 1000 y rumbo 180
        ahora = LocalDateTime.now();
        avion3.despegar(1500, 1000, 180, ahora.format(formato));
        System.out.printf("              **Avión 3 %s ha despegado**             \n\n", (avion3.isVolando()) ? "" : "no");
        
        
        //Comprobar si Avion1 está volando
        System.out.printf("¿Avión 1 está volando?:                              %b\n", avion1.isVolando());
        
        //Mostrar la matrícula del Avion2
        System.out.printf("Matricula avión 2:                                   %s\n", avion2.getMatricula());
        
        //Mostrar modelo del Avion3
        System.out.printf("Modelo avión 3:                                      %s\n", avion3.getModelo());
        
        //Modificar rumbo del Avion2 a 90º y mostrarlo
        avion2.setRumbo(90);
        System.out.printf("El rumbo del avión 2 es:                             %d\n\n", avion2.getRumbo());
        
        //Avion3 aterriza en el aeropuerto de Barcelona despues de 75 minutos
        avion3.aterrizar(prat, 75);
        System.out.printf("             **Avión 3 %s ha aterrizado**            \n\n", (avion3.isVolando()) ? "no" : "");
        
        //Avion2 aterriza en el aeropuerto de Madrid despues de 80 minutos
        avion2.aterrizar(barajas, 80);
        System.out.printf("             **Avión 2 %s ha aterrizado**            \n\n", (avion2.isVolando()) ? "no" : "");
        
        //Comprobar si Avion2 está volando
        System.out.printf("¿Avión 2 está volando?:                              %b\n", avion2.isVolando());
        
        //Modificar altitud del Avion1 a 1250 metros y mostrarlo
        avion1.setAltitud(1250);
        System.out.printf("La nueva altitud del avión 1 es:                     %d\n", avion1.getAltitud());
        
        //Mostrar el tiempo toal de vuelo del Avion2
        System.out.printf("El tiempo de vuelo del avión 2 een minutos es:       %d\n", avion2.getTiempoTotalVuelo());
        
        //Mostrar el aeropuerto del Avion3
        System.out.printf("El aeropuerto del avión 3 es:                        %s\n", avion3.getAeropuerto());
        
        //Mostrar la fecha y hora de despegue del Avion3
        System.out.printf("El despegue del avión 3 se realizó con fecha:        %s\n\n", avion3.getFechaHoraDespegue());
        
        //Avion3 despega con velocidad 860, altitud 1420 y rumbo 270
        ahora = LocalDateTime.now();
        avion3.despegar(860, 1420, 270, ahora.format(formato));
        System.out.printf("             **Avión 3 %s ha despegado**            \n\n", (avion3.isVolando()) ? "" : "no");
        
        //Avion1 aterriza en el aeropuerto de Granada despues de 260 minutos
        avion1.aterrizar(fedeciroGL, 260);
        System.out.printf("             **Avión 1 %s ha aterrizado**            \n\n", (avion1.isVolando()) ? "no" : "");
       
        //Modificar velocidad del Avion3 a 950km/h y mostrarlo
        avion3.setVelocidad(950);
        System.out.printf("La nueva velocidad del avión 3 es:                   %d\n", avion3.getVelocidad());
        
        //Mostrar el nombre del aeropuerto de Madrid
        System.out.printf("El nombre del aeropuerto de Madrid es:               %s\n", barajas.getNombre());
        
        //Mostrar el número de aeronaves en este momento en el aeropuerto de Granada
        System.out.printf("El número de aviones en el aeropuerto de Granada es: %d\n", fedeciroGL.getNumeroAeronaves());
        
        //Mostrar toda la información del Avion1
        System.out.printf("Avión 1: %s\n", avion1.toString());
        
        //Mostrar toda la información del Avion2
        System.out.printf("Avión 2: %s\n", avion2.toString());
        
        //Mostrar toda la información del Avion3
        System.out.printf("Avión 3: %s\n\n", avion3.toString());
        
        //----------------------------------------------
        //          Llamadas a métodos estáticos
        //----------------------------------------------
        
        System.out.println("---------------------------------------------------------");
        System.out.println("------------------- Metodos estáticos -------------------");
        System.out.println("---------------------------------------------------------\n");
        
        //Mostrar el número total de aeronaves volando ahora mismo
        System.out.printf("El número total de aeronaves volando ahora mismo es: %d\n", Aeronave.getNumAeronavesVolando());
        
        //Mostrar el tiempo total de aeronaves volando en horas
        System.out.printf("El tiempo total de aeronaves volando en horas es:    %f\n", Aeronave.getNumHorasVuelo());
        
        //Mostrar el número total de aeronaves
        System.out.printf("El número total de aeronaves es:                     %d\n", Aeronave.getNumAeronaves());
    }
}
