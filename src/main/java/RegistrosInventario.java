public class RegistrosInventario {
    private String talla;
    private String color;
    private int cantidad;
    private int codigo;

    public RegistrosInventario(String talla, String color, int cantidad, int codigo) {
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
