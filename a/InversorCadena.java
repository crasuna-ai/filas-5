import java.util.Stack;
import javax.swing.JOptionPane;

public class InversorCadena {
    private String cadena; // Atributo para almacenar la cadena

    // Constructor
    public InversorCadena() {
        this.cadena = ""; // Inicializar la cadena vacía
    }

    // Getter
    public String getCadena() {
        return cadena;
    }

    // Setter
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    // Método para invertir la cadena
    public void invertir() {
        // Solicitar al usuario que ingrese una cadena
        setCadena(JOptionPane.showInputDialog("Ingrese una cadena de caracteres:"));

        // Crear una pila para almacenar los caracteres
        Stack<Character> pila = new Stack<>();

        // Contar los caracteres de la cadena
        int contador = 0;

        // Llenar la pila con los caracteres de la cadena
        for (char c : getCadena().toCharArray()) {
            pila.push(c);
            contador++;
        }

        // Mostrar la cantidad de caracteres
        System.out.println("Cantidad de caracteres: " + contador);

        // Desapilar los caracteres para formar la cadena invertida
        StringBuilder cadenaInvertida = new StringBuilder();
        while (!pila.isEmpty()) {
            cadenaInvertida.append(pila.pop());
        }

        // Mostrar la cadena invertida
        System.out.println("Cadena invertida: " + cadenaInvertida.toString());
    }
}