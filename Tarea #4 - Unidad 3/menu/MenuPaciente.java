package menu;

import hospital.Hospital;
import java.util.Scanner;
import usuarios.pacientes.Paciente;

public class MenuPaciente {

    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {

            System.out.println("\n----SISTEMA DEL HOSPITAL----\n");
            System.out.println("1. Ver mis consultas.");
            System.out.println("2. Ver mi infomación personal.");
            System.out.println("3. Salir");
            int opc = leer.nextInt();
            return opc;

    }
    public void procesarDatosMenu(int opc, Paciente paciente, Hospital hospital){

            switch (opc) {
                case 1 -> {
                    System.out.println("\n--------MOSTRAR CONSULTAS--------\n");
                    hospital.verConsultasPaciente(paciente.getId());
            }

                case 2 -> {
                    System.out.println("\n---------SU INFORMACIÓN PERSONAL--------\n");
                    hospital.mostrarPacientePorID(paciente.getId());
            }

                case 3 -> System.out.println("\nSaliendo...\n");

                default -> System.out.println("Opción invalida. Intenta de nuevo.");
            }
        }
}
