import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int op;

        System.out.println("\n===============================");
        System.out.println("          Seleccione una opcion");
        System.out.println("===============================");
        System.out.println("1: Calculadora de Rectangulo");
        System.out.println("2: Calcular Salario");
        System.out.println("3: Calcular Impuestos");
        System.out.print("Ingrese el numero de la opcion deseada:\n");
        op = leer.nextInt();

        switch (op) {
            case 1:
                Rectangulo rectangulo = new Rectangulo();
                System.out.println("\nCalculadora de Rectangulo");
                rectangulo.calcularPerimetro(12, 7);
                rectangulo.calcularPerimetro(20.5, 11.3);
                rectangulo.calcularArea(8, 15);
                rectangulo.calcularArea(14.7, 9.4);
                break;

            case 2:
                Empleado empleado = new Empleado();
                System.out.println("\nCalcular Salario - Empleado");
                empleado.calcularSalario(4200.00); 
                empleado.calcularSalario(4200.00, 1800.75);
                empleado.calcularSalario(4200.00, 1800.75, 6.0);
                break;

            case 3:
                Impuestos impuestos = new Impuestos();
                impuestos.calcularImpuestos(9500);           
                impuestos.calcularImpuestos(9500, 8.5);       
                impuestos.calcularImpuestos(12000.75, 8.5, 750.00);
                break;

            default:
                System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                break;
        }

        leer.close();
    }
}
