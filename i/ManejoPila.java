import javax.swing.*;
import java.util.Stack;
import java.util.Random;

class ManejoPila {
    private Stack<Integer> pilaNumeros;
    private Random random;

    public ManejoPila(int cantidad) {
        this.pilaNumeros = new Stack<>();
        this.random = new Random();
        generarNumerosAleatorios(cantidad);
    }

    private void generarNumerosAleatorios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            pilaNumeros.push(random.nextInt(10) + 1); // Números entre 1 y 10
        }
        JOptionPane.showMessageDialog(null, "Pila generada: " + pilaNumeros);
    }

    public void calcularFactorial() {
        Stack<Integer> pilaAuxiliar = (Stack<Integer>) pilaNumeros.clone();
        StringBuilder resultado = new StringBuilder("Factoriales de los números en la pila:\n");
        while (!pilaAuxiliar.isEmpty()) {
            int num = pilaAuxiliar.pop();
            resultado.append("Factorial de ").append(num).append(" = ").append(factorial(num)).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public void ordenarPilaAscendente() {
        Stack<Integer> pilaOrdenada = new Stack<>();
        while (!pilaNumeros.isEmpty()) {
            int temp = pilaNumeros.pop();
            while (!pilaOrdenada.isEmpty() && pilaOrdenada.peek() > temp) {
                pilaNumeros.push(pilaOrdenada.pop());
            }
            pilaOrdenada.push(temp);
        }
        pilaNumeros.addAll(pilaOrdenada);
        JOptionPane.showMessageDialog(null, "Pila ordenada ascendentemente: " + pilaNumeros);
    }

    public void ordenarPilaDescendente() {
        Stack<Integer> pilaOrdenada = new Stack<>();
        while (!pilaNumeros.isEmpty()) {
            int temp = pilaNumeros.pop();
            while (!pilaOrdenada.isEmpty() && pilaOrdenada.peek() < temp) {
                pilaNumeros.push(pilaOrdenada.pop());
            }
            pilaOrdenada.push(temp);
        }
        pilaNumeros.addAll(pilaOrdenada);
        JOptionPane.showMessageDialog(null, "Pila ordenada descendentemente: " + pilaNumeros);
    }

    public void eliminarNumero() {
        int numeroEliminar = obtenerNumeroValido("Ingrese el número que desea eliminar");
        Stack<Integer> pilaTemporal = new Stack<>();
        boolean encontrado = false;
        
        while (!pilaNumeros.isEmpty()) {
            int num = pilaNumeros.pop();
            if (num == numeroEliminar && !encontrado) {
                encontrado = true;
            } else {
                pilaTemporal.push(num);
            }
        }
        
        while (!pilaTemporal.isEmpty()) {
            pilaNumeros.push(pilaTemporal.pop());
        }
        
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Pila después de eliminar " + numeroEliminar + ": " + pilaNumeros);
        } else {
            JOptionPane.showMessageDialog(null, "El número no está en la pila.");
        }
    }

    static int obtenerNumeroValido(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        }
    }
}
