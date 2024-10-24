package usuarios;
import java.time.LocalDate;
import usuarios.utils.Rol;

public abstract class Usuario {
    public String id;
    public String nombre;
    public String apellidos;
    public LocalDate fechaNacimiento;
    public String telefono;
    public String email;
    private final String contrasenia;
    public Rol rol; // enumm

    public Usuario(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    protected String mostrarInformacion() {
        String nombreCompleto = this.nombre + " " + this.apellidos;
        return String.format("ID: %s  |  Nombre: %s  |  Fecha de Nacimiento: %s  |  Telefono: %s  |  Email: %s",
                getId(), nombreCompleto, getFechaNacimiento(), getTelefono(), getEmail());
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Rol getRol() {
        return rol;
    }
}
