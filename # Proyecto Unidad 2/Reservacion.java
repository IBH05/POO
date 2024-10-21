public class Reservacion {
    private final Cliente cliente;
    private final Asiento asiento;
    private final Pelicula pelicula;
    private final Sala sala;

    public Reservacion(Cliente cliente, Asiento asiento, Pelicula pelicula, Sala sala) {
        this.cliente = cliente;
        this.asiento = asiento;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }
}
