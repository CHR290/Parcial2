import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    static int leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    static double leerDouble(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    static CategoriaPrenda leerCategoriaPrenda() {
        CategoriaPrenda[] categorias = CategoriaPrenda.values();
        while (true) {
            System.out.println("escoja la categoria de la prenda");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i]);
            }
            int op = leerEntero("opcion:");
            if (op >= 1 && op <= categorias.length) {
                return categorias[op - 1];
            }
            System.out.println("Categoria invalida");
        }
    }

    static CategoriaCliente leerCategoriaCliente() {
        CategoriaCliente[] categorias = CategoriaCliente.values();
        while (true) {
            System.out.println("Escoja la categoria del cliente");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i]);
            }
            int op = leerEntero("opcion:");
            if (op >= 1 && op <= categorias.length) {
                return categorias[op - 1];
            }
            System.out.println("Categoria invalida");
        }
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa("ModaStyle", "Carrera 15 calle 18 Armenia", "562803943");
        empresa.agregarSucursal(new Sucursal(3094698, "Armenia", "Carrera 15 calle 18", "ModaStyle HQ"));
        empresa.agregarSucursal(new Sucursal(6631233, "Quimbaya", "Carrera 2 calle 8", "ModaStyle Quimbaya"));
        int opcion;
        do {
            System.out.println("====ModaStyle====");
            System.out.println("====Catalogo====");
            System.out.println("1. Agregar prenda.");
            System.out.println("2. ver prendas.");
            System.out.println("====Clientes====");
            System.out.println("3. Agregar cliente.");
            System.out.println("4. Actualizar cliente.");
            System.out.println("5. Ver clientes.");
            System.out.println("6. Eliminar cliente.");
            System.out.println("7. Consultar historial de compras");
            System.out.println("====Vendedores====");
            System.out.println("8. Agregar vendedor.");
            System.out.println("9. Actualizar vendedor.");
            System.out.println("10. Ver vendedor.");
            System.out.println("11. Eliminar vendedor.");
            System.out.println("=====Ventas====");
            System.out.println("12. Consultar historial de ventas.");
            System.out.println("====Inventario====");
            System.out.println("13. Agregar registro.");
            System.out.println("14. ver inventario.");
            System.out.println("15. ver agotados.");
            System.out.println("====ventas====");
            System.out.println("16. Registrar venta.");
            System.out.println("17. ver registro de ventas.");
            System.out.println("====informacion====");
            System.out.println("18. ver ingresos de sucursal");
            System.out.println("19. consultar articulo mas vendido.");
            System.out.println("0. Salir");

            opcion = leerEntero("Seleccione una opcion:");

            switch (opcion) {
                case 1: {
                    int codigoPrenda = leerEntero("ingrese el codigo de la prenda");
                    if (empresa.verificarPrenda(codigoPrenda)) {
                        System.out.println("la prenda ya existe");
                        break;
                    }
                    System.out.println("ingrese el nombre de la prenda");
                    String nombrePrenda = sc.nextLine();
                    System.out.println("ingrese la marca de la prenda");
                    String marca = sc.nextLine();
                    double precio = leerDouble("ingrese el valor por unidad de la prenda");
                    CategoriaPrenda categoriaPrenda = leerCategoriaPrenda();
                    Prenda prenda = new Prenda(codigoPrenda, nombrePrenda, marca, precio, categoriaPrenda);
                    if (empresa.agregarPrenda(prenda)) {
                        System.out.println("la prenda se ha agregado al catalogo");
                    }
                    break;
                }
                case 2: {
                    empresa.mostrarCatalogo();
                    break;
                }
                case 3: {
                    int documento = leerEntero("Ingrese el documento del cliente");
                    if (empresa.verificarPersona(documento)) {
                        System.out.println("La persona ya esta registrada");
                        break;
                    }
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el correo del cliente");
                    String correo = sc.nextLine();
                    System.out.println("Ingrese el telefono del cliente");
                    String telefono = sc.nextLine();
                    int codigoAfiliacion = leerEntero("Ingrese el codigo de afiliacion");
                    CategoriaCliente categoriaCliente = leerCategoriaCliente();
                    Cliente cliente = new Cliente(documento, nombre, correo, telefono, codigoAfiliacion, categoriaCliente);
                    if (empresa.agregarCliente(cliente)) {
                        System.out.println("se ha agregado al cliente");
                    }
                    break;
                }
                case 4: {
                    int documento = leerEntero("Ingrese el documento del cliente:");
                    Cliente cliente = empresa.buscarCliente(documento);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado");
                        break;
                    }
                    System.out.println("Ingrese el nuevo nombre:");
                    cliente.setNombre(sc.nextLine());
                    System.out.println("Ingrese el nuevo correo:");
                    cliente.setCorreo(sc.nextLine());
                    System.out.println("Ingrese el nuevo telefono:");
                    cliente.setTelefono(sc.nextLine());
                    cliente.setCategoria(leerCategoriaCliente());
                    System.out.println("Cliente actualizado");
                    break;
                }
                case 5: {
                    empresa.mostrarClientes();
                    break;
                }
                case 6: {
                    int documento = leerEntero("Ingrese el documento del cliente: ");
                    empresa.eliminarCliente(documento);
                    break;
                }
                case 7: {
                    int documento = leerEntero("Ingrese el documento del cliente:");
                    Cliente cliente = empresa.buscarCliente(documento);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado");
                        break;
                    }
                    if (cliente.getHistorial().isEmpty()) {
                        System.out.println("El cliente no tiene compras registradas");
                    } else {
                        cliente.mostrarHistorial();
                    }
                    break;
                }
                case 8: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    int documento = leerEntero("Ingrese el documento del vendedor");
                    if (empresa.verificarPersona(documento)) {
                        System.out.println("La persona ya esta registrada");
                        break;
                    }
                    System.out.println("Ingrese el nombre del vendedor");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el correo del vendedor");
                    String correo = sc.nextLine();
                    System.out.println("Ingrese el telefono del vendedor");
                    String telefono = sc.nextLine();
                    int codigoVendedor = leerEntero("Ingrese el codigo del vendedor");
                    System.out.println("Ingrese la fecha de contratacion");
                    String fecha = sc.nextLine();
                    double salario = leerDouble("Ingrese el salario del vendedor");
                    Vendedor vendedor = new Vendedor(documento, nombre, correo, telefono, codigoVendedor, fecha, salario);
                    if (empresa.agregarVendedor(sucursal, vendedor)) {
                        System.out.println("se ha agregado al vendedor");
                    }
                    break;
                }
                case 9: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    int documento = leerEntero("Ingrese el documento del vendedor:");
                    Vendedor vendedor = sucursal.buscarVendedor(documento);
                    if (vendedor == null) {
                        System.out.println("Vendedor no encontrado");
                        break;
                    }
                    System.out.println("Ingrese el nuevo nombre:");
                    vendedor.setNombre(sc.nextLine());
                    System.out.println("Ingrese el nuevo correo:");
                    vendedor.setCorreo(sc.nextLine());
                    System.out.println("Ingrese el nuevo telefono:");
                    vendedor.setTelefono(sc.nextLine());
                    vendedor.setSalario(leerDouble("Ingrese el nuevo salario:"));
                    System.out.println("Vendedor actualizado");
                    break;
                }
                case 10: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal: ");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    sucursal.mostrarVendedores();
                    break;
                }
                case 11: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal: ");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    int documento = leerEntero("Ingrese el documento del vendedor:");
                    sucursal.eliminarVendedor(documento);
                    break;
                }
                case 12: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    int documento = leerEntero("Ingrese el documento del vendedor:");
                    Vendedor vendedor = sucursal.buscarVendedor(documento);
                    if (vendedor == null) {
                        System.out.println("Vendedor no encontrado");
                        break;
                    }
                    if (vendedor.getHistorial().isEmpty()) {
                        System.out.println("El vendedor no tiene ventas registradas");
                    } else {
                        vendedor.mostrarHistorial();
                    }
                    break;
                }
                case 13: {
                    int codigoSucursal = leerEntero("ingrese el codigo de la sucursal");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    int codigoPrenda = leerEntero("ingrese el codigo de la prenda");
                    Prenda prenda = empresa.buscarPrenda(codigoPrenda);
                    if (prenda == null) {
                        System.out.println("La prenda no existe en el catalogo");
                        break;
                    }
                    System.out.println("ingrese la talla");
                    String talla = sc.nextLine().trim().toUpperCase();
                    if (!prenda.tallaValida(talla)) {
                        System.out.println("Talla invalida (XS, S, M, L, XL; calzado 35 a 44)");
                        break;
                    }
                    System.out.println("ingrese el color");
                    String color = sc.nextLine().trim();
                    int cantidad = leerEntero("ingrese la cantidad");
                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor que 0");
                        break;
                    }
                    RegistroInventario registro = new RegistroInventario(prenda, sucursal, talla, color, cantidad);
                    if (sucursal.agregarRegistro(registro)) {
                        System.out.println("se ha agregado el registro al inventario");
                    } else {
                        System.out.println("Ya existe un registro con esa prenda, talla y color");
                    }
                    break;
                }
                case 14: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    sucursal.mostrarDisponibles();
                    break;
                }
                case 15: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    sucursal.mostrarAgotados();
                    break;
                }
                case 16: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    int documentoVendedor = leerEntero("Ingrese el documento del vendedor:");
                    Vendedor vendedor = sucursal.buscarVendedor(documentoVendedor);
                    if (vendedor == null) {
                        System.out.println("El vendedor no pertenece a esta sucursal");
                        break;
                    }
                    int documentoCliente = leerEntero("Ingrese el documento del cliente:");
                    Cliente cliente = empresa.buscarCliente(documentoCliente);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado");
                        break;
                    }
                    int codigoVenta = leerEntero("Ingrese el codigo de la venta:");
                    if (empresa.verificarVenta(codigoVenta)) {
                        System.out.println("Ya existe una venta con ese codigo");
                        break;
                    }
                    System.out.println("Ingrese la fecha de la venta:");
                    String fechaVenta = sc.nextLine();
                    Venta venta = new Venta(codigoVenta, fechaVenta, sucursal, vendedor, cliente);

                    String otro;
                    do {
                        int codigoPrenda = leerEntero("ingrese el codigo de la prenda:");
                        System.out.println("ingrese la talla:");
                        String tallaVenta = sc.nextLine().trim();
                        System.out.println("ingrese el color:");
                        String colorVenta = sc.nextLine().trim();
                        RegistroInventario registro = sucursal.buscarRegistro(codigoPrenda, tallaVenta, colorVenta);
                        if (registro == null) {
                            System.out.println("Ese producto no esta en el inventario de la sucursal");
                        } else {
                            int cantidadVenta = leerEntero("ingrese la cantidad:");
                            if (!venta.agregarDetalle(registro, cantidadVenta)) {
                                System.out.println("La cantidad debe ser mayor que 0");
                            }
                        }
                        System.out.println("Desea agregar otro producto? (s/n)");
                        otro = sc.nextLine().trim();
                    } while (otro.equalsIgnoreCase("s"));

                    System.out.println(venta);
                    if (venta.confirmar()) {
                        System.out.println("Venta confirmada");
                    } else {
                        System.out.println("No se pudo confirmar: no hay productos o alguna cantidad supera las existencias. El inventario no cambio.");
                    }
                    break;
                }
                case 17: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    sucursal.mostrarVentas();
                    break;
                }
                case 18: {
                    int codigoSucursal = leerEntero("Ingrese el codigo de la sucursal:");
                    Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
                    if (sucursal == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    System.out.println("Ingresos de " + sucursal.getNombre() + ": "
                            + String.format("%.2f", sucursal.calcularIngresos()));
                    break;
                }
                case 19: {
                    Prenda masVendida = empresa.prendaMasVendida();
                    if (masVendida == null) {
                        System.out.println("Aun no hay ventas registradas");
                    } else {
                        System.out.println("Prenda mas vendida: " + masVendida.getNombre()
                                + " (codigo " + masVendida.getCodigoUnico() + ") con "
                                + masVendida.calcularUnidadesVendidas() + " unidades");
                    }
                    break;
                }
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            if (opcion != 0) {
                sc.nextLine();
            }
        } while (opcion != 0);
    }
}
