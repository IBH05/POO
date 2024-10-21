public class Pago {
    private String metodoPago;

    // Constructor
    public Pago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    // Método para validar el tipo de pago
    public boolean validarMetodoPago() {
        if (metodoPago.equalsIgnoreCase("Tarjeta de crédito") || 
            metodoPago.equalsIgnoreCase("Tarjeta de débito") || 
            metodoPago.equalsIgnoreCase("Efectivo")) {
            return true;
        } else {
            System.out.println("Método de pago no válido: " + metodoPago);
            return false;
        }
    }

    // Método para procesar el pago (simulación)
    public boolean procesarPago(double monto) {
        if (validarMetodoPago()) {
            // Simular la aprobación del pago
            System.out.println("Procesando pago de $" + monto + " usando " + metodoPago + "...");
            System.out.println("Pago aprobado.");
            return true;
        } else {
            System.out.println("No se pudo procesar el pago.");
            return false;
        }
    }

    // Getters y setters
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
