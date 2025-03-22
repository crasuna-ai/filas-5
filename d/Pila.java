import java.util.Stack;
import javax.swing.JOptionPane;

public class Pila {
    private Stack<Object> pila = new Stack<>();

    // Método para agregar elementos a la pila
    public void agregarElemento(Object elemento) {
        pila.push(elemento);
    }

    // Método para buscar un elemento en la pila
    public void buscarElemento(Object elemento) {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía. Por favor, llénela primero.");
            return;
        }

        int posicion = -1; // Inicializar posición como no encontrada
        Stack<Object> pilaTemporal = new Stack<>(); // Pila temporal para mantener el orden

        // Buscar el elemento en la pila
        while (!pila.isEmpty()) {
            Object actual = pila.pop();
            pilaTemporal.push(actual); // Guardar el elemento en la pila temporal

            if (actual.equals(elemento)) {
                posicion = pilaTemporal.size(); // La posición es el tamaño de la pila temporal
                break;
            }
        }

        // Restaurar la pila original
        while (!pilaTemporal.isEmpty()) {
            pila.push(pilaTemporal.pop());
        }

        // Mostrar el resultado
        if (posicion != -1) {
            JOptionPane.showMessageDialog(null, "El elemento '" + elemento + "' se encontró en la posición: " + posicion);
        } else {
            JOptionPane.showMessageDialog(null, "El elemento '" + elemento + "' no se encontró en la pila.");
        }
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return pila.isEmpty();
    }

    // Método para llenar la pila
    public void llenarPila() {
        boolean continuar = true;

        // Llenar la pila
        while (continuar) {
            String input = JOptionPane.showInputDialog("Ingrese un carácter o número para agregar a la pila (o 'fin' para terminar):");
            if (input.equalsIgnoreCase("fin")) {
                continuar = false; // Terminar el llenado de la pila
            } else {
                agregarElemento(input); // Agregar el elemento a la pila
            }
        }
    }

    // Método para buscar un elemento en la pila
    public void buscarElementoEnPila() {
        while (true) {
            String buscar = JOptionPane.showInputDialog("Ingrese el carácter o número que desea buscar en la pila:");
            if (estaVacia()) {
                JOptionPane.showMessageDialog(null, "La pila está vacía. Por favor, llénela primero.");
                break; // Salir del bucle de búsqueda
            } else {
                buscarElemento(buscar); // Buscar el elemento en la pila
            }

            // Preguntar si desea continuar buscando
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea buscar otro elemento?", "Buscar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                break; // Salir del bucle de búsqueda
            }
        }
    }
}