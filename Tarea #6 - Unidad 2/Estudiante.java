import java.util.ArrayList;

public class Estudiante {

    String nombre;
    int ID;

    public ArrayList<Curso> Cursolis=new ArrayList<>();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void AgregarCurso(Curso Cursolis) {
        this.Cursolis.add(Cursolis);
        System.out.println("Se agrego un nuevo curso.");

    }

    public void MostrarInfo(){

        for(Curso Curso : Cursolis){

            System.out.println("");
            System.out.println("Nombre del curso: "+ Curso.nombreCurso);
            System.out.println("ID del curso: "+ Curso.CodCurso);
            System.out.println("Instructor del curso: "+ Curso.nombreInstructor);

        }
    }

}