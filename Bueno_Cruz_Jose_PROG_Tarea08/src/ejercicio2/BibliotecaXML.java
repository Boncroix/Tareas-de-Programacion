package ejercicio2;

import com.thoughtworks.xstream.XStream;
import java.io.*;

/**
 * Clase que permite serializar un objeto Biblioteca al formato XML y 
 viceversa.
 *   
 * @author profe
 */
public class BibliotecaXML {
    
     // Ruta del archivo donde se lee y escribe el objeto Biblioteca
    private final String rutaArchivo;
    
    
    // Objeto Xstream que permite la L/E con archivos XML
    private final XStream xstream;

    /**
     * Metodo constructor
     * @param nombreArchivo Ruta del archivo donde se lee y escribe el objeto Biblioteca
     */
    public BibliotecaXML(String nombreArchivo) {
        this.rutaArchivo = nombreArchivo;
        this.xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        this.xstream.allowTypesByWildcard(new String[] { 
            "ejercicio2.**"
        });
    }

    
    // -----------------------------------------------------
    // Ejercicio 2: Metodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    // 3.1. Metodo escribir()
    /**
     * Metodo que escribe, en un archivo de texto, un objeto Biblioteca serializable.
     * @param biblioteca Objeto Biblioteca serializable para almacenar en el archivo de texto.
     */    
    public void escribir(Biblioteca biblioteca) {
        // Convierte el objeto Biblioteca a formato XML
        String xml = xstream.toXML(biblioteca);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.rutaArchivo))) {
            // Escribe el XML en el archivo
            writer.write(xml);
        } catch (IOException e) {
            // Captura cualquier error de escritura en el archivo
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }
        
    }
    
    // 3.2. Metodo leer()
     /**
     * Metodo que lee, desde un archivo de texto, un objeto Biblioteca serializado.
     * @return Objecto Biblioteca que estaba almacenado en el archivo de texto.
     */
    public Biblioteca leer() {
        
        Biblioteca biblioteca = null;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(this.rutaArchivo))) {
            // Lee y deserializa el archivo XML
            biblioteca = (Biblioteca) xstream.fromXML(reader);
        } catch (IOException ex) {
            // Captura cualquier error de lectura del archivo
            System.err.println("Error al leer el fichero: " + ex.getMessage());
        } catch (com.thoughtworks.xstream.XStreamException ex) {
            // Captura errores durante la deserialización XML
            System.err.println("Error al deserializar XML: " + ex.getMessage());
        }
        
        // Devuelve el objeto deserializado
        return biblioteca;
   
    }
}
