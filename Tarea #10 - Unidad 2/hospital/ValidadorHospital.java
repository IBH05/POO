package hospital;

import consultas.Consulta;
import java.util.ArrayList;

public class ValidadorHospital {
    public boolean validarDisponibilidadEnFechaConsulta(String fecheDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().equals(fecheDeseada) && numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()) {
                return false;
            }
        }

        return true;
    }

    public boolean validarDisponibilidadMedico(String fechaDeseada, String idMedico, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            if (consulta.getFechaHora().equals(fechaDeseada) && consulta.getMedico().getId() == idMedico) {
                return false;
            }
        }

        return true;
    }

}