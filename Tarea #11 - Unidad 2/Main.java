import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\n*** SISTEMA HOSPITAL*");
            System.out.println("\n** Menu **");
            System.out.println("1.- Registrar Pacientes");
            System.out.println("2.- Registrar Medicos");
            System.out.println("3.- Registrar Consultorio");
            System.out.println("4.- Registrar Consulta");
            System.out.println("5.- Mostrar Pacientes");
            System.out.println("6.- Mostrar Medicos");
            System.out.println("7.- Mostrar Consultas");
            System.out.println("8.- Mostrar Consultorio");
            System.out.println("9.- Buscar Paciente por Id");
            System.out.println("10. Buscar Medico por Id");
            System.out.println("11. Buscar Consultorio por Id");
            System.out.println("12. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--Seleccionaste la opción de registrar pacientes--");

                    String id = hospital.generarIdPaciente();

                    System.out.print("\nIngresa el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingresa el apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingresa el año de nacimiento del paciente: ");
                    int anio = scanner.nextInt();

                    System.out.print("Ingresa el mes de nacimiento del paciente: ");
                    int mes = scanner.nextInt();

                    System.out.print("Ingresa el día de nacimiento del paciente: ");
                    int dia = scanner.nextInt();

                    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

                    System.out.print("Ingresa el tipo de sangre: ");
                    String tipoSangre = scanner.nextLine();

                    scanner.nextLine();

                    System.out.print("Ingresa el sexo: ");
                    String sexo2 = scanner.nextLine();
                    char sexo = sexo2.charAt(0);

                    System.out.print("Ingresa el numero de telefono: ");
                    String telefono = scanner.nextLine();

                    Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, tipoSangre, sexo, telefono);
                    hospital.registrarPacientes(paciente);

                    System.out.println("Paciente registrado exitosamente");
                    break;
                case 2:
                    System.out.println("\n--Seleccionaste la opción de registrar medicos--");

                    System.out.print("\nIngresa el nombre del medico: ");
                    String nombreMedico = scanner.nextLine();

                    System.out.print("Ingresa el apellido: ");
                    String apellidoMedico = scanner.nextLine();

                    System.out.print("Ingresa el año de nacimiento del médico: ");
                    int anioMedico = scanner.nextInt();

                    System.out.print("Ingresa el mes de nacimiento del médico: ");
                    int mesMedico = scanner.nextInt();

                    System.out.print("Ingresa el día de nacimiento del médico: ");
                    int diaMedico = scanner.nextInt();

                    LocalDate fechaNaciMedico = LocalDate.of(anioMedico, mesMedico, diaMedico);

                    System.out.print("Ingresa el telefono del medico: ");
                    String telMedico = scanner.nextLine();

                    scanner.nextLine();

                    System.out.print("Ingresa el rfc del medico: ");
                    String rfcMedico = scanner.nextLine();

                    String idMedico= hospital.generarIdMedico(apellidoMedico, String.valueOf(fechaNaciMedico.getYear()));

                    Medico medico = new Medico(idMedico,nombreMedico,apellidoMedico,fechaNaciMedico,telMedico,rfcMedico);
                    hospital.registrarMedico(medico);

                    System.out.println("Medico registrado exitosamente");
                    break;
                case 3:
                    System.out.println("\n--Seleccionaste la opción de registrar consultorio--");

                    String idConsultorio=hospital.generarIdConsultorio();

                    System.out.print("\nIngrese el piso del consultorio: ");
                    int pisoConsultorio =scanner.nextInt();

                    System.out.print("Ingrese el numero de consultorio: ");
                    int numeroConsultorio = scanner.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio,pisoConsultorio,numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);

                    System.out.println("Consultorio registrado exitosamente");
                    break;
                case 4:
                    System.out.println("\n--Seleccionaste la opción de registrar consulta--");

                    int idConsulta = 1;

                    System.out.print("\nIngresa el día de la consnulta deseada: ");
                    int diaConsulta = scanner.nextInt();

                    System.out.print("Ingresar el mes de la consullta deseada: ");
                    int mesConsulta = scanner.nextInt();

                    System.out.print("Ingresa el año de la consulta deseada: ");
                    int anioConsulta = scanner.nextInt();

                    System.out.print("Ingresa la hora de la consulta: ");
                    int horaConsulta = scanner.nextInt();

                    System.out.print("Ingresa los minutos de la consulta: ");
                    int minutosConsulta = scanner.nextInt();

                    LocalDateTime fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                    System.out.print("Ingresa el id del paciente: ");
                    String pacienteId = scanner.nextLine();

                    Paciente pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);

                    scanner.nextLine();

                    System.out.print("Ingresa el id del medico: ");
                    String medicoId = scanner.nextLine();

                    Medico medicoConsulta = hospital.obtenerMedicoPorId(medicoId);

                    System.out.print("Ingresa el id del consultorio: ");
                    String consultorioId = scanner.nextLine();

                    Consultorio consultorioConsulta = hospital.obtenerConsultorioPorId(consultorioId);

                    Consulta consulta = new Consulta(idConsulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);
                    hospital.registrarConsulta(consulta);

                    System.out.println("Consulta registrada exitosamente");
                    break;
                case 5:
                    System.out.println("\n--Seleccionaste la opción de mostrar pacientes--");
                    hospital.mostrarPacientes();
                    break;
                case 6:
                    System.out.println("\n--Seleccionaste la opción de mostrar medicos--");
                    hospital.mostrarMedicos();
                    break;
                case 7:
                    System.out.println("\n--Seleccionaste la opción de mostrar consultas--");
                    hospital.mostrarConsultas();
                    return;
                case 8:
                    System.out.println("\n--Seleccionaste la opción de mostrar consultorios--");
                    hospital.mostrarConsultorio();
                    break;
                case 9:
                    System.out.println("\n--Seleccionaste la opción de buscar Paciente mediante la ID--");

                    System.out.println("\nIngresa el Id del paciente que deseas buscar");
                    String idPaciente = scanner.nextLine();

                    hospital.mostrarPacienteID(idPaciente);
                    break;
                case 10:
                    System.out.println("\n--Seleccionaste la opción de buscar medicos mediante la ID--");

                    System.out.println("Ingresa el Id del medico que deseas buscar: ");
                    String idMedico2 = scanner.nextLine();

                    hospital.mostrarMedicoPorId(idMedico2);
                    break;
                case 11:
                    System.out.println("\n--Seleccionaste la opción de buscar consultorio mediante la ID--");

                    System.out.println("Ingresa el Id del consultorio que deseas buscar: ");
                    String idConsultorio2= scanner.nextLine();

                    hospital.mostrarConsultorioPorId(idConsultorio2);
                    break;
                case 12:
                    System.out.println("\n--Seleccionaste la opcion de salir--");
                    System.out.println("*HASTA LUEGO*");
                    return;
            }
        }
    }
}