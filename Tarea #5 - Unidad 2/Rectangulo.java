public class Rectangulo {

    public void calcularArea(int base, int altura) {
        System.out.println("Area con valores enteros: " + (base * altura));
    }

    public void calcularArea(Double base, Double altura) {
        System.out.println("Area con valores decimales: " + (base * altura));
    }

    public void calcularPerimetro(int base, int altura) {
        System.out.println("Perimetro con valores enteros: " + (2 * (base + altura)));
    }

    public void calcularPerimetro(Double base, Double altura) {
        System.out.println("Perimetro con valores decimales: " + (2 * (base + altura)));
    }
}
