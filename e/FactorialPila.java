import java.util.Stack;
import javax.swing.JOptionPane;

public class FactorialPila {
    private Stack<Integer> pila = new Stack<>();

    // Método para agregar elementos a la pila
    public void agregarElemento(int numero) {
        pila.push(numero);
    }

    // Método para calcular el factorial de un número
    public long calcularFactorial(int numero) {
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Método para procesar la pila y calcular el factorial de cada número
    public void procesarPila() {
        Stack<Long> resultados = new Stack<>();

        while (!pila.isEmpty()) {
            int numero = pila.pop();
            long factorial = calcularFactorial(numero);
            resultados.push(factorial);
        }

        // Mostrar los resultados
        StringBuilder sb = new StringBuilder("Factoriales:\n");
        int index = 1; // Para mostrar el índice correcto
        while (!resultados.isEmpty()) {
            sb.append("Factorial de ").append(index++).append(": ").append(resultados.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Método para llenar la pila desde un vector de números
    public void llenarPilaDesdeVector(int[] numeros) {
        for (int numero : numeros) {
            agregarElemento(numero);
        }
    }

    // Método para manejar la entrada y procesamiento
    public void ejecutar() {
        // Solicitar al usuario que ingrese los números
        String input = JOptionPane.showInputDialog("Ingrese los números separados por comas:");
        String[] numerosStr = input.split(",");

        // Crear un vector para almacenar los números
        int[] numeros = new int[numerosStr.length];

        // Agregar los números al vector
        for (int i = 0; i < numerosStr.length; i++) {
            try {
                numeros[i] = Integer.parseInt(numerosStr[i].trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: '" + numerosStr[i] + "' no es un número válido.");
                return; // Salir si hay un error
            }
        }

        // Llenar la pila desde el vector
        llenarPilaDesdeVector(numeros);

        // Procesar la pila y mostrar los factoriales
        procesarPila();
    }
}