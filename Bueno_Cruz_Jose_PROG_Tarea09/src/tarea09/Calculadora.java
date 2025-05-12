package tarea09;

//Librerías para poder utilizar JavaFX
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//Librerías específicas para evaluar expresiones exp4j
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * La típica calculadora básica para realizar cálculos artitméticos como la
 * suma, resta, multiplicación y división, en la que se permite el cálculo de
 * expresiones combinadas.
 *
 * @author José Bueno Cruz
 */
public class Calculadora extends Application {
    //----------------------------------------------
    //          Declaración de variables 
    //----------------------------------------------
    private String entrada = "";
    private final TextField display = new TextField();
    private final String[] botones = {"7", "8", "9", "/", "(",
                                        "4", "5", "6", "*", ")",
                                        "1", "2", "3", "-", ".",
                                        "0", "C", "<", "+", "=",};
    
    //----------------------------------------------
    //          Declaración de variables auxiliares 
    //---------------------------------------------- 
    private int fila = 1;
    private int columna = 0;
    private char ultimoCaracter = ' ';
    
    /*El método start es el punto de entrada para una aplicación JavaFX.
    Su función principal es inicializar y mostrar la interfaz 
    gráfica de usuario (GUI) de la aplicación. Se crea un diseño (layout), 
    se añaden controles (botones, etiquetas, campos, ...) y se crea la escena
    con un estilo, y se muestra el escenario.*/
    @Override
    public void start(Stage escenario) {

        // Crear el GridPane.
        GridPane root = new GridPane();
        root.setHgap(4);
        root.setVgap(4);
        root.setPadding(new Insets(10));
        
        // Editar propiedades del display.
        display.setEditable(false);
        display.setFocusTraversable(false);

        // Añade texfiel al GridPane
        root.add(display, 0, 0, 5, 1);

        // Bucle para crear los botones, añadirlos al GridPane.
        for (String textoBoton : botones) {
            Button btn = new Button(textoBoton);
            // Manejar pulsación del botón con el método manejarBoton.
            btn.setOnAction(e -> manejarBoton(textoBoton));
            // Añadir botón al panel.
            root.add(btn, columna, fila);
            // Cambiar posición para el siguiente botón.
            columna++;
            if (columna == 5) {
                columna = 0;
                fila++;
            }
        }

        // Crear escena
        Scene escena = new Scene(root, 286, 286);
        // Aplicar hoja de estilos
        escena.getStylesheets().add(getClass().getResource("calculadora.css").toExternalForm());
        // Establecer escena en escenario
        escenario.setScene(escena);
        // Asignar icono al escenario.
        try {
            javafx.scene.image.Image imageDecline = new javafx.scene.image.Image(getClass().getResourceAsStream("logoCalcu.png"));
            escenario.getIcons().add(imageDecline);
        } catch (NullPointerException e) {
            System.err.println("No existe la imagen");
        }
        // Evitar redimensionado del escenario
        escenario.setResizable(false);
        // Establecer título
        escenario.setTitle("Mi calculadora");
        // Mostrar escenario
        escenario.show();
    }
    
    /**
     * Maneja la acción asociada a un botón de la calculadora, actualizando la entrada del usuario
     * y el display en función del valor del botón presionado y las condiciones establecidas.
     *
     * @param textoBoton El texto del botón que fue presionado.
     */
    
    private void manejarBoton(String textoBoton) {
        if (!entrada.isEmpty()) {
            ultimoCaracter = entrada.charAt(entrada.length() - 1);
        }

        String nuevaEntrada = entrada;

        switch (textoBoton) {
            case "C" -> nuevaEntrada = "";
            case "<" -> {
                if (!entrada.isEmpty()) {
                    nuevaEntrada = entrada.substring(0, entrada.length() - 1);
                }
            }
            case "." -> {
                String ultimoNumero = obtenerUltimoNumero(entrada);
                if (!entrada.isEmpty() && !ultimoNumero.contains(".")) {
                    nuevaEntrada += textoBoton;
                }
            }
            case "+", "-", "*", "/" -> {
                if (!entrada.isEmpty() && (Character.isDigit(ultimoCaracter) || ultimoCaracter == ')')) {
                    nuevaEntrada += textoBoton;
                }
            }
            case "(" -> nuevaEntrada += (Character.isDigit(ultimoCaracter) ? "*" + textoBoton : textoBoton);
            case ")" -> {
                if (!entrada.isEmpty()
                        && contarCaracter(entrada, '(') > contarCaracter(entrada, ')')
                        && (Character.isDigit(ultimoCaracter) || ultimoCaracter == ')')) {
                    nuevaEntrada += textoBoton;
                }
            }
            case "=" -> {
                if (!entrada.isEmpty()) {
                    nuevaEntrada = procesoDeEntrada(entrada);
                }
            }
            default -> nuevaEntrada += textoBoton;
        }

        entrada = nuevaEntrada;
        display.setText(entrada);
        ultimoCaracter = ' ';
    }

    
    /**
     * Método que extrae el último número introducido en la cadena de entrada.
     * Recorre la cadena desde el final hacia el inicio y acumula los caracteres que formen un número válido
     *
     * @param entrada Cadena actual de la calculadora (expresión completa).
     * @return El último número ingresado (como texto), o una cadena vacía si no hay un número al final.
    */
    
    private String obtenerUltimoNumero(String entrada) {
        // Recorre la cadena desde el final hacia el inicio
        StringBuilder numero = new StringBuilder();
        for (int i = entrada.length() - 1; i >= 0; i--) {
            char c = entrada.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                numero.insert(0, c);
            } else {
                break;
            }
        }
        return numero.toString();
    }
    
    /**
     * El método contarCaracter cuenta las veces que aparece un carácter
     * específico dentro de una cadena dada.
     * 
     * @param entrada La cadena de textoen laqie se biscarça eñ carçacter.
     * @param caracter El caracter que se desea contar en la cadena.
     * @return El número de veces que el carácter aparece en la cadena.
    */
    private int contarCaracter(String entrada, char caracter) {
        int count = 0;
        for (char c : entrada.toCharArray()) {
            if (c == caracter) {
                count++;
            }
        }
        return count;
    }

    /**
     * El método procesoDeEntrada maneja la entrada de datos en una calculadora.
     * Toma una cadena de texto (entrada) y realiza diferentes acciones según el
     * contenido de esa cadena, agregando al campo de texto, estableciendo el
     * estado, controlando la adición de puntos decimales para evitar múltiples
     * decimales en un número o evaluando la expresión mátemática para mostrar
     * el resultado haciendo uso de la librería Exp4J.
     *
     * @param entrada Texto recogido de los diferentes textoBotones de la
     * calculadora.
     * @return String que contiene el resultado de la evaluación de la expresión
     * matemática o un mensaje de error si la expresión no es válida.
     */
    public String procesoDeEntrada(String entrada) {
        try {
            // Crear una expresión simple
            ExpressionBuilder builder = new ExpressionBuilder(entrada);
            Expression expression = builder.build();
            double resultado = expression.evaluate();
            return String.valueOf(resultado);
        } catch (IllegalArgumentException | ArithmeticException e) {
            // Retornar error
            System.err.println("Error: " + e.getMessage());
            return ("Error en la expresión.");
        } catch (Exception e) {
            // Manejar cualquier otro error
            System.err.println("Error: " + e.getMessage());
            return ("Error desconocido");
        }
    }

    /**
     * Programa principal, lanza la aplicación.
     *
     * @param args Argumentos o parámetros (no hay en este caso)
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
