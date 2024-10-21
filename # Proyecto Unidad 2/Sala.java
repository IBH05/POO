import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sala {
    private final int numero;
    private final int capacidad; // Capacidad de la sala
    private final List<Asiento> asientos;
    private Pelicula pelicula; // Película asignada a la sala
    private LocalDateTime horario;

    public Sala(int numero, int capacidad, int vip, int premium) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.asientos = new ArrayList<>();

        for (int i = 1; i <= capacidad; i++) {
            if (i <= vip) {
                asientos.add(new Asiento(i, "VIP"));
            } else if (i <= vip + premium) {
                asientos.add(new Asiento(i, "Premium"));
            } else {
                asientos.add(new Asiento(i, "Normal"));
            }
        }
    }

    // Método para asignar una película con su horario a la sala
    public void asignarPelicula(Pelicula pelicula, LocalDateTime horario) {
        this.pelicula = pelicula;
        this.horario = horario;
        System.out.println("Película '" + pelicula.getTitulo() + "' asignada a la Sala " + numero + " en el horario: " + horario);
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public int getNumero() {
        return numero;
    }

    // Mostrar asientos disponibles
    public void mostrarAsientosDisponibles() {
        System.out.println("Asientos disponibles en la Sala " + numero + ":");
        for (Asiento asiento : asientos) {
            if (asiento.isDisponible()) {
                System.out.println("Asiento " + asiento.getNumero() + " - " + asiento.getTipo());
            }
        }
    }

    // Método para contar boletos vendidos por tipo (VIP, Premium, Normal)
    public int contarBoletosPorTipo(String tipo) {
        int count = 0;
        for (Asiento asiento : asientos) {
            if (asiento.getBoleto() != null && asiento.getBoleto().getTipoBoleto().equals(tipo)) {
                count++;
            }
        }
        return count;
    }

    // Método para calcular ingresos de la sala
    public double calcularIngresos() {
        double total = 0.0;
        for (Asiento asiento : asientos) {
            if (asiento.getBoleto() != null) {
                total += asiento.getBoleto().getPrecio();
            }
        }
        return total;
    }

    // Método para verificar si un asiento está disponible
    public boolean verificarDisponibilidad(int numeroAsiento) {
        return asientos.get(numeroAsiento - 1).isDisponible();
    }

    // Método para reservar un asiento
    public void reservarAsiento(int numeroAsiento) {
        asientos.get(numeroAsiento - 1).reservar();
    }
}
