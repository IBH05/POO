public class Impuestos {

    public void calcularImpuestos(int ingresos) {
        System.out.println(ingresos + 0.15);
    }

    public void calcularImpuestos(int ingresos, Double porcentajeImpuestos) {
        System.out.println(ingresos * (porcentajeImpuestos / 100));
    }

    public void calcularImpuestos(Double dividendos, Double porcentajeImpuesto, Double exencion) {
        Double impuestos = dividendos * (porcentajeImpuesto / 100);

        if (impuestos > exencion) {
            System.out.println(impuestos - exencion);
        } else {
            System.out.println(0.0);
        }
    }
}
