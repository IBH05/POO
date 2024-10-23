package expedientes;
import consultas.Consulta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public final class Expediente {
    Random ran = new Random();

    public ArrayList<Consulta> Consulta = new ArrayList<>();

    public String id, observaciones;
    public Consulta consulta;
    public LocalDateTime fechaExpediente;

    public Expediente(Consulta consulta, String observaciones) {
        this.consulta = consulta;
        this.id = generarID();
        this.observaciones = observaciones;
        this.fechaExpediente = LocalDateTime.now();
    }
    public String generarID() {
        //P(paciente)-(año actual)-(mes actual)-longitud de la lista usuarios.pacientes + 1)-(1-100000)

        LocalDate fecha = LocalDate.now();
        int añoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int numeroAleatorio = ran.nextInt(1, 100000);

        String id = String.format("P%d%d%d", añoActual, mesActual, numeroAleatorio).toUpperCase();
        return id;
    }
}
