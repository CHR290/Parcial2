import java.util.ArrayList;
import java.util.List;

public class Prenda {
    private int codigoUnico;
    private String nombre;
    private String marca;
    private double precio;
    private CategoriaPrenda categoria;
    private List<RegistroInventario> registros;

    public Prenda(int codigoUnico, String nombre, String marca, double precio, CategoriaPrenda categoria) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
        registros = new ArrayList<>();
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public List<RegistroInventario> getRegistros() {
        return registros;
    }

    public double calcularPrecioConRecargo() {
        return precio * (1 + categoria.getSobrecargo());
    }

    public boolean tallaValida(String talla) {
        if (categoria == CategoriaPrenda.CALZADO) {
            try {
                int numero = Integer.parseInt(talla);
                return numero >= 35 && numero <= 44;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return List.of("XS", "S", "M", "L", "XL").contains(talla.toUpperCase());
    }

    public int calcularUnidadesVendidas() {
        int total = 0;
        for (RegistroInventario registro : registros) {
            for (Detalle detalle : registro.getDetalles()) {
                total += detalle.getCantidad();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "======================" +
                "\n codigoUnico: " + codigoUnico +
                "\n nombre: " + nombre +
                "\n marca: " + marca +
                "\n precio: " + precio +
                "\n categoria: " + categoria;
    }
}
