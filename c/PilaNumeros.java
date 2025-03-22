import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaNumeros {
    private Stack<Double> pila = new Stack<>();

    // Método para agregar elementos a la pila
    public void agregarElemento(double numero) {
        pila.push(numero);
    }

    // Método para procesar la pila
    public void procesarPila() {
        Stack<Double> pilaProcesada = new Stack<>();

        while (!pila.isEmpty()) {
            double numero = pila.pop();

            // Validar y reemplazar según las condiciones
            if (numero < 0) {
                pilaProcesada.push(0.0);
            } else if (numero >= 8 && numero <= 20) {
                pilaProcesada.push(50.0);
            } else if (numero > 60 && numero < 62) {
                pilaProcesada.push(100.0);
            } else {
                pilaProcesada.push(numero);
            }
        }

        // Calcular la raíz cuadrada de cada elemento
        Stack<Double> pilaRaices = new Stack<>();
        while (!pilaProcesada.isEmpty()) {
            double numero = pilaProcesada.pop();
            pilaRaices.push(Math.sqrt(numero));
        }

        // Mostrar los resultados
        StringBuilder resultados = new StringBuilder("Resultados de la raíz cuadrada de los elementos procesados:\n");
        while (!pilaRaices.isEmpty()) {
            resultados.append(pilaRaices.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultados.toString());
    }

    // Método para manejar la entrada de datos y el procesamiento
    public void ejecutar() {
        int n = 0;
        boolean entradaValida = false;

        // Solicitar la cantidad de elementos
        while (!entradaValida) {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de elementos en la pila:"));
                entradaValida = true; // Si se convierte correctamente, se establece la entrada como válida
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }
        }

        // Agregar elementos a la pila
        for (int i = 0; i < n; i++) {
            double numero = 0;
            entradaValida = false;

            while (!entradaValida) {
                try {
                    numero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el número " + (i + 1) + ":"));
                    agregarElemento(numero);
                    entradaValida = true; // Si se convierte correctamente, se establece la entrada como válida
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
                }
            }
        }

        // Procesar la pila
        procesarPila();
    }
}