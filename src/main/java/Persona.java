import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private int documento;
    private String nombre;
    private String correo;
    private String telefono;
    private List<Venta> historial;

    public Persona(int documento, String nombre, String correo, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        historial = new ArrayList<>();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Venta> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Venta> historial) {
        this.historial = historial;
    }
}
