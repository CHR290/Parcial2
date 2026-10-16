import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private int codigoUnico;
    private String nombre;
    private String direccion;
    private String ciudad;
    private List<Vendedor> vendedores;
    private List<RegistroInventario> inventario;
    private List<Venta> registroVentas;

    public Sucursal(int codigoUnico, String ciudad, String direccion, String nombre) {
        this.codigoUnico = codigoUnico;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        vendedores = new ArrayList<>();
        inventario = new ArrayList<>();
        registroVentas = new ArrayList<>();
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

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<RegistroInventario> getInventario() {
        return inventario;
    }

    public void setInventario(List<RegistroInventario> inventario) {
        this.inventario = inventario;
    }

    public List<Venta> getRegistroVentas() {
        return registroVentas;
    }

    public void setRegistroVentas(List<Venta> registroVentas) {
        this.registroVentas = registroVentas;
    }

    public void agregarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void eliminarVendedor(int documento) {
        vendedores.removeIf(vendedor -> vendedor.getDocumento() == documento);
    }

    public void mostrarVendedores() {
        for (Vendedor vendedor : vendedores) {
            System.out.println(vendedor);
        }
    }

    public Vendedor buscarVendedor(int documento) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getDocumento() == documento) {
                return vendedor;
            }
        }
        return null;
    }

    public boolean verificarRegistro(RegistroInventario nuevoRegistro) {
        for (RegistroInventario registro : inventario) {
            if (registro.getTalla().equalsIgnoreCase(nuevoRegistro.getTalla())
                    && registro.getColor().equalsIgnoreCase(nuevoRegistro.getColor())
                    && registro.getPrenda().getCodigoUnico() == nuevoRegistro.getPrenda().getCodigoUnico()) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarRegistro(RegistroInventario registro) {
        if (verificarRegistro(registro)) {
            return false;
        }
        inventario.add(registro);
        registro.getPrenda().getRegistros().add(registro);
        return true;
    }

    public void mostrarInventario() {
        for (RegistroInventario registro : inventario) {
            System.out.println(registro);
        }
    }
}
