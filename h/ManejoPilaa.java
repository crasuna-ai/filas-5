import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class ManejoPila {
    private Stack<Integer> pilaNumeros;

    public ManejoPila() {
        this.pilaNumeros = new Stack<>();
        ingresarNumeros();
    }

    private void ingresarNumeros() {
        int cantidad = obtenerEntero("Ingrese la cantidad de números a apilar");
        for (int i = 0; i < cantidad; i++) {
            pilaNumeros.push(obtenerEntero("Ingrese un número"));
        }
        JOptionPane.showMessageDialog(null, "Pila ingresada: " + pilaNumeros);
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
        if (pilaNumeros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía, no se puede ordenar.");
            return;
        }
        List<Integer> listaOrdenada = new ArrayList<>(pilaNumeros);
        Collections.sort(listaOrdenada);
        pilaNumeros.clear();
        pilaNumeros.addAll(listaOrdenada);
        JOptionPane.showMessageDialog(null, "Pila ordenada: " + pilaNumeros);
    }

    public void eliminarNumero() {
        if (pilaNumeros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía, no hay números para eliminar.");
            return;
        }
        int numeroEliminar = obtenerEntero("Ingrese el número que desea eliminar");
        if (!pilaNumeros.contains(numeroEliminar)) {
            JOptionPane.showMessageDialog(null, "El número no está en la pila.");
            return;
        }
        pilaNumeros.removeIf(num -> num == numeroEliminar);
        JOptionPane.showMessageDialog(null, "Pila después de eliminar " + numeroEliminar + ": " + pilaNumeros);
    }
}


