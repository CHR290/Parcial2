import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa("ModaStyle", "Carrerra 15 calle 18", "Armenia");
        int opcion = 0;
        do {
            System.out.println("====ModaStyle====");
            System.out.println("====Sucursales====");
            System.out.println("1. Agregar sucursal.");
            System.out.println("2. Ver sucursales.");
            System.out.println("3. Actualizar sucursal.");
            System.out.println("4. Eliminar sucursal.");
            System.out.println("====Clientes====");
            System.out.println("5. Agregar cliente.");
            System.out.println("6. Ver clientes.");
            System.out.println("7. Actualizar cliente.");
            System.out.println("8. Eliminar cliente.");
            System.out.println("====Prendas====");
            System.out.println("9. Agregar prenda.");
            System.out.println("10. Ver prendas.");
            System.out.println("11. Actualizar prenda.");
            System.out.println("12. Eliminar prenda.");
            System.out.println("====Vendedores====");
            System.out.println("13. Agregar vendedor.");
            System.out.println("14. Ver vendedores.");
            System.out.println("15. Actualizar vendedor.");
            System.out.println("16. Eliminar vendedor.");
            System.out.println("====Registro de inventario====");
            System.out.println("17. Agregar registro de inventario.");
            System.out.println("18. Ver registros de inventario.");
            System.out.println("19. Actualizar registro de inventario.");
            System.out.println("20. Eliminar registro de inventario.");
            System.out.println("====Ventas====");
            System.out.println("21. Agregar venta.");
            System.out.println("22. Ver ventas.");
            System.out.println("23. Actualizar venta.");
            System.out.println("24. Eliminar venta.");
            System.out.println("25. Salir.");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:
            }
        } while (opcion!=0);
    }
}
