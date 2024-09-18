import java.util.ArrayList;
import java.util.Random;

public class Categoria {

    public int id;
    public String nombre;
    public ArrayList<Producto> listaPoductos = new ArrayList<Producto>();
    public Random random = new Random();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria(String nombre) {
        this.id = this.random.nextInt(1, 10001);
        this.nombre = nombre;
    }

    public void registrarProductoEnCategoria(Producto producto){
        this.listaPoductos.add(producto);
    }

    public String mostrarCategorias() {
        return String.format("ID: %d  |  Nombre: %s", getId(), getNombre());
    }

}
