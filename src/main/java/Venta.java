import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int codigo;
    private String fecha;
    private Sucursal sucursal;
    private Vendedor vendedor;
    private Cliente cliente;
    private List<Detalle> detalles;

    public Venta(int codigo, String fecha, Sucursal sucursal, Vendedor vendedor, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
        this.cliente = cliente;
        detalles = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    // Crea el detalle aplicando recargo (Prenda) y descuento (categoria del cliente)
    public void agregarDetalle(RegistroInventario registro, int cantidad) {
        double precioConRecargo = registro.getPrenda().calcularPrecioConRecargo();
        double precioFinal = precioConRecargo * (1 - cliente.getCategoria().getDescuento());
        detalles.add(new Detalle(registro, cantidad, precioFinal));
    }

    public double calcularTotal() {
        double total = 0;
        for (Detalle detalle : detalles) {
            total += detalle.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        String texto = "Venta " + codigo + " | fecha: " + fecha +
                " | cliente: " + cliente.getNombre() +
                " | vendedor: " + vendedor.getNombre() + "\n";
        for (Detalle detalle : detalles) {
            texto += "   " + detalle + "\n";
        }
        return texto + "   TOTAL: " + calcularTotal();
    }
}

