public class Prenda {
    private int codigoUnico;
    private String nombre;
    private String marca;
    private double precio;
    private CategoriaPrenda categoria;

    public Prenda(int codigoUnico, String nombre, String marca, double precio, String talla, String color, CategoriaPrenda categoria) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
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
