import java.util.Stack;
import javax.swing.JOptionPane;

public class Tienda {
    private Stack<Prenda> stock;

    public Tienda() {
        stock = new Stack<>();
    }

    // Método para manejar el menú
    public void manejarMenu() {
        boolean continuar = true;

        while (continuar) {
            String menu = "Menu:\n" +
                          "1. Registrar prenda\n" +
                          "2. Consultar prenda\n" +
                          "3. Modificar prenda\n" +
                          "4. Vender prenda\n" +
                          "5. Consultar stock\n" +
                          "6. Salir";
            String opcionStr = JOptionPane.showInputDialog(menu);
            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    String marca = JOptionPane.showInputDialog("Ingrese la marca:");
                    String referencia = JOptionPane.showInputDialog("Ingrese la referencia:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
                    registrarPrenda(marca, referencia, precio, cantidad);
                    break;
                case 2:
                    String consultaMarca = JOptionPane.showInputDialog("Ingrese la marca o referencia:");
                    consultarPrenda(consultaMarca, consultaMarca);
                    break;
                case 3:
                    String marcaMod = JOptionPane.showInputDialog("Ingrese la marca de la prenda a modificar:");
                    String referenciaMod = JOptionPane.showInputDialog("Ingrese la referencia de la prenda a modificar:");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio:"));
                    int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad:"));
                    modificarPrenda(marcaMod, referenciaMod, nuevoPrecio, nuevaCantidad);
                    break;
                case 4:
                    String marcaVenta = JOptionPane.showInputDialog("Ingrese la marca de la prenda a vender:");
                    String referenciaVenta = JOptionPane.showInputDialog("Ingrese la referencia de la prenda a vender:");
                    int cantidadVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender:"));
                    venderPrenda(marcaVenta, referenciaVenta, cantidadVenta);
                    break;
                case 5:
                    consultarStock();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para registrar una prenda
    public void registrarPrenda(String marca, String referencia, double precio, int cantidad) {
        for (Prenda prenda : stock) {
            if (prenda.getMarca().equalsIgnoreCase(marca) && prenda.getReferencia().equalsIgnoreCase(referencia)) {
                prenda.sumarCantidad(cantidad);
                JOptionPane.showMessageDialog(null, "Prenda existente. Se ha actualizado la cantidad.");
                return;
            }
        }
        stock.push(new Prenda(marca, referencia, precio, cantidad));
        JOptionPane.showMessageDialog(null, "Prenda registrada exitosamente.");
    }

    // Método para consultar una prenda
    public void consultarPrenda(String marca, String referencia) {
        for (Prenda prenda : stock) {
            if (prenda.getMarca().equalsIgnoreCase(marca) || prenda.getReferencia().equalsIgnoreCase(referencia)) {
                JOptionPane.showMessageDialog(null, prenda.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "La prenda no existe.");
    }

    // Método para modificar una prenda
    public void modificarPrenda(String marca, String referencia, double nuevoPrecio, int nuevaCantidad) {
        for (Prenda prenda : stock) {
            if (prenda.getMarca().equalsIgnoreCase(marca) && prenda.getReferencia().equalsIgnoreCase(referencia)) {
                prenda.setCantidad(nuevaCantidad);
                JOptionPane.showMessageDialog(null, "Prenda modificada exitosamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "La prenda no existe.");
    }

    // Método para vender una prenda
    public void venderPrenda(String marca, String referencia, int cantidad) {
        for (Prenda prenda : stock) {
            if (prenda.getMarca().equalsIgnoreCase(marca) && prenda.getReferencia().equalsIgnoreCase(referencia)) {
                if (prenda.getCantidad() >= cantidad) {
                    prenda.setCantidad(prenda.getCantidad() - cantidad);
                    JOptionPane.showMessageDialog(null, "Venta realizada. Cantidad vendida: " + cantidad);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Stock insuficiente. Cantidad disponible: " + prenda.getCantidad());
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "La prenda no existe.");
    }

    // Método para consultar stock
    public void consultarStock() {
        if (stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay prendas en stock.");
            return;
        }
        StringBuilder stockList = new StringBuilder("Stock de prendas:\n");
        for (Prenda prenda : stock) {
            stockList.append(prenda.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, stockList.toString());
    }
}