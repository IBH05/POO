import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Cine {
    private final List<Sala> salas;
    private final Map<String, Pelicula> catalogo;
    private final List<Cliente> clientes;
    private final List<Compra> compras;  // Lista para almacenar el historial de compras

    public Cine(List<Sala> salas, Map<String, Pelicula> catalogo) {
        this.salas = salas;
        this.catalogo = catalogo;
        this.clientes = new ArrayList<>();
        this.compras = new ArrayList<>();  // Inicializar historial de compras
    }

    public void registrarCompra(Cliente cliente, Compra compra) {
        // Verificar si el cliente ya está registrado
        if (clientes.contains(cliente)) {
            cliente.getCompras().add(compra);  // Agregar la compra al historial del cliente
            System.out.println("Compra registrada exitosamente para el cliente: " + cliente.getNombre());
        } else {
            System.out.println("Cliente no encontrado. No se pudo registrar la compra.");
        }
    }


    // Método para agregar una película al catálogo
    public void agregarPelicula(String clave, Pelicula pelicula) {
        catalogo.put(clave, pelicula);
    }

    public Map<String, Pelicula> getCatalogo() {
        return catalogo;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

        // Método para buscar un cliente por CURP
    public Cliente buscarCliente(String curp) {
        for (Cliente cliente : clientes) {
            if (cliente.getCurp().equalsIgnoreCase(curp)) {
                return cliente;
            }
        }
        return null;  // Retornar null si no se encuentra el cliente
    }

    // Método para buscar una película por ID
    public Pelicula buscarPelicula(String id) {
        return catalogo.get(id); // Suponiendo que catalogo es un Map
    }

    // Método para obtener boletos de un cliente
    public List<Boleto> obtenerBoletosPorCliente(Cliente cliente) {
        List<Boleto> boletosCliente = new ArrayList<>();
        for (Sala sala : salas) {
            for (Asiento asiento : sala.getAsientos()) {
                if (asiento.getBoleto() != null && asiento.getBoleto().getCliente().equals(cliente)) {
                    boletosCliente.add(asiento.getBoleto());
                }
            }
        }
        return boletosCliente;
    }

    public Sala buscarSalaPorAsiento(Asiento asientoBuscado) {
        for (Sala sala : salas) {
            for (Asiento asiento : sala.getAsientos()) {
                if (asiento.equals(asientoBuscado)) {
                    return sala;
                }
            }
        }
        return null; // Si no encuentra la sala
    }
    

    // Método para obtener historial de compras de un cliente
    public List<Compra> obtenerComprasPorCliente(Cliente cliente) {
        List<Compra> comprasCliente = new ArrayList<>();
        for (Compra compra : compras) {
            if (compra.getBoletos().get(0).getCliente().equals(cliente)) {
                comprasCliente.add(compra);
            }
        }
        return comprasCliente;
    }

    public List<Pelicula> getPeliculas() {
        return new ArrayList<>(catalogo.values()); // Suponiendo que las películas están almacenadas en un Map llamado 'catalogo'
    }

    // Método para generar un informe detallado de ventas
    public void generarInformeVentas() {
        System.out.println("\n===== INFORME DE VENTAS =====");
        for (Sala sala : salas) {
            System.out.println("Sala " + sala.getNumero() + ": ");
            System.out.println("Boletos VIP vendidos: " + sala.contarBoletosPorTipo("VIP"));
            System.out.println("Boletos Premium vendidos: " + sala.contarBoletosPorTipo("Premium"));
            System.out.println("Boletos Normales vendidos: " + sala.contarBoletosPorTipo("Normal"));
            System.out.println("Ingresos totales: $" + sala.calcularIngresos());
            System.out.println("----------------------------------------");
        }
    }
}
