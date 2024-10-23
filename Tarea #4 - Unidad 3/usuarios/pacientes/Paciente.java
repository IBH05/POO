package usuarios.pacientes;
import expedientes.Expediente;
import java.time.LocalDate;
import java.util.ArrayList;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Paciente extends Usuario {

    ArrayList<Expediente> expedientes = new ArrayList<>();
    public String tipoSangre;
    public String sexo;
    public Expediente expediente;

    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento,
                    String telefono, String tipoSangre, String sexo, String contraseña) {

        super(id, nombre, apellidos,fechaNacimiento, telefono, contraseña, Rol.PACIENTE);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;

    }
    @Override
    public String mostrarInformacion(){
       String datosPacientes = String.format(", Tipo de Sangre: %s, Sexo: %s", this.tipoSangre, this.sexo);
        return super.mostrarInformacion()+datosPacientes;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void registrarExpediente(Expediente expediente){

        expedientes.add(expediente);

        }
}
