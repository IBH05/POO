import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Cine {
    private final List<Sala> salas;
    private final Map<String, Pelicula> catalogo;
    private final List<Cliente> clientes;
    private final List<Compra> compras; 

    public Cine(List<Sala> salas, Map<String, Pelicula> catalogo) {
        this.salas = salas;
        this.catalogo = catalogo;
        this.clientes = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void registrarCompra(Cliente cliente, Compra compra) {
        if (clientes.contains(cliente)) {
            cliente.getCompras().add(compra);
            System.out.println("Compra registrada exitosamente para el cliente: " + cliente.getNombre());
        } else {
            System.out.println("Cliente no encontrado. No se pudo registrar la compra.");
        }
    }

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

    public Cliente buscarCliente(String curp) {
        for (Cliente cliente : clientes) {
            if (cliente.getCurp().equalsIgnoreCase(curp)) {
                return cliente;
            }
        }
        return null;
    }

    public Pelicula buscarPelicula(String id) {
        return catalogo.get(id);
    }

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
        return null;
    }
    
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
        return new ArrayList<>(catalogo.values());
    }

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
