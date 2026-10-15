import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int codigo;
    private String fecha;
    private List<Detalle> detalles;

    public Venta(int codigo, String fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
        detalles = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}
