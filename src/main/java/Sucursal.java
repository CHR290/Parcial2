public class Sucursal {
    private int codigoUnico;
    private String nombre;
    private String direccion;
    private String ciudad;

    public Sucursal(int codigoUnico, String ciudad, String direccion, String nombre) {
        this.codigoUnico = codigoUnico;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
