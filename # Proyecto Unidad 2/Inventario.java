import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private final Map<Producto, Integer> stockProductos;

    public Inventario() {
        this.stockProductos = new HashMap<>();
    }

    // Método para buscar un producto por nombre
    public Producto buscarProductoPorNombre(String nombreProducto) {
        for (Producto producto : stockProductos.keySet()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null;  // Si no encuentra el producto
    }

    // Método para reducir el stock de un producto
    public boolean reducirStock(Producto producto, int cantidad) {
        if (stockProductos.containsKey(producto)) {
            int stockActual = stockProductos.get(producto);
            if (stockActual >= cantidad) {
                stockProductos.put(producto, stockActual - cantidad);  // Reducir stock
                return true;
            } else {
                System.out.println("Stock insuficiente para el producto: " + producto.getNombre());
            }
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
        return false;  // Si no se pudo reducir el stock
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(Producto producto, int cantidad) {
        stockProductos.put(producto, cantidad);
    }

    // Método para modificar un producto (nombre o precio)
    public boolean modificarProducto(String nombreProducto, String nuevoNombre, double nuevoPrecio) {
        Producto producto = buscarProductoPorNombre(nombreProducto);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    // Método para eliminar un producto del inventario
    public boolean eliminarProducto(String nombreProducto) {
        Producto producto = buscarProductoPorNombre(nombreProducto);
        if (producto != null) {
            stockProductos.remove(producto);
            return true;
        }
        return false;
    }

    public void listarProductos() {
        if (stockProductos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("===== Inventario =====");
            for (Map.Entry<Producto, Integer> entry : stockProductos.entrySet()) {
                Producto producto = entry.getKey();
                Integer cantidad = entry.getValue();
                System.out.println(producto.getNombre() + " - $" + producto.getPrecio() + " - Cantidad: " + cantidad);
            }
        }
    }

    // Método para mostrar el inventario
    public void mostrarInventario() {
        if (stockProductos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("===== Inventario =====");
            for (Map.Entry<Producto, Integer> entry : stockProductos.entrySet()) {
                Producto producto = entry.getKey();
                Integer cantidad = entry.getValue();
                System.out.println(producto.getNombre() + " - $" + producto.getPrecio() + " - Cantidad: " + cantidad);
            }
        }
    }
}
