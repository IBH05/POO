public class Ticket {
    private final Compra compra;

    public Ticket(Compra compra) {
        this.compra = compra;
    }

    public void generarTicket() {
        System.out.println("===== TICKET DE COMPRA =====");
        System.out.println("Fecha de compra: " + compra.getFechaCompra());
        System.out.println("Método de pago: " + compra.getPago().getMetodoPago());

        System.out.println("\n=== Boletos ===");
        for (Boleto boleto : compra.getBoletos()) {
            System.out.println("Película: " + boleto.getPelicula().getTitulo());
            System.out.println("Sala: " + boleto.getSala().getNumero());
            System.out.println("Asiento: " + boleto.getAsiento().getNumero() + " (" + boleto.getAsiento().getTipo() + ")");
            System.out.println("Precio: $" + boleto.getPrecio());
            System.out.println("Tiene descuento: " + (boleto.isTieneDescuento() ? "Sí" : "No"));
            System.out.println("----------------------------");
        }

        System.out.println("\n=== Productos Adicionales ===");
        for (Producto producto : compra.getProductos()) {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("----------------------------");
        }

        System.out.println("\nTotal pagado: $" + compra.getPrecioTotal());
        System.out.println("==============================");
    }
}
