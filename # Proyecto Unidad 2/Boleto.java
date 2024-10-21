public class Boleto {
    private final Cliente cliente;
    private final Pelicula pelicula;
    private final Sala sala;
    private final double precio;
    private final boolean tieneDescuento;
    private final String tipoBoleto;
    private Asiento asiento;

    public Boleto(Cliente cliente, Pelicula pelicula, Sala sala, Asiento asiento, double precio, boolean tieneDescuento, String tipoBoleto) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.precio = precio;
        this.tieneDescuento = tieneDescuento;
        this.tipoBoleto = tipoBoleto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isTieneDescuento() {
        return tieneDescuento;
    }

    public String getTipoBoleto() {
        return tipoBoleto;
    }

    public void setAsiento(Asiento nuevoAsiento) {
        this.asiento = nuevoAsiento;
    }

    public Asiento getAsiento() {
        return asiento;
    }
}
