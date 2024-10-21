import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private final String nombre;
    private final String apellidos;
    private final String curp;
    private final LocalDate fechaNacimiento;
    private final String direccion; // Campo no usado
    private final List<Compra> compras;

    public Cliente(String nombre, String apellidos, String curp, LocalDate fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion; // Se inicializa, pero no se usa
        this.compras = new ArrayList<>();
    }

    // Obtener la CURP
    public String getCurp() {
        return curp;
    }

    public List<Compra> getCompras() {
        return compras;  // Devolver el historial de compras
    }

    // Método que revisa si el cliente cumple años hoy
    public boolean tieneDescuentoCumpleanios() {
        LocalDate hoy = LocalDate.now();
        return hoy.getMonth() == fechaNacimiento.getMonth() && hoy.getDayOfMonth() == fechaNacimiento.getDayOfMonth();
    }

    // Método para obtener la dirección
    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    // Mostrar información del cliente
    public String mostrarInformacion() {
        return "Cliente: " + nombre + " " + apellidos + ", CURP: " + curp + ", Nacimiento: " + fechaNacimiento;
    }
}
