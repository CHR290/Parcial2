import java.util.ArrayList;
import java.util.List;

public class RegistroInventario {
    private Prenda prenda;
    private Sucursal sucursal;
    private String talla;
    private String color;
    private int cantidad;
    private List<Detalle> detalles;

    public RegistroInventario(Prenda prenda, Sucursal sucursal, String talla, String color, int cantidad) {
        this.prenda = prenda;
        this.sucursal = sucursal;
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
        detalles = new ArrayList<>();
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "codigo prenda: " + prenda.getCodigoUnico() +
                "\nnombre: " + prenda.getNombre() +
                "\ntalla: " + talla +
                "\ncolor: " + color +
                "\ncantidad: " + cantidad;
    }
}
