import javax.swing.*;
import java.util.*;

class ManejoPila {
    private Stack<Integer> pilaNumeros;

    public ManejoPila() {
        this.pilaNumeros = new Stack<>();
        generarNumerosAleatorios();
    }

    private void generarNumerosAleatorios() {
        int cantidad = obtenerEntero("Ingrese la cantidad de números a generar");
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            pilaNumeros.push(rand.nextInt(50)); // Genera números aleatorios entre 0 y 49
        }
        JOptionPane.showMessageDialog(null, "Pila generada: " + pilaNumeros);
    }

    private int obtenerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número entero válido.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void calcularFibonacci() {
        Stack<Integer> pilaAuxiliar = (Stack<Integer>) pilaNumeros.clone();
        StringBuilder fibonacciSeries = new StringBuilder("Serie de Fibonacci para cada número:\n");
        
        while (!pilaAuxiliar.isEmpty()) {
            int num = pilaAuxiliar.pop();
            fibonacciSeries.append("Fibonacci de ").append(num).append(" = ").append(fibonacci(num)).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, fibonacciSeries.toString());
    }

    private int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public void ordenarPila() {
        List<Integer> listaOrdenada = new ArrayList<>(pilaNumeros);
        Collections.sort(listaOrdenada);
        pilaNumeros.clear();
        pilaNumeros.addAll(listaOrdenada);
        JOptionPane.showMessageDialog(null, "Pila ordenada: " + pilaNumeros);
    }

    public void eliminarNumero() {
        int numeroEliminar = obtenerEntero("Ingrese el número que desea eliminar");
        pilaNumeros.removeIf(num -> num == numeroEliminar);
        JOptionPane.showMessageDialog(null, "Pila después de eliminar " + numeroEliminar + ": " + pilaNumeros);
    }
}

