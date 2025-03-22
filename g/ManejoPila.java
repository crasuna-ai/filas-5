import javax.swing.*;
import java.util.Stack;

class ManejoPila {
    private Stack<Double> pilaNumeros;

    public ManejoPila() {
        this.pilaNumeros = new Stack<>();
        ingresarNumeros();
    }

    private void ingresarNumeros() {
        int cantidad = obtenerEntero("Ingrese la cantidad de números a apilar");
        for (int i = 0; i < cantidad; i++) {
            pilaNumeros.push(obtenerDouble("Ingrese un número"));
        }
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

    private double obtenerDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void procesarPila() {
        Stack<Double> pilaAuxiliar = (Stack<Double>) pilaNumeros.clone();
        int cantidad20_80 = 0;
        int cantidadPositivos = 0;
        double suma80_200 = 0;
        StringBuilder cubosNegativos = new StringBuilder("Cubos de números negativos:\n");
        
        while (!pilaAuxiliar.isEmpty()) {
            double num = pilaAuxiliar.pop();
            if (num < 0) {
                cubosNegativos.append(num).append("^3 = ").append(Math.pow(num, 3)).append("\n");
            }
            if (num >= 20 && num <= 80) {
                cantidad20_80++;
            }
            if (num > 0) {
                cantidadPositivos++;
            }
            if (num >= 80 && num <= 200) {
                suma80_200 += num;
            }
        }
        
        JOptionPane.showMessageDialog(null, cubosNegativos.toString());
        JOptionPane.showMessageDialog(null, "Cantidad de números entre 20 y 80: " + cantidad20_80);
        JOptionPane.showMessageDialog(null, "Cantidad de números positivos: " + cantidadPositivos);
        JOptionPane.showMessageDialog(null, "Suma de números entre 80 y 200: " + suma80_200);
    }
}

