import javax.swing.JOptionPane;
import java.util.Stack;

// Clase para manejar la lógica con pilas
class LogicaMatriz {
    private Stack<int[][]> pilaMatrices;
    private Stack<Double> pilaResultados;
    private int filas;
    private int columnas;

    public LogicaMatriz() {
        this.pilaMatrices = new Stack<>();
        this.pilaResultados = new Stack<>();
        obtenerDimensiones();
        ingresarMatriz();
    }

    private void obtenerDimensiones() {
        this.filas = obtenerEntero("Ingrese el número de filas");
        this.columnas = obtenerEntero("Ingrese el número de columnas");
    }

    private void ingresarMatriz() {
        int[][] matrizA = new int[filas][columnas];
        int[][] matrizB = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizA[i][j] = obtenerEntero("Ingrese elemento A[" + i + "][" + j + "]");
                matrizB[i][j] = obtenerEntero("Ingrese elemento B[" + i + "][" + j + "]");
            }
        }
        pilaMatrices.push(matrizA);
        pilaMatrices.push(matrizB);
    }

    private int obtenerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void calcularSumaFilas() {
        int[][] matrizA = pilaMatrices.get(0);
        for (int i = 0; i < matrizA.length; i++) {
            int suma = 0;
            for (int j = 0; j < matrizA[0].length; j++) {
                suma += matrizA[i][j];
            }
            pilaResultados.push((double) suma / matrizA[0].length);
        }
        mostrarPila("Promedio de filas");
    }

    public void calcularRaizColumnas() {
        int[][] matrizA = pilaMatrices.get(0);
        for (int j = 0; j < matrizA[0].length; j++) {
            int suma = 0;
            for (int i = 0; i < matrizA.length; i++) {
                suma += matrizA[i][j];
            }
            pilaResultados.push(Math.sqrt(suma));
        }
        mostrarPila("Raíz cuadrada de las columnas");
    }

    public void multiplicarMatrices() {
        int[][] matrizA = pilaMatrices.pop();
        int[][] matrizB = pilaMatrices.pop();
        int[][] resultado = new int[matrizA.length][matrizA[0].length];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[0].length; j++) {
                resultado[i][j] = matrizA[i][j] * matrizB[i][j];
                pilaResultados.push((double) resultado[i][j]);
            }
        }
        pilaMatrices.push(resultado);
        mostrarPila("Multiplicación de matrices");
    }

    private void mostrarPila(String mensaje) {
        StringBuilder sb = new StringBuilder(mensaje + "\n");
        while (!pilaResultados.isEmpty()) {
            sb.append(pilaResultados.pop()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void ejecutarOperaciones() {
        calcularSumaFilas();
        calcularRaizColumnas();
        multiplicarMatrices();
    }
}