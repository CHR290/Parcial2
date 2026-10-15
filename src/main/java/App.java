import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa("ModaStyle", "Carrerra 15 calle 18 Armenia", "562803943");
        Sucursal hq = new Sucursal( 3094698, "Armenia", "Carrera 15 calle 18", "ModaStyle HQ");
        Sucursal quimbaya = new Sucursal( 6631233, "Quimbaya", "Carrera 2 calle 8", "ModaStyle Quimbaya");
        empresa.agregarSucursal(hq);
        empresa.agregarSucursal(quimbaya);
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
            System.out.println("19. Actualziar vendedor.");
            System.out.println("10. Ver vendedor.");
            System.out.println("11. Eliminar vendedor.");
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
                    System.out.println("ingrese la talla de la prenda");
                    String talla = sc.nextLine();
                    System.out.println("ingrese el color de la prenda");
                    String color = sc.nextLine();
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
                    }
                    Prenda prenda = new Prenda(codigoPrenda, nombrePrenda, marca, precio, talla, color, categoriaPrenda);
                    empresa.agregarPrenda(prenda);
                    break;
                case 2:
                    empresa.mostrarCatalogo();
                case 3:

                case 4:

                case 5:

                case 6:

                case 7:

                case 8:

                case 9:

                case 10:

                case 11:

                case 12:

                case 13:

                case 14:

                case 15:

                case 16:

                case 17:

                case 18:

                case 19:

            }
            sc.nextLine();
        } while (opcion!=0);
    }
}
