public class Empleado {

    public void calcularSalario(double sueldoBase) {
        System.out.println("El sueldo del empleado es: " + sueldoBase);
    }

    public void calcularSalario(double sueldoBase, double bonificacion) {
        System.out.println("El sueldo mas bonificacion del empleado es: " + (sueldoBase + bonificacion));
    }

    public void calcularSalario(double sueldoBase, double bonificacion, double horasExtra) {
        System.out.println("El sueldo mas bonificacion mas las horas extras del empleado es: " + (sueldoBase + bonificacion + (horasExtra * 20)));
    }
}
