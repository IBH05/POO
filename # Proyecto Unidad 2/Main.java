import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    
    private static Cine cine;

    public static void main(String[] args) {
        Inventario inventario = new Inventario();  // Create Inventario instance
        inicializarCine();  // Initialize cine
        InterfazUsuario interfaz = new InterfazUsuario(cine, inventario);  // Pass inventario
        interfaz.mostrarMenuPrincipal();  // Start the application
    }
    
    // Initialize salas, peliculas, and cine
    private static void inicializarCine() {
        List<Sala> salas = new ArrayList<>();
        Sala sala1 = new Sala(1, 30, 10, 5);  // Sala 1: 10 VIP, 5 Premium
        Sala sala2 = new Sala(2, 50, 15, 10);  // Sala 2: 15 VIP, 10 Premium

        Pelicula pelicula1 = new Pelicula("1", "Inception", "Ciencia Ficción", "PG-13", "Un ladrón que roba secretos a través de los sueños...", 148, "C:\\Users\\PC\\Downloads\\# Proyecto Unidad 2\\Inception.txt");
        Pelicula pelicula2 = new Pelicula("2", "Matrix", "Acción", "R", "Una historia de un mundo simulado...", 136, "C:\\Users\\PC\\Downloads\\# Proyecto Unidad 2\\Matrix.txt");  // Pasa 'null' si no tienes póster

        sala1.asignarPelicula(pelicula1, LocalDateTime.now().plusHours(1));  // Assign pelicula 1 to sala 1
        sala2.asignarPelicula(pelicula2, LocalDateTime.now().plusHours(3));  // Assign pelicula 2 to sala 2

        salas.add(sala1);
        salas.add(sala2);

        cine = new Cine(salas, new HashMap<>());
        cine.agregarPelicula("1", pelicula1);
        cine.agregarPelicula("2", pelicula2);
    }
}