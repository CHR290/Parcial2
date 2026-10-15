import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa("ModaStyle", "Carrerra 15 calle 18 Armenia", "562803943");
        Sucursal sucursal = new Sucursal( 3094698, "Armenia", "Carrera 15 calle 18", "ModaStyle HQ");
        Sucursal sucursal2 = new Sucursal( 6631233, "Quimbaya", "Carrera 2 calle 8", "ModaStyle Quimbaya");
        empresa.getSucursales().add(sucursal);
        empresa.getSucursales().add(sucursal2);
        int opcion = 0;
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

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("ingrese el codigo de la prenda");
                    int codigoPrenda = Integer.parseInt(sc.nextLine());
                    if(empresa.verificarPrenda(codigoPrenda)){
                        System.out.println("la prenda ya existe");
                        break;
                    }
                    System.out.println("ingrese el nombre de la prenda");
                    String nombrePrenda = sc.nextLine();
                    System.out.println("ingrese la marca de la prenda");
                    String marca = sc.nextLine();
                    System.out.println("ingrese el valor por unidad de la prenda");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.println("escoja la categoria de la prenda");
                    System.out.println("1. camiseta");
                    System.out.println("2. pantalon");
                    System.out.println("3. vestido");
                    System.out.println("4. chaqueta");
                    System.out.println("5. calzado");
                    int opcionCategoria = sc.nextInt();
                    CategoriaPrenda categoriaPrenda = null;
                    switch (opcionCategoria){
                        case 1:
                            categoriaPrenda = CategoriaPrenda.CAMISETA;
                            break;
                        case 2:
                            categoriaPrenda = CategoriaPrenda.PANTALON;
                            break;
                        case 3:
                            categoriaPrenda = CategoriaPrenda.VESTIDO;
                            break;
                        case 4:
                            categoriaPrenda = CategoriaPrenda.CHAQUETA;
                            break;
                        case 5:
                            categoriaPrenda = CategoriaPrenda.CALZADO;
                            break;
                        default:
                            System.out.println("Categoría inválida");
                            break;
                    }
                    Prenda prenda = new Prenda(codigoPrenda, nombrePrenda, marca, precio, categoriaPrenda);
                    empresa.agregarPrenda(prenda);
                case 2:
                    empresa.mostrarCatalogo();
                case 3:
                    System.out.println("Ingrese el código de la sucursal:");
                    int codigo = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion3 = empresa.buscarSucursal(codigo);

                    if (seleccion3 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }

                    System.out.println("Ingrese el documento del cliente");
                    int documento = Integer.parseInt(sc.nextLine());

                    if (seleccion3.verificarPersona(documento)) {
                        System.out.println("La persona ya está registrada");
                        break;
                    }

                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese el correo del cliente");
                    String correo = sc.nextLine();

                    System.out.println("Ingrese el teléfono del cliente");
                    String telefono = sc.nextLine();

                    System.out.println("Escoja la categoría del cliente");
                    System.out.println("1. Bronce");
                    System.out.println("2. Plata");
                    System.out.println("3. Oro");

                    int opcionCategoriaCliente = Integer.parseInt(sc.nextLine());

                    CategoriaCliente categoriaCliente = null;

                    switch (opcionCategoriaCliente) {
                        case 1:
                            categoriaCliente = CategoriaCliente.BRONCE;
                            break;
                        case 2:
                            categoriaCliente = CategoriaCliente.PLATA;
                            break;
                        case 3:
                            categoriaCliente = CategoriaCliente.ORO;
                            break;
                        default:
                            System.out.println("Categoría inválida");
                            break;
                    }
                    Cliente cliente = new Cliente(
                            nombre,
                            documento,
                            correo,
                            telefono,
                            documento,
                            categoriaCliente
                    );

                    seleccion3.agregarCliente(cliente);
                    break;
                case 4:
                    System.out.println("Ingrese el código de la sucursal:");
                    int codigo4 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion4 = empresa.buscarSucursal(codigo4);

                    if (seleccion4 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    System.out.println("Ingrese el documento del cliente:");
                    int documento4 = Integer.parseInt(sc.nextLine());

                    Cliente cliente4 = seleccion4.buscarCliente(documento4);

                    if (cliente4 == null) {
                        System.out.println("Cliente no encontrado");
                        break;
                    }

                    System.out.println("Ingrese el nuevo nombre:");
                    cliente4.setNombre(sc.nextLine());

                    System.out.println("Ingrese el nuevo correo:");
                    cliente4.setCorreo(sc.nextLine());

                    System.out.println("Ingrese el nuevo teléfono:");
                    cliente4.setTelefono(sc.nextLine());

                    System.out.println("Ingrese la categoría (1. BRONCE, 2. PLATA, 3. ORO):");
                    int categoria4 = Integer.parseInt(sc.nextLine());

                    switch (categoria4) {
                        case 1:
                            cliente4.setCategoria(CategoriaCliente.BRONCE);
                            break;
                        case 2:
                            cliente4.setCategoria(CategoriaCliente.PLATA);
                            break;
                        case 3:
                            cliente4.setCategoria(CategoriaCliente.ORO);
                            break;
                        default:
                            System.out.println("Categoría inválida");
                    }

                    System.out.println("Cliente actualizado");
                    break;
                case 5:
                    System.out.println("Ingrese el código de la sucursal: ");
                    int codigo5 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion5 = empresa.buscarSucursal(codigo5);

                    if (seleccion5 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }

                    seleccion5.mostrarClientes();
                    break;

                case 6:
                    System.out.println("Ingrese el código de la sucursal: ");
                    int codigo6 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion6 = empresa.buscarSucursal(codigo6);

                    if (seleccion6 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }

                    System.out.println("Ingrese el documento del cliente: ");
                    int documento6 = Integer.parseInt(sc.nextLine());

                    seleccion6.eliminarCliente(documento6);
                    break;

                case 7:
                    System.out.println("Ingrese el código de la sucursal:");
                    int codigo7 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion7 = empresa.buscarSucursal(codigo7);

                    if (seleccion7 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }

                    System.out.println("Ingrese el documento del vendedor");
                    int documento7 = Integer.parseInt(sc.nextLine());

                    if (seleccion7.verificarPersona(documento7)) {
                        System.out.println("La persona ya está registrada");
                        break;
                    }

                    System.out.println("Ingrese el nombre del vendedor");
                    String nombre7 = sc.nextLine();

                    System.out.println("Ingrese el correo del vendedor");
                    String correo7 = sc.nextLine();

                    System.out.println("Ingrese el teléfono del vendedor");
                    String telefono7 = sc.nextLine();

                    System.out.println("Ingrese el código del vendedor");
                    int codigoVendedor7 = Integer.parseInt(sc.nextLine());

                    System.out.println("Ingrese la fecha de contratación");
                    String fecha7 = sc.nextLine();

                    System.out.println("Ingrese el salario del vendedor");
                    double salario7 = Double.parseDouble(sc.nextLine());

                    Vendedor vendedor7 = new Vendedor(
                            documento7,
                            nombre7,
                            correo7,
                            telefono7,
                            codigoVendedor7,
                            fecha7,
                            salario7
                    );

                    seleccion7.agregarVendedor(vendedor7);
                    break;

                case 8:
                    System.out.println("Ingrese el código de la sucursal:");
                    int codigo8 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion8 = empresa.buscarSucursal(codigo8);

                    if (seleccion8 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }
                    System.out.println("Ingrese el documento del vendedor:");
                    int documento8 = Integer.parseInt(sc.nextLine());

                    Vendedor vendedor8 = seleccion8.buscarVendedor(documento8);

                    if (vendedor8 == null) {
                        System.out.println("Vendedor no encontrado");
                        break;
                    }

                    System.out.println("Ingrese el nuevo nombre:");
                    vendedor8.setNombre(sc.nextLine());

                    System.out.println("Ingrese el nuevo correo:");
                    vendedor8.setCorreo(sc.nextLine());

                    System.out.println("Ingrese el nuevo teléfono:");
                    vendedor8.setTelefono(sc.nextLine());

                    System.out.println("Ingrese el nuevo salario:");
                    vendedor8.setSalario(sc.nextDouble());

                    System.out.println("Vendedor actualizado");
                    break;
                case 9:
                    System.out.println("Ingrese el código de la sucursal: ");
                    int codigo9 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion9 = empresa.buscarSucursal(codigo9);

                    if (seleccion9 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }

                    seleccion9.mostrarVendedores();
                    break;
                case 10:
                    System.out.println("Ingrese el código de la sucursal: ");
                    int codigo10 = Integer.parseInt(sc.nextLine());

                    Sucursal seleccion10 = empresa.buscarSucursal(codigo10);

                    if (seleccion10 == null) {
                        System.out.println("Sucursal no encontrada");
                        break;
                    }

                    System.out.println("Ingrese el documento del vendedor:");
                    int documento9 = Integer.parseInt(sc.nextLine());

                    seleccion10.eliminarVendedor(documento9);
                    break;
                case 11:

                case 12:

                case 13:

                case 14:

                case 15:

                case 16:

                case 17:

                case 18:

                case 19:

                case 20:

            }
            sc.nextLine();
        } while (opcion!=0);
    }
}
