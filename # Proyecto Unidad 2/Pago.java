public class Pago {
    private String metodoPago;

    public Pago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

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

    public boolean procesarPago(double monto) {
        if (validarMetodoPago()) {
            System.out.println("Procesando pago de $" + monto + " usando " + metodoPago + "...");
            System.out.println("Pago aprobado.");
            return true;
        } else {
            System.out.println("No se pudo procesar el pago.");
            return false;
        }
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
