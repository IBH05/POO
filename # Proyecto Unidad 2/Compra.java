import java.time.LocalDate;
import java.util.List;

public class Compra {
    private final List<Boleto> boletos;
    private final List<Producto> productos;
    private final Pago pago;
    private final Inventario inventario;
    private final LocalDate fechaCompra;
    private final double precioTotal;

    public Compra(List<Boleto> boletos, List<Producto> productos, Pago pago, Inventario inventario) {
        if (boletos == null || boletos.isEmpty()) {
            throw new IllegalArgumentException("La compra debe incluir al menos un boleto.");
        }
        this.boletos = boletos;
        this.productos = productos;
        this.pago = pago;
        this.inventario = inventario;
        this.fechaCompra = LocalDate.now();
        this.precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        double total = 0.0;
        for (Boleto boleto : boletos) {
            total += boleto.getPrecio();
        }
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public boolean confirmarCompra() {
        if (pago.procesarPago(precioTotal)) {
            for (Producto producto : productos) {
                inventario.reducirStock(producto, 1);
            }
            return true;
        } else {
            System.out.println("No se pudo completar la compra.");
            return false;
        }
    }

    // Getters
    public List<Boleto> getBoletos() {
        return boletos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Pago getPago() {
        return pago;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}