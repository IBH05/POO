public class Main {
    public static void main(String[] args) {

        String nombre;
        int ID;

        Estudiante estudiante=new Estudiante();
        estudiante.setNombre("Isauro Bucio Hurtado");
        estudiante.setID(20002324);

        Estudiante estudiante1=new Estudiante();
        estudiante1.setNombre("Maria Fernanda Lopez Ortega");
        estudiante1.setID(20002924);

        Estudiante estudiante2=new Estudiante();
        estudiante2.setNombre("Juan Pablo Ramirez Torres");
        estudiante2.setID(20002925);

        Curso curso=new Curso("Calculo Integral", "Aburto Bedolla Alejandro", 3535);
        Curso curso1=new Curso("POO", "Eder Rivera Cisneros", 6546);
        Curso curso2=new Curso("Ingles", "Federico Esteban Cortes Estrada", 3536);
        Curso curso3=new Curso("Algebra linela", "Erick Mauricio Cuevas Ramirez", 53453);

        estudiante2.AgregarCurso(curso);
        estudiante2.AgregarCurso(curso1);
        estudiante.AgregarCurso(curso2);
        estudiante1.AgregarCurso(curso);
        estudiante2.AgregarCurso(curso3);

        System.out.println("‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗");
        System.out.println("");
        System.out.println("Nombre del estudiante 1: "+estudiante.getNombre());
        System.out.println("ID del alumno: "+ estudiante.getID());
        estudiante.MostrarInfo();
        System.out.println("‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗");
        System.out.println("");
        System.out.println("Nombre del estudiante 2: "+estudiante1.getNombre());
        System.out.println("ID del alumno: "+ estudiante1.getID());
        estudiante1.MostrarInfo();
        System.out.println("‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗");
        System.out.println("");
        System.out.println("Nombre del estudiante 3: "+estudiante2.getNombre());
        System.out.println("ID del alumno: "+ estudiante2.getID());
        estudiante2.MostrarInfo();

    }
}