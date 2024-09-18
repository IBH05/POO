import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;

        while (true) {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("1.- Registrar Productos");
            System.out.println("2.- Eliminar Producto");
            System.out.println("3.- Mostrar Productos");
            System.out.println("4.- Mostrar Categorias");
            System.out.println("5.- Mostrar Categorias Con Productos");
            System.out.println("6.- Registrar Categoria");
            System.out.println("7.- Salir");

            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (!inventario.validarExistenciaDeCategorias()) {
                        System.out.println("\nNo existen categorias en el sistema");
                        break;
                    }

                    System.out.println("\nSeleccionaste la opcion para registrar un producto");

                    System.out.print("\nIngresa el Nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("\nIngresa el Precio del producto: ");
                    Double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("\nIngresa la Descripcion del producto: ");
                    String descripcion = scanner.nextLine();

                    int idCategoria = 0;
                    boolean band = true;
                    while (band) {
                        System.out.print("\nIngresa el ID de la Categoria en la cual registraras el producto: ");
                        idCategoria = scanner.nextInt();

                        if (inventario.validarCategoria(idCategoria)) {
                            band = false;
                        } else {
                            System.out.println("El ID de la categoria no es correcto, intenta de nuevo.");
                        }
                    }

                    System.out.print("\nIngresa el Stock del producto: ");
                    int stock = scanner.nextInt();

                    Producto producto = new Producto(nombre, precio, descripcion, idCategoria, stock);
                    inventario.registrarProductos(producto);
                    inventario.ponerProductoEnCategoria(producto);

                    break;

                case 2:
                    System.out.println("\nSeleccionaste la opcion para eliminar un producto");
                    System.out.print("\nIngresa el ID del producto: ");
                    int id = scanner.nextInt();

                    inventario.eliminarProducto(id);

                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    inventario.mostrarCategorias();
                    break;
                case 5:
                    inventario.mostrarCategoriasYProductos();
                    break;

                case 6:

                    System.out.println("\nSeleccionaste la opcion para registrar una categoria");

                    System.out.print("Ingresa el nombre de la categoria: ");
                    String nombreCategoria = scanner.next();

                    Categoria categoria = new Categoria(nombreCategoria);
                    inventario.registrarCategoria(categoria);
                    System.out.println("\nCategori a registrada correctamente");

                    break;
                case 7:
                    System.out.println("\nHasta luego");
                    return;
            }
        }
    }
}
