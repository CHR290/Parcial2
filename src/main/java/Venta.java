import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int codigo;
    private boolean confirmada;
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
    public boolean agregarDetalle(RegistroInventario registro, int cantidad) {
        if (confirmada || cantidad <= 0) {
            return false;
        }
        double precioConRecargo = registro.getPrenda().calcularPrecioConRecargo();
        double precioFinal = precioConRecargo * (1 - cliente.getCategoria().getDescuento());
        detalles.add(new Detalle(registro, cantidad, precioFinal));
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (Detalle detalle : detalles) {
            total += detalle.getSubtotal();
        }
        return total;
    }

    public boolean confirmar() {
        if (confirmada || detalles.isEmpty()) {
            return false;
        }
        // 1. Validar: cada producto debe ser de la sucursal y alcanzar para la cantidad TOTAL pedida
        for (Detalle detalle : detalles) {
            RegistroInventario registro = detalle.getRegistro();
            if (!sucursal.getInventario().contains(registro)) {
                return false;
            }
            int totalPedido = 0;
            for (Detalle otro : detalles) {
                if (otro.getRegistro() == registro) {
                    totalPedido += otro.getCantidad();
                }
            }
            if (totalPedido > registro.getCantidad()) {
                return false;
            }
        }
        // 2. Todo correcto: descontar y registrar historiales
        for (Detalle detalle : detalles) {
            RegistroInventario registro = detalle.getRegistro();
            registro.setCantidad(registro.getCantidad() - detalle.getCantidad());
            registro.getDetalles().add(detalle);
        }
        cliente.getHistorial().add(this);
        vendedor.getHistorial().add(this);
        sucursal.getRegistroVentas().add(this);
        confirmada = true;
        return true;
    }

    @Override
    public String toString() {
        String texto = "Venta: " + codigo + " | fecha: " + fecha +
                "\n cliente: " + cliente.getNombre() +
                "\n vendedor: " + vendedor.getNombre();
        for (Detalle detalle : detalles) {
            texto += "\n" + detalle;
        }
        return texto + "\nTOTAL: " + calcularTotal();
    }
}

