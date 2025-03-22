public class Main {
    public static void main(String[] args) {
        int cantidad = ManejoPila.obtenerNumeroValido("Ingrese la cantidad de números en la pila");
        ManejoPila manejoPila = new ManejoPila(cantidad);
        manejoPila.calcularFactorial();
        manejoPila.ordenarPilaAscendente();
        manejoPila.ordenarPilaDescendente();
        manejoPila.eliminarNumero();
    }
}
