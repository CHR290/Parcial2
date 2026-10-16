public class Cliente extends Persona{
    private int codigoAfiliacion;
    private CategoriaCliente categoria;
    public Cliente(int documentoIdentidad, String nombre, String correo, String telefono, int codigoAfiliacion, CategoriaCliente categoria) {
        super(documentoIdentidad, nombre, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoria = categoria;
    }

    public int getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(int codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCliente categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  "=======================" +
                "\ncodigoAfiliacion: " + codigoAfiliacion +
                "\ncategoria:" + categoria +
                super.toString();
    }
}
