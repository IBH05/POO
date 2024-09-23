package medicos;

public class Medico {
    public String id;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    private String telefono;
    private String rfc;

    public Medico(String id, String nombre, String apellidos, String fechaNacimiento, String telefono, String rfc) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRfc() {
        return rfc;
    }
    public String mostrarMedico() {
        return String.format("ID: %s Nombre: %s Apellido: %s Fecha Nacimiento: %s Num. Telefono: %s Rfc: %s",
                getId(), getNombre(), getApellidos(), getFechaNacimiento(), getTelefono(), getRfc());
    }


}