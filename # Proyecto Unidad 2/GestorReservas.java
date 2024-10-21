import java.util.List;

public class GestorReservas {
    private final List<Reservacion> reservas; 

    public GestorReservas(List<Reservacion> reservas) {
        this.reservas = reservas;
    }

    public void agregarReservacion(Reservacion reservacion) {
        reservas.add(reservacion);
    }

    public boolean cancelarReservacion(Reservacion reservacion) {
        return reservas.remove(reservacion);
    }

    public List<Reservacion> getReservas() {
        return reservas;
    }
}
