public class PruebaCoche {
    public static void main(String[]args){
        Coche coche1 = new Coche("Chevrolet", "Camaro", 2020);
        Coche coche2 = new Coche("Tesla", "Model S", 2022);
        Coche coche3 = new Coche("BMW", "Series 3", 2021);
        coche1.mostrarInformacion();
        coche2.mostrarInformacion();
        coche3.mostrarInformacion();

        int añoActual=2024;
        System.out.println("Edad del coche 1: "+ coche1.calcularEdadCoche
        (añoActual)+ "años");
        System.out.println("Edad del coche 2: "+coche2.calcularEdadCoche
        (añoActual)+ " años");
        System.out.println("Edad del coche 3: "+ coche3.calcularEdadCoche
        (añoActual)+"años");

    }
}
