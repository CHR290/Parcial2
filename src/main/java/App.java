import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa("ModaStyle", "Carrerra 15 calle 18", "Armenia");
        int opcion = 0;
        do {
            System.out.println("====ModaStyle====");
            System.out.println("====Catalogo====");
            System.out.println("1. Agregar prenda.");
            System.out.println("2. actualizar prenda.");
            System.out.println("3. ver prendas.");
            System.out.println("====Clientes====");
            System.out.println("4. Agregar cliente.");
            System.out.println("5. Actualizar cliente.");
            System.out.println("6. Ver clientes.");
            System.out.println("7. Eliminar cliente.");
            System.out.println("8. Consultar historial de compras");
            System.out.println("====Vendedores====");
            System.out.println("9. Agregar vendedor.");
            System.out.println("10. Actualziar vendedor.");
            System.out.println("11. Ver vendedor.");
            System.out.println("12. Eliminar vendedor.");
            System.out.println("13. Consultar historial de ventas.");
            System.out.println("====Inventario====");
            System.out.println("14. Agregar registro.");
            System.out.println("15. ver inventario.");
            System.out.println("16. ver agotados.");
            System.out.println("====ventas====");
            System.out.println("17. Registrar venta.");
            System.out.println("18. ver registro de ventas.");
            System.out.println("====informacion====");
            System.out.println("19. ver ingresos de sucursal");
            System.out.println("20. consultar articulo mas vendido.");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:

                case 2:

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

                case 20:

            }
        } while (opcion!=0);
    }
}
