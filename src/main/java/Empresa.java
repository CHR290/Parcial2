import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String direccion;
    private String nit;
    private List<Sucursal> sucursales;
    private List<Prenda> catalogo;

    public Empresa(String nombre, String direccion, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        sucursales = new ArrayList<>();
        catalogo = new ArrayList<>();
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public List<Prenda> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Prenda> catalogo) {
        this.catalogo = catalogo;
    }

    public boolean verificarPrenda(int codigo){
        boolean existe = false;
        for(Prenda prenda: catalogo){
            if(prenda.getCodigoUnico()==codigo){
                existe = true;
                break;
            }
        }
        return existe;
    }
    public void agregarPrenda(Prenda prenda){
        catalogo.add(prenda);
        System.out.println("la prenda se ha agregado al catalogo");
    }

    public void mostrarCatalogo(){
        for(Prenda prenda:catalogo){
            System.out.println(prenda);
        }
    }


}
