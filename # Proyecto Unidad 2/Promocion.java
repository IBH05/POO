public class Promocion {
    private boolean descuentoCumpleaniosActivo;
    private double descuentoVIP;      // Descuento en boletos VIP
    private double descuentoPremium;  // Descuento en boletos Premium

    // Constructor por defecto con descuentos predefinidos
    public Promocion() {
        this.descuentoCumpleaniosActivo = true; // Activar por defecto
        this.descuentoVIP = 0.2; // 20% de descuento en boletos VIP
        this.descuentoPremium = 0.15; // 15% de descuento en boletos Premium
    }

    // Método para aplicar descuento basado en el tipo de asiento y si el cliente cumple años
    public double aplicarDescuento(Cliente cliente, Asiento asiento, double precio) {
        double descuento = 0.0;

        // Verifica si el cliente cumple años y si la promoción está activa
        if (descuentoCumpleaniosActivo && cliente.tieneDescuentoCumpleanios()) {
            if (asiento.getTipo().equals("VIP")) {
                descuento = descuentoVIP;
            } else if (asiento.getTipo().equals("Premium")) {
                descuento = descuentoPremium;
            }
        }

        // Retorna el precio con el descuento aplicado, si es aplicable
        return precio * (1 - descuento);
    }

    // Activar/desactivar la promoción de cumpleaños
    public void activarDescuentoCumpleanios(boolean activar) {
        this.descuentoCumpleaniosActivo = activar;
    }

    // Configurar el porcentaje de descuento para boletos VIP
    public void setDescuentoVIP(double descuentoVIP) {
        this.descuentoVIP = descuentoVIP;
    }

    // Configurar el porcentaje de descuento para boletos Premium
    public void setDescuentoPremium(double descuentoPremium) {
        this.descuentoPremium = descuentoPremium;
    }

    // Método para mostrar el estado actual de las promociones
    public void mostrarPromociones() {
        System.out.println("Promoción de cumpleaños activa: " + descuentoCumpleaniosActivo);
        System.out.println("Descuento VIP: " + (descuentoVIP * 100) + "%");
        System.out.println("Descuento Premium: " + (descuentoPremium * 100) + "%");
    }
}
