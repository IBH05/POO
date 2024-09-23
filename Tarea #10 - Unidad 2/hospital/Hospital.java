package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import medicos.Medico;
import pacientes.Paciente;

public class Hospital {

    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();
    Random random = new Random();

    public void registrarPacientes(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsulta(Consulta consulta) {
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El médico no tiene disponibilidad para esa fecha");
            return;

        }

        this.listaConsultas.add(consulta);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    public void mostrarPacientes() {
        System.out.println("\n** Pacientes del Hospital **");
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }
    public void mostrarMedicos() {
        System.out.println("\n** Medicos del Hospital **");
        for (Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarMedico());
        }
    }
    public void mostrarConsultorio(){
        System.out.println("** Consultorios del Hospital **");
        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarConsultorio());
        }
    }
    public void mostrarPacienteID(String id) {
        Optional<Paciente> pacienteEncontrado = this.listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst();

        if (pacienteEncontrado.isPresent()) {
            System.out.println(pacienteEncontrado.get().mostrarDatos());
        } else {
            System.out.println("No se encontro el paciente");
        }
    }

    public String generarIdPaciente() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacienteMasUno = this.listaPacientes.size()+1;
        int numeroAleatorio = random.nextInt();

        return String.format("P%d%d%d%d", anioActual, mesActual, longitudPacienteMasUno, numeroAleatorio);
    }

    public String generarIdMedico(String apellidoMedico, String fechaNaciMedico){
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int longitudMedicoMasUno = this.listaMedicos.size() + 1;
        int numeroAleatorio = random.nextInt(700000+50);
        char letra1 = apellidoMedico.charAt(0);
        letra1= Character.toUpperCase(letra1);
        char letra2 = apellidoMedico.charAt(1);
        letra2= Character.toUpperCase(letra2);
        String letrasApellidos = letra1 + "" + letra2;
        char ultimoDigitoNaci= fechaNaciMedico.charAt(fechaNaciMedico.length() - 1);

        return String.format("M%s%c%d%d%d",letrasApellidos, ultimoDigitoNaci, anioActual, numeroAleatorio,longitudMedicoMasUno);
    }

    public String generarIdConsultorio(){
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        int diaActual = fecha.getDayOfMonth();
        int longitudConsultorio = this.listaConsultorios.size() + 1;
        int NumAleatorio = random.nextInt(500000);
        return String.format("C%d%d%d%d",longitudConsultorio,diaActual,anioActual,NumAleatorio);
    }

    public void mostrarMedicoPorId(String id){
        Optional<Medico> medicoEncontrado=this.listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst();
        if (medicoEncontrado.isPresent()) {
            System.out.println(medicoEncontrado.get().mostrarMedico());
        }else{
            System.out.println("No se encontro el medico");
        }
    }

    public void mostrarConsultorioPorId(String id){
        Optional<Consultorio> consultorioEncontrado =listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(id)).findFirst();
        if (consultorioEncontrado.isPresent()) {
            System.out.println(consultorioEncontrado.get().mostrarConsultorio());
        }else {
            System.out.println("No se encontro el consultorio");
        }
    }
}