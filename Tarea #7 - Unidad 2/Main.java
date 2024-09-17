public class Main {
    public static void main(String[] args) {
    Producto producto1 = new Producto("Pantalla",5622.99);
    Producto producto2 = new Producto("Pantalla",5622.99, 5);

        System.out.println("Producto 1:" + "\nNombre: " + producto1.getNombre() + "\nPrecio: " + producto1.getPrecio() + "\nStock: " + producto1.getStock());
        System.out.println("\nProducto 2:" + "\nNombre: " + producto2.getNombre() + "\nPrecio: " + producto2.getPrecio() + "\nStock: " + producto2.getStock());

    producto1.aumentarStock(5);
        System.out.println("\nStock después de aumentar: " + producto1.getStock());

    producto1.reducirStock(3);
        System.out.println("\nEl stock del producto 1 se reducira ");
        System.out.println("Stock después de reducir:\n " + producto1.getStock());

    producto2.reducirStock(3);
        System.out.println("\nEl stock del producto 2 se reducira ");
        System.out.println("Stock después de reducir:\n " + producto1.getStock());
    }
}