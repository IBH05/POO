package usuarios.pacientes;

import expediente.Expediente;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Usuario {
    public String tipoSangre;
    public char sexo;
    public ArrayList<Expediente> expedientes;

    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono, String email, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, email, contrasenia, Rol.PACIENTE);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + String.format("  |  Tipo de Sangre %s  |  Sexo:  %s", getTipoSangre(), getSexo());
    }

    public void registrarExpediente(Expediente expediente) {
        this.expedientes.add(expediente);
    }
}