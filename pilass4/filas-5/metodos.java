import java.util.Stack;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class metodos {

    // Método para llenar la lista de números
    public ArrayList<Numero> LlenarLista() {
        ArrayList<Numero> lista = new ArrayList<>();
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de números:"));

        for (int i = 0; i < n; i++) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número " + (i + 1) + ":"));
            lista.add(new Numero(numero)); // Usar la clase Numero
        }
        return lista;
    }

    // Método para sumar los números usando una pila
    public void SumarNumerosConPila(ArrayList<Numero> lista) {
        Stack<Integer> pila = new Stack<>();
        for (Numero num : lista) {
            pila.push(num.getValor()); // Obtener el valor del objeto Numero
        }

        int suma = 0;
        while (!pila.isEmpty()) {
            suma += pila.pop();
        }

        System.out.println("Suma de los números (desde la pila): " + suma);
    }

    // Método para calcular el factorial de un número
    public void CalcularFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + n + " es: " + factorial);
    }

    // Método para mostrar los números ordenados de mayor a menor
    public void MostrarNumerosOrdenados(ArrayList<Numero> lista) {
        // Convertir la lista a un arreglo para ordenar
        Integer[] numeros = new Integer[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            numeros[i] = lista.get(i).getValor(); // Obtener el valor del objeto Numero
        }

        // Ordenar el arreglo de mayor a menor
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] < numeros[j]) {
                    // Intercambiar
                    int temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }

        System.out.println("Números ordenados de mayor a menor:");
        for (int num : numeros) {
            System.out.println(num);
        }
    }

    // Método para mostrar el menú y manejar la lógica
    public void MostrarMenu() {
        ArrayList<Numero> lista = LlenarLista();
        boolean continuar = true;
        while (continuar) {
            String menu = "Seleccione una opción:\n" +
                          "1: Sumar números usando pila\n" +
                          "2: Calcular factorial de la cantidad de números\n" +
                          "3: Mostrar números ordenados de mayor a menor\n" +
                          "4: Salir";
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    SumarNumerosConPila(lista);
                    break;
                case 2:
                    CalcularFactorial(lista.size());
                    break;
                case 3:
                    MostrarNumerosOrdenados(lista);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }
}