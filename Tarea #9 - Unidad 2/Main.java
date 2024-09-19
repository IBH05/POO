import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*** BIENVENIDO ***");
            System.out.println("\n** Menu **");
            System.out.println("1.- Mostrar Pacientes");
            System.out.println("2.- Mostrar Medicos");
            System.out.println("3.- Mostrar Consultas");
            System.out.println("4.- Mostrar Consultorio");
            System.out.println("5.- Registrar Pacientes");
            System.out.println("6.- Registrar Medicos");
            System.out.println("7.- Registrar Consulta");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                System.exit(0);

            }
        }
    }
}