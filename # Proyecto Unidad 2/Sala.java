import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sala {
    private final int numero;
    private final int capacidad;
    private final List<Asiento> asientos;
    private Pelicula pelicula;
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

    public void mostrarAsientosDisponibles() {
        System.out.println("Asientos disponibles en la Sala " + numero + ":");
        for (Asiento asiento : asientos) {
            if (asiento.isDisponible()) {
                System.out.println("Asiento " + asiento.getNumero() + " - " + asiento.getTipo());
            }
        }
    }

    public int contarBoletosPorTipo(String tipo) {
        int count = 0;
        for (Asiento asiento : asientos) {
            if (asiento.getBoleto() != null && asiento.getBoleto().getTipoBoleto().equals(tipo)) {
                count++;
            }
        }
        return count;
    }

    public double calcularIngresos() {
        double total = 0.0;
        for (Asiento asiento : asientos) {
            if (asiento.getBoleto() != null) {
                total += asiento.getBoleto().getPrecio();
            }
        }
        return total;
    }

    public boolean verificarDisponibilidad(int numeroAsiento) {
        return asientos.get(numeroAsiento - 1).isDisponible();
    }

    public void reservarAsiento(int numeroAsiento) {
        asientos.get(numeroAsiento - 1).reservar();
    }
}
