public class Asiento {
    private final int numero;
    private final String tipo;
    private boolean disponible;
    private Boleto boleto;

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

    public Boleto getBoleto() {
        return boleto;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void asignarBoleto(Boleto boleto) {
        this.boleto = boleto;
        this.disponible = false;
    }
}
