import java.util.ArrayList;

public class Inventario {

    public ArrayList<Producto> listaPoductos = new ArrayList<Producto>();
    public ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

    public void registrarProductos(Producto producto) {
        this.listaPoductos.add(producto);
        System.out.println("Se registro un nuevo Producto");
    }

    public void registrarCategoria(Categoria categoria) {
        this.listaCategorias.add(categoria);
    }

    public void ponerProductoEnCategoria(Producto producto) {
        for (Categoria categoria : this.listaCategorias) {
            if (categoria.getId() == producto.getIdCategoria()) {
                categoria.registrarProductoEnCategoria(producto);
                return;
            }
        }
    }

    public void eliminarProducto(int idProductoEliminar) {
        int longitudOriginal = this.listaPoductos.size();

        this.listaPoductos.removeIf((producto -> producto.getId() == idProductoEliminar));

        if (longitudOriginal != this.listaPoductos.size()) {
            System.out.println("\nSe elimino el producto con el ID: " + idProductoEliminar);
        } else {
            System.out.println("\nNo existe el producto con el ID: " + idProductoEliminar);
        }
    }

    public void mostrarProductos() {
        System.out.println("\n** PRODUCTOS EN EL SISTEMA **");

        if (this.listaPoductos.isEmpty()) {
            System.out.println("\nNo existen productos registrados");
        } else {
            for (Producto producto : this.listaPoductos) {
                System.out.println(producto.mostrarProductos());
            }
        }
    }

    public void mostrarCategorias() {
        System.out.println("\n** CATEGORIAS EN EL SISTEMA **");

        if (this.listaCategorias.isEmpty()) {
            System.out.println("\nNo existen categorias registradas");
        } else {
            for (Categoria categoria : this.listaCategorias) {
                System.out.println(categoria.mostrarCategorias());
            }
        }
    }

    public void mostrarCategoriasYProductos() {
        System.out.println("\n*** CATEGORIAS Y PRODUCTOS EN EL SISTEMA ***");

        if (this.listaCategorias.isEmpty()) {
            System.out.println("\nNo hay registros existentes");
        } else {
            for (Categoria categoria : this.listaCategorias) {
                System.out.println(categoria.getId() + " | " + categoria.getNombre());
                System.out.println("--------------------------------");
                for (Producto producto : this.listaPoductos) {
                    if (producto.getIdCategoria() == categoria.getId()) {
                        System.out.printf("Id: %d  |  Nombre: %s  |  Precio: %f  |  Descripcion: %s  |  ID Categoria: %d  |  Stock: %d%n",
                                producto.getId(),
                                producto.getNombre(),
                                producto.getPrecio(),
                                producto.getDescripcion(),
                                producto.getIdCategoria(),
                                producto.getStock());
                    }
                }
                System.out.println("\n");
            }
        }
    }

    public boolean validarExistenciaDeCategorias() {
        return !this.listaCategorias.isEmpty();
    }

    public boolean validarCategoria(int idCategoria) {
        for (Categoria categoria : listaCategorias) {
            if (categoria.getId() == idCategoria) {
                return true;
            }
        }
        return false;
    }
}
