public class Detalle {
    private RegistroInventario registro;
    private int cantidad;
    private double precio;      // precio unitario final (con recargo y descuento)
    private double subtotal;

    public Detalle(RegistroInventario registro, int cantidad, double precio) {
        this.registro = registro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = precio * cantidad;
    }

    public RegistroInventario getRegistro() {
        return registro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return registro.getPrenda().getNombre() +
                "\ntalla " + registro.getTalla() +
                "\ncolor " + registro.getColor() +
                "\ncantidad: " + cantidad +
                "\nprecio unitario: " + precio +
                "\nsubtotal: " + subtotal;
    }
}

