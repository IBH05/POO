package menu;

import hospital.Hospital;
import java.util.Scanner;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;

public class Menu {

    private final Scanner leer= new Scanner(System.in);
    private Hospital hospital= new Hospital();

    public void login(){
        int intentosMaximos=5, intentosUsuario=0;

        System.out.println("\nBienvenido.\n");

        while(intentosUsuario<intentosMaximos){

            System.out.print("Ingresa tu ID: ");
            String usuario=leer.next();
            System.out.print("Ingresa tu contraseña: ");
            String contraseña=leer.next();


            Usuario usuarioEnSesion = hospital.validadInicioSesion(usuario, contraseña);

           if (usuarioEnSesion instanceof Usuario){

               if (null == usuarioEnSesion.getRol()){
                   
                   Admin adminEnSesion = (Admin) usuarioEnSesion;
                   MenuAdministrador menuAdministrador = new MenuAdministrador();
                   // this.mostrarMenuAdmin(usuarioEnSesion);

                   int opc=0;
                   while(opc!=13) {
                       opc = menuAdministrador.mostrarMenu();
                       menuAdministrador.procesarDatosMenu(opc, adminEnSesion, hospital);
                       intentosUsuario = 0;
                   }
               }
               else switch (usuarioEnSesion.getRol()) {
                    case PACIENTE ->                         {
                            Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                            MenuPaciente menuPaciente = new MenuPaciente();
                            // this.mostrarMenuPaciente(pacienteEnSesion);
                            int opc=0;
                            while(opc!=3) {
                                opc = menuPaciente.mostrarMenu();
                                menuPaciente.procesarDatosMenu(opc, pacienteEnSesion, hospital);
                                intentosUsuario = 0;
                            }                               }
                    case MEDICO ->                         {
                            Medico medicoEnSesion = (Medico) usuarioEnSesion;
                            MenuMedico menuMedico = new MenuMedico();
                            // this.mostrarMenuMedico(medicoEnSesion);
                            int opc=0;
                            while(opc!=7) {
                                opc = menuMedico.mostrarMenu();
                                menuMedico.procesarDatosMenu(opc, medicoEnSesion, hospital);
                                intentosUsuario = 0;
                            }                               }
                    default ->                         {
                            Admin adminEnSesion = (Admin) usuarioEnSesion;
                            MenuAdministrador menuAdministrador = new MenuAdministrador();
                            // this.mostrarMenuAdmin(usuarioEnSesion);
                            int opc=0;
                            while(opc!=13) {
                                opc = menuAdministrador.mostrarMenu();
                                menuAdministrador.procesarDatosMenu(opc, adminEnSesion, hospital);
                                intentosUsuario = 0;
                            }                               }
                }
           }
           else{

               intentosUsuario = mostrarErrorLogin(intentosUsuario);
           }
        }

        System.out.println("\nDemasiados intentos fallidos :(\n");
    }

    private int mostrarErrorLogin(int intentosUsuario){

        System.out.println("\nUsuario o contraseña incorrectos. Intenta de nuevo.");
        return intentosUsuario + 1;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
