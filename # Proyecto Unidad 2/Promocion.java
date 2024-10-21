public class Promocion {
    private boolean descuentoCumpleaniosActivo;
    private double descuentoVIP;
    private double descuentoPremium;  

    public Promocion() {
        this.descuentoCumpleaniosActivo = true; 
        this.descuentoVIP = 0.2;
        this.descuentoPremium = 0.15; 
    }

    public double aplicarDescuento(Cliente cliente, Asiento asiento, double precio) {
        double descuento = 0.0;

        if (descuentoCumpleaniosActivo && cliente.tieneDescuentoCumpleanios()) {
            if (asiento.getTipo().equals("VIP")) {
                descuento = descuentoVIP;
            } else if (asiento.getTipo().equals("Premium")) {
                descuento = descuentoPremium;
            }
        }

        return precio * (1 - descuento);
    }

        public void activarDescuentoCumpleanios(boolean activar) {
        this.descuentoCumpleaniosActivo = activar;
    }

    public void setDescuentoVIP(double descuentoVIP) {
        this.descuentoVIP = descuentoVIP;
    }

    public void setDescuentoPremium(double descuentoPremium) {
        this.descuentoPremium = descuentoPremium;
    }

     public void mostrarPromociones() {
        System.out.println("Promoción de cumpleaños activa: " + descuentoCumpleaniosActivo);
        System.out.println("Descuento VIP: " + (descuentoVIP * 100) + "%");
        System.out.println("Descuento Premium: " + (descuentoPremium * 100) + "%");
    }
}
