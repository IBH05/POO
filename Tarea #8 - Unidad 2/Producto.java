import java.util.Random;

public class Producto {

    public int id;
    public String nombre;
    public Double precio;
    public String descripcion;
    public int idCategoria;
    public int stock;
    public Random random = new Random();

    public Producto( String nombre, Double precio, String descripcion, int idCategoria, int stock) {
        this.id = this.random.nextInt(1, 10001);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.stock = stock;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getStock() {
        return stock;
    }

    public String mostrarProductos() {
        // d - enteros s - string f - double
        return String.format("Id: %d  |  Nombre: %s  |  Precio: %f  |  Descripcion: %s  |  ID Categoria: %d  |  Stock: %d",
                getId(),
                getNombre(),
                getPrecio(),
                getDescripcion(),
                getIdCategoria(),
                getStock());
    }

}