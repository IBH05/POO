import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private final String nombre;
    private final String apellidos;
    private final String curp;
    private final LocalDate fechaNacimiento;
    private final String direccion;
    private final List<Compra> compras;

    public Cliente(String nombre, String apellidos, String curp, LocalDate fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.compras = new ArrayList<>();
    }

    public String getCurp() {
        return curp;
    }

    public List<Compra> getCompras() {
        return compras;  
    }

    public boolean tieneDescuentoCumpleanios() {
        LocalDate hoy = LocalDate.now();
        return hoy.getMonth() == fechaNacimiento.getMonth() && hoy.getDayOfMonth() == fechaNacimiento.getDayOfMonth();
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String mostrarInformacion() {
        return "Cliente: " + nombre + " " + apellidos + ", CURP: " + curp + ", Nacimiento: " + fechaNacimiento;
    }
}
