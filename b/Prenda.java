public class Prenda {
    private String marca;
    private String referencia;
    private double precio;
    private int cantidad;

    // Constructor
    public Prenda(String marca, String referencia, double precio, int cantidad) {
        this.marca = marca;
        this.referencia = referencia;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void sumarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Referencia: " + referencia + ", Precio: " + precio + ", Cantidad: " + cantidad;
    }
}