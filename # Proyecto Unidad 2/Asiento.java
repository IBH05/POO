public class Asiento {
    private final int numero;
    private final String tipo;
    private boolean disponible;
    private Boleto boleto; // Referencia al boleto asignado al asiento

    public Asiento(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar() {
        this.disponible = false;
    }

    // Getter para el boleto asignado
    public Boleto getBoleto() {
        return boleto;
    }

    // Método para cambiar la disponibilidad del asiento
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método para asignar un boleto al asiento y marcarlo como no disponible
    public void asignarBoleto(Boleto boleto) {
        this.boleto = boleto;
        this.disponible = false;
    }
}
