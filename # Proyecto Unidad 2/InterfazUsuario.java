import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfazUsuario {
    private final Cine cine;
    private final Inventario inventario;
    private final Scanner scanner;

    public InterfazUsuario(Cine cine, Inventario inventario) {
        this.cine = cine;
        this.inventario = inventario;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarBanner() {
        System.out.println("\033[1;36m"); 

        System.out.println(" ▄████▄   ██▓ ███▄    █ ▓█████  ██▓███   ▒█████   ██▓     ██▓  ██████ ");
        System.out.println("▒██▀ ▀█  ▓██▒ ██ ▀█   █ ▓█   ▀ ▓██░  ██▒▒██▒  ██▒▓██▒    ▓██▒▒██    ▒ ");
        System.out.println("▒▓█    ▄ ▒██▒▓██  ▀█ ██▒▒███   ▓██░ ██▓▒▒██░  ██▒▒██░    ▒██▒░ ▓██▄   ");
        System.out.println("▒▓▓▄ ▄██▒░██░▓██▒  ▐▌██▒▒▓█  ▄ ▒██▄█▓▒ ▒▒██   ██░▒██░    ░██░  ▒   ██▒");
        System.out.println("▒ ▓███▀ ░░██░▒██░   ▓██░░▒████▒▒██▒ ░  ░░ ████▓▒░░██████▒░██░▒██████▒▒");
        System.out.println("░ ░▒ ▒  ░░▓  ░ ▒░   ▒ ▒ ░░ ▒░ ░▒▓▒░ ░  ░░ ▒░▒░▒░ ░ ▒░▓  ░░▓  ▒ ▒▓▒ ▒ ░");
        System.out.println("  ░  ▒    ▒ ░░ ░░   ░ ▒░ ░ ░  ░░▒ ░       ░ ▒ ▒░ ░ ░ ▒  ░ ▒ ░░ ░▒  ░ ░");
        System.out.println("░         ▒ ░   ░   ░ ░    ░   ░░       ░ ░ ░ ▒    ░ ░    ▒ ░░  ░  ░  ");
        System.out.println("░ ░       ░           ░    ░  ░             ░ ░      ░  ░ ░        ░  ");

        System.out.println("\033[0m"); 
    }

    public void mostrarMenuPrincipal() {
        mostrarBanner();
        mostrarCartelera();
        
        while (true) {
            System.out.print("\033[1;32m"); 
            System.out.println("\n===== MENÚ CLIENTE =====");
            System.out.println("1. Comprar boletos");
            System.out.println("2. Comprar productos");
            System.out.println("3. Ver mis reservaciones");
            System.out.println("4. Ver historial de compras");
            System.out.println("5. Ingresar como Administrador");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            System.out.print("\033[0m"); 
        
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
        
            switch (opcion) {
                case 1 -> comprarBoletos();  
                case 2 -> comprarProductos();  
                case 3 -> verReservaciones();
                case 4 -> verHistorialCompras();
                case 5 -> ingresarComoAdmin();  
                case 0 -> {
                    System.out.println("Saliendo del sistema. ¡Gracias!");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
   
    private void ingresarComoAdmin() {
        System.out.print("Ingrese la contraseña de administrador: ");
        String contraseña = scanner.nextLine();
        if (contraseña.equals("admin123")) {
            mostrarMenuAdmin();  
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }

    
    private void mostrarMenuAdmin() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n===== MENÚ ADMINISTRADOR =====");
            System.out.println("1. Listar Películas");
            System.out.println("2. Generar Reserva para Cliente");
            System.out.println("3. Gestionar Productos");
            System.out.println("4. Ver Reportes de Ventas");
            System.out.println("5. Ver Historial de Compras Cliente");
            System.out.println("6. Ver Reservaciones Cliente");
            System.out.println("7. Administrar Películas");
            System.out.println("8. Configurar Promociones");
            System.out.println("9. Registrar usuario");
            System.out.println("10. Ver Clientes");
            System.out.println("0. Volver al menú de Cliente");
        
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
        
            switch (opcion) {
                case 1 -> listarPeliculas(); 
                case 2 -> generarReservaAdmin();  
                case 3 -> gestionarProductos();  
                case 4 -> verReportesVentas(); 
                case 5 -> verHistorialCompras(); 
                case 6 -> verReservaciones();
                case 7 -> administrarPeliculas();  
                case 8 -> configurarPromociones();  
                case 9 -> registrarCliente(); 
                case 10 -> verClientes(); 
                case 0 -> continuar = false;  
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        mostrarMenuPrincipal();
    }

    private void generarReservaAdmin() {
        System.out.print("Ingrese el CURP del cliente: ");
        String curp = scanner.nextLine();
        Cliente cliente = cine.buscarCliente(curp);
    
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Debe registrarlo.");
            registrarCliente(); 
        } else {
            comprarBoletos();  
        }
    
        mostrarMenuAdmin();
    }
   

    private void gestionarProductos() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Listar Productos");
            System.out.println("0. Volver");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> modificarProducto();
                case 3 -> eliminarProducto();
                case 4 -> listarProductos();
                case 0 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad en inventario: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Producto nuevoProducto = new Producto(nombre, precio);
        inventario.agregarProducto(nuevoProducto, cantidad);
        System.out.println("Producto agregado con éxito.");
    }

    private void modificarProducto() {
        System.out.print("Nombre del producto a modificar: ");
        String nombreProducto = scanner.nextLine();
        Producto producto = inventario.buscarProductoPorNombre(nombreProducto);

        if (producto != null) {
            System.out.print("Nuevo nombre (dejar en blanco para mantener): ");
            String nuevoNombre = scanner.nextLine();
            if (nuevoNombre.isEmpty()) {
                nuevoNombre = producto.getNombre();
            }
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();

            inventario.modificarProducto(nombreProducto, nuevoNombre, nuevoPrecio);
            System.out.println("Producto modificado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombreProducto = scanner.nextLine();
        boolean eliminado = inventario.eliminarProducto(nombreProducto);
        if (eliminado) {
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

   

    private void comprarProductos() {
        System.out.println("\n===== PRODUCTOS DISPONIBLES =====");
        inventario.mostrarInventario();
        List<Producto> productosSeleccionados = new ArrayList<>();
    
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el nombre del producto que desea (o 'Salir' para terminar): ");
            String nombreProducto = scanner.nextLine();
            if (nombreProducto.equalsIgnoreCase("Salir")) {
                continuar = false;
            } else {
                Producto producto = inventario.buscarProductoPorNombre(nombreProducto);
                if (producto != null) {
                    productosSeleccionados.add(producto);
                    System.out.println("Producto agregado: " + producto.getNombre() + " - $" + producto.getPrecio());
                } else {
                    System.out.println("Producto no encontrado.");
                }
            }
        }
    
        if (!productosSeleccionados.isEmpty()) {
            System.out.println("Productos seleccionados:");
            for (Producto producto : productosSeleccionados) {
                System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
            }
        }
    }
  

    private void listarProductos() {
        inventario.listarProductos();
    }

    

    private void verReportesVentas() {
        cine.generarInformeVentas();
    }
    
    private void listarPeliculas() {
        System.out.println("\n===== LISTA DE PELÍCULAS =====");
    
        if (cine.getPeliculas().isEmpty()) {
            System.out.println("No hay películas disponibles.");
            return;
        }
    
        for (Pelicula pelicula : cine.getPeliculas()) {
            System.out.println("ID: " + pelicula.getId());  
            System.out.println("Título: " + pelicula.getTitulo());
            System.out.println("Género: " + pelicula.getGenero());
            System.out.println("Clasificación: " + pelicula.getClasificacion());
            System.out.println("Duración: " + pelicula.getDuracion() + " min");
            System.out.println("Sinopsis: " + pelicula.getSinopsis());
            System.out.println("----------------------------------------");
        }
    }

    private void mostrarCartelera() {
        System.out.println("\n===== CARTELERA DE PELÍCULAS =====");
        
        for (Pelicula pelicula : cine.getPeliculas()) {
            System.out.println("ID: " + pelicula.getId());  // Mostrar el ID
            System.out.println("Título: " + pelicula.getTitulo());
            System.out.println("Género: " + pelicula.getGenero());
            System.out.println("Clasificación: " + pelicula.getClasificacion());
            System.out.println("Duración: " + pelicula.getDuracion() + " min");
            System.out.println("Sinopsis: " + pelicula.getSinopsis());
            
            pelicula.mostrarPoster();  
            System.out.println("----------------------------------------");
        }
    }

    public void comprarBoletos() {
        System.out.print("Ingrese su CURP: ");
        String curp = scanner.nextLine();
        Cliente cliente = cine.buscarCliente(curp);

        if (cliente == null) {
            System.out.println("Cliente no encontrado. ¿Desea registrarse? (Yes/No)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("Yes")) {
                registrarCliente();
                cliente = cine.buscarCliente(curp); 

                if (cliente == null) {
                    System.out.println("No se pudo registrar el cliente correctamente.");
                    return;
                }
            } else {
                System.out.println("Debe registrarse para comprar boletos.");
                return;
            }
        }

    mostrarCartelera();
    System.out.print("Seleccione el ID de la película que desea ver: ");
    String idPelicula = scanner.nextLine();
    Pelicula pelicula = cine.buscarPelicula(idPelicula);

    if (pelicula != null) {
        System.out.println("\nProgreso: [Seleccionar sala] -> [Seleccionar asiento] -> [Pagar]");
        System.out.println("Seleccione el número de la sala: ");
        cine.getSalas().forEach(sala -> System.out.println("Sala " + sala.getNumero()));
        int numSala = scanner.nextInt();
        scanner.nextLine();
        Sala sala = cine.getSalas().stream().filter(s -> s.getNumero() == numSala).findFirst().orElse(null);

        if (sala != null) {
            sala.mostrarAsientosDisponibles();

            List<Asiento> asientosSeleccionados = new ArrayList<>();
            double precioTotal = 0;
            boolean continuar = true;

            while (continuar) {
                System.out.print("Seleccione el número de asiento (o ingrese 0 para finalizar): ");
                int numAsiento = scanner.nextInt();
                scanner.nextLine(); 
                if (numAsiento == 0) {
                    break;
                }
            
                if (numAsiento > 0 && numAsiento <= sala.getAsientos().size()) {
                    Asiento asiento = sala.getAsientos().get(numAsiento - 1);
                    if (asiento.isDisponible()) {
                        asientosSeleccionados.add(asiento);
                        asiento.setDisponible(false);
                        double precio = asiento.getTipo().equals("VIP") ? 400 : asiento.getTipo().equals("Premium") ? 200 : 100;
                        Promocion promocion = new Promocion();
                        double precioFinal = promocion.aplicarDescuento(cliente, asiento, precio);
                        precioTotal += precioFinal;
                        System.out.println("Asiento " + asiento.getNumero() + " seleccionado. Precio: $" + precioFinal);
                    } else {
                        System.out.println("El asiento no está disponible. Intente otro.");
                    }
                } else {
                    System.out.println("El número de asiento no es válido. Intente otro.");
                }
            
                System.out.print("¿Desea seleccionar otro asiento? (Yes/No): ");
                String respuesta = leerRespuestaUsuario();
            
                continuar = respuesta.equalsIgnoreCase("Yes") || respuesta.equalsIgnoreCase("Si");
            }
           

            if (!asientosSeleccionados.isEmpty()) {
                System.out.println("\n===== Resumen de la Compra =====");
                System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellidos());
                System.out.println("Película: " + pelicula.getTitulo());
                System.out.println("Sala: " + sala.getNumero());
                for (Asiento asiento : asientosSeleccionados) {
                    System.out.println("Asiento: " + asiento.getNumero() + " (" + asiento.getTipo() + ")");
                }
                System.out.println("Precio total: $" + precioTotal);
                System.out.print("¿Desea confirmar la compra? (Yes/No): ");

                String confirmacion = leerRespuestaUsuario();
                if (confirmacion.equalsIgnoreCase("Yes") || confirmacion.equalsIgnoreCase("Si")) {
                    realizarCompra(cliente, pelicula, sala, asientosSeleccionados); 
                } else {
                    System.out.println("Compra cancelada. Liberando asientos...");
                    for (Asiento asiento : asientosSeleccionados) {
                        asiento.setDisponible(true);
                    }
                }
            } else {
                System.out.println("No se seleccionaron asientos.");
            }
        }
    }
}

private String leerRespuestaUsuario() {
    System.out.print("Ingrese su respuesta: ");
    return scanner.nextLine().trim();
}

    private void realizarCompra(Cliente cliente, Pelicula pelicula, Sala sala, List<Asiento> asientosSeleccionados) {
        System.out.println("\nSeleccione el método de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Tarjeta de Débito");
        System.out.println("3. Efectivo");

        int metodoPago = scanner.nextInt();
        scanner.nextLine();
        String tipoPago;

        switch (metodoPago) {
            case 1 -> {
                tipoPago = "Tarjeta de Crédito";
                if (!procesarPagoConTarjeta()) {
                    System.out.println("Pago no completado. La compra se ha cancelado.");
                    return;
                }
            }
            case 2 -> {
                tipoPago = "Tarjeta de Débito";
                if (!procesarPagoConTarjeta()) {
                    System.out.println("Pago no completado. La compra se ha cancelado.");
                    return;
                }
            }
            case 3 -> {
                tipoPago = "Efectivo";
                System.out.println("Pago en efectivo seleccionado. Por favor, pague en taquilla.");
            }
            default -> {
                System.out.println("Método de pago no válido. Cancelando la compra.");
                return;
            }
        }

        List<Boleto> boletos = new ArrayList<>();
        for (Asiento asiento : asientosSeleccionados) {
            Boleto boleto = new Boleto(cliente, pelicula, sala, asiento, asiento.getTipo().equals("VIP") ? 400 : asiento.getTipo().equals("Premium") ? 200 : 100, cliente.tieneDescuentoCumpleanios(), asiento.getTipo());
            boletos.add(boleto);
            asiento.asignarBoleto(boleto);
        }

        List<Producto> productos = new ArrayList<>();
        Pago pago = new Pago(tipoPago);
        Compra compra = new Compra(boletos, productos, pago, this.inventario);

        if (compra.confirmarCompra()) {
            System.out.println("\u001B[32mCompra realizada con éxito. ¡Gracias!\u001B[0m");
            cine.registrarCompra(cliente, compra);
            mostrarMenuPrincipal();
        } else {
            System.out.println("\u001B[31mError en la compra.\u001B[0m");
        }
    }


    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    private boolean procesarPagoConTarjeta() {
        System.out.println("\n===== Ingrese los datos de su tarjeta =====");
    
        System.out.print("Número de tarjeta (16 dígitos): ");
        String numeroTarjeta = scanner.nextLine();
        while (!numeroTarjeta.matches("\\d{16}")) {
            System.out.print("Número de tarjeta inválido. Ingrese un número de tarjeta de 16 dígitos: ");
            numeroTarjeta = scanner.nextLine();
        }
    
        System.out.print("Fecha de expiración (MM/AA): ");
        String fechaExpiracion = scanner.nextLine();
        while (!fechaExpiracion.matches("(0[1-9]|1[0-2])/(\\d{2})")) {
            System.out.print("Fecha de expiración inválida. Ingrese en el formato MM/AA: ");
            fechaExpiracion = scanner.nextLine();
        }
    
        System.out.print("Código de seguridad (CVV - 3 dígitos): ");
        String cvv = scanner.nextLine();
        while (!cvv.matches("\\d{3}")) {
            System.out.print("CVV inválido. Ingrese un código de seguridad de 3 dígitos: ");
            cvv = scanner.nextLine();
        }
    
        System.out.println("Procesando pago...");
        try {
            Thread.sleep(2000); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Pago aprobado. ¡Gracias por su compra!");
        return true;
    }

        private void verReservaciones() {
            System.out.print("Ingrese su CURP: ");
            String curp = scanner.nextLine();
            Cliente cliente = cine.buscarCliente(curp);
        
            if (cliente != null) {
                List<Boleto> boletosCliente = cine.obtenerBoletosPorCliente(cliente);
                if (!boletosCliente.isEmpty()) {
                    System.out.println("\n===== RESERVACIONES DEL CLIENTE =====");
                    for (Boleto boleto : boletosCliente) {
                        System.out.println("Película: " + boleto.getPelicula().getTitulo() + " | Sala: " + boleto.getSala().getNumero() + " | Asiento: " + boleto.getAsiento().getNumero() + " | Precio: $" + boleto.getPrecio());
                    }
                    System.out.print("¿Desea modificar o cancelar alguna reserva? (Yes/No): ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("Yes")) {
                        cancelarOmodificarReserva(cliente);
                    }
                } else {
                    System.out.println("No tiene reservaciones.");
                }
            } else {
                System.out.println("Cliente no encontrado.");
            }
        }

        private void verHistorialCompras() {
            System.out.print("Ingrese su CURP para ver el historial: ");
            String curp = scanner.nextLine();
            Cliente cliente = cine.buscarCliente(curp);

            if (cliente != null) {
                List<Compra> comprasCliente = cine.obtenerComprasPorCliente(cliente);
                if (!comprasCliente.isEmpty()) {
                    System.out.println("\n===== HISTORIAL DE COMPRAS =====");
                    for (Compra compra : comprasCliente) {
                        System.out.println("Fecha: " + compra.getFechaCompra());
                        for (Boleto boleto : compra.getBoletos()) {
                            System.out.println("Película: " + boleto.getPelicula().getTitulo() + " | Sala: " + boleto.getSala().getNumero() + " | Asiento: " + boleto.getAsiento().getNumero() + " | Precio: $" + boleto.getPrecio());
                        }
                        System.out.println("Total pagado: $" + compra.getPrecioTotal());
                        System.out.println("----------------------------------------");
                    }
                } else {
                    System.out.println("No tiene compras registradas.");
                }
            } else {
                System.out.println("Cliente no encontrado.");
            }
        }

        private void cancelarOmodificarReserva(Cliente cliente) {
            List<Boleto> boletos = cine.obtenerBoletosPorCliente(cliente);
            if (!boletos.isEmpty()) {
                System.out.println("Seleccione la reserva a modificar/cancelar:");
                for (int i = 0; i < boletos.size(); i++) {
                    System.out.println((i + 1) + ". Película: " + boletos.get(i).getPelicula().getTitulo() +
                                       " | Sala: " + boletos.get(i).getSala().getNumero() + 
                                       " | Asiento: " + boletos.get(i).getAsiento().getNumero());
                }
                int seleccion = scanner.nextInt() - 1;
                scanner.nextLine(); 
        
                if (seleccion >= 0 && seleccion < boletos.size()) {
                    Boleto boletoSeleccionado = boletos.get(seleccion);
                    System.out.print("¿Desea cancelar (1) o modificar (2) esta reserva?: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            cine.getSalas().forEach(sala -> sala.getAsientos().forEach(asiento -> {
                                if (asiento.getBoleto() != null && asiento.getBoleto().equals(boletoSeleccionado)) {
                                    asiento.setDisponible(true); 
                                }
                            }));
                            System.out.println("Reserva cancelada.");
                        }
                        case 2 -> {
                            Sala sala = boletoSeleccionado.getSala();
                            sala.mostrarAsientosDisponibles(); 
        
                            System.out.print("Seleccione el nuevo número de asiento: ");
                            int nuevoAsientoNumero = scanner.nextInt();
                            scanner.nextLine();
        
                            Asiento nuevoAsiento = sala.getAsientos().get(nuevoAsientoNumero - 1);
        
                            if (nuevoAsiento.isDisponible()) {
                                nuevoAsiento.asignarBoleto(boletoSeleccionado);
                                boletoSeleccionado.getAsiento().setDisponible(true);  
                                boletoSeleccionado.setAsiento(nuevoAsiento);
                                System.out.println("Reserva modificada con éxito.");
                            } else {
                                System.out.println("El asiento seleccionado no está disponible.");
                            }
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                } else {
                    System.out.println("Selección no válida.");
                }
            } else {
                System.out.println("No tiene reservaciones activas.");
            }
        }
       

    private void registrarCliente() {
        System.out.println("\n--- Registro de Cliente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("CURP: ");
        String curp = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
    
        Cliente nuevoCliente = new Cliente(nombre, apellidos, curp, LocalDate.parse(fechaNacimiento), direccion);
        cine.getClientes().add(nuevoCliente);
    
        System.out.println("Cliente registrado exitosamente.");
    
        comprarBoletos();
    }

    private void administrarPeliculas() {
        System.out.println("1. Agregar Película");
        System.out.println("2. Modificar Película");
        System.out.println("3. Eliminar Película");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1 -> agregarPelicula();
            case 2 -> modificarPelicula();
            case 3 -> eliminarPelicula();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void agregarPelicula() {
        System.out.println("\n--- Agregar Película ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Clasificación: ");
        String clasificacion = scanner.nextLine();
        System.out.print("Duración (min): ");
        int duracion = scanner.nextInt(); 
        scanner.nextLine();
        System.out.print("Sinopsis: ");
        String sinopsis = scanner.nextLine();
        System.out.print("Ruta del archivo del póster (.txt): ");
        String posterPath = scanner.nextLine();
    
        Pelicula nuevaPelicula = new Pelicula(String.valueOf(cine.getCatalogo().size() + 1), titulo, genero, clasificacion, sinopsis, duracion, posterPath);
        cine.agregarPelicula(nuevaPelicula.getId(), nuevaPelicula);
        System.out.println("Película agregada exitosamente.");
    }
    
      private void modificarPelicula() {
        System.out.print("Ingrese el ID de la película a modificar: ");
        String idPelicula = scanner.nextLine();
        Pelicula pelicula = cine.buscarPelicula(idPelicula);
    
        if (pelicula != null) {
            System.out.print("Ingrese el nuevo título (o presione Enter para dejar sin cambios): ");
            String titulo = scanner.nextLine();
            if (!titulo.isEmpty()) pelicula.setTitulo(titulo);
    
            System.out.print("Ingrese el nuevo género (o presione Enter para dejar sin cambios): ");
            String genero = scanner.nextLine();
            if (!genero.isEmpty()) pelicula.setGenero(genero);
    
            System.out.print("Ingrese la nueva clasificación (o presione Enter para dejar sin cambios): ");
            String clasificacion = scanner.nextLine();
            if (!clasificacion.isEmpty()) pelicula.setClasificacion(clasificacion);
    
            System.out.print("Ingrese la nueva sinopsis (o presione Enter para dejar sin cambios): ");
            String sinopsis = scanner.nextLine();
            if (!sinopsis.isEmpty()) pelicula.setSinopsis(sinopsis);
    
            System.out.print("Ingrese la nueva duración (en minutos, o presione Enter para dejar sin cambios): ");
            int duracion = scanner.nextInt(); 
            scanner.nextLine();
            if (duracion > 0) pelicula.setDuracion(duracion); 
    
            System.out.print("Ingrese la nueva ruta del póster (.txt): ");
            String posterPath = scanner.nextLine();
            if (!posterPath.isEmpty()) pelicula.setPosterPath(posterPath);
    
            System.out.println("Película modificada exitosamente.");
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private void eliminarPelicula() {
        System.out.print("Ingrese el ID de la película a eliminar: ");
        String idPelicula = scanner.nextLine();
        Pelicula pelicula = cine.buscarPelicula(idPelicula);

        if (pelicula != null) {
            cine.getCatalogo().remove(idPelicula);
            System.out.println("Película eliminada exitosamente.");
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private void configurarPromociones() {
        System.out.println("\nConfiguración de Promociones:");
        System.out.println("1. Activar/Desactivar promoción de cumpleaños");
        System.out.println("2. Configurar porcentaje de descuento");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.println("Promoción de cumpleaños activada/desactivada.");
            }
            case 2 -> {
                System.out.print("Ingrese nuevo porcentaje de descuento para boletos Premium: ");
                double descuentoPremium = scanner.nextDouble();
                System.out.print("Ingrese nuevo porcentaje de descuento para boletos VIP: ");
                double descuentoVIP = scanner.nextDouble();
                System.out.println("Descuentos actualizados: Premium " + descuentoPremium + "%, VIP " + descuentoVIP + "%.");
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    private void verClientes() {
        System.out.println("\n--- Lista de Clientes Registrados ---");
        cine.getClientes().forEach(cliente -> System.out.println(cliente.mostrarInformacion()));
    }
}
