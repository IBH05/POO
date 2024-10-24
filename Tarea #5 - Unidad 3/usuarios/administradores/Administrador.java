package usuarios.administradores;

import java.time.LocalDate;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Administrador extends Usuario{
    public double sueldo;
    public String rfc;
    public int antiguedad;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email, String contrasenia, double sueldo, String rfc, int antiguedad) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, email, contrasenia, Rol.ADMINISTRADOR);
        this.sueldo = sueldo;
        this.rfc = rfc;
        this.antiguedad = antiguedad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public String getRfc() {
        return rfc;
    }

        public String mostrarDatos() {
        return String.format("Id: %s  |  Nombre: %s  |  Apellidos: %s  |  Fecha de Nacimiento: %s  |  Teléfono: %s  |  Email: %s  |  Sueldo: %f  |  RFC: %s  |  Antiguedad: %d",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getEmail(),  // Este campo debe estar vinculado a %s
                getSueldo(), // %f aquí para el sueldo (número flotante)
                getRfc(),
                getAntiguedad()
        );
    }
}
