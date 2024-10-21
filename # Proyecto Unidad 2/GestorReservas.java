import java.util.List;

public class GestorReservas {
    private final List<Reservacion> reservas; // Marcar como final

    // Constructor
    public GestorReservas(List<Reservacion> reservas) {
        this.reservas = reservas;
    }

    // Método para agregar una reservación
    public void agregarReservacion(Reservacion reservacion) {
        reservas.add(reservacion);
    }

    // Método para cancelar una reservación
    public boolean cancelarReservacion(Reservacion reservacion) {
        return reservas.remove(reservacion);
    }

    // Obtener todas las reservaciones
    public List<Reservacion> getReservas() {
        return reservas;
    }
}
