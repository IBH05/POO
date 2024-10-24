package usuarios.medicos;

import java.time.LocalDate;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Medico  extends Usuario {
    private final String rfc;

    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email, String rfc, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, email, contrasenia, Rol.MEDICO);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + String.format("  |  RFC:  %s", getRfc());
    }
}