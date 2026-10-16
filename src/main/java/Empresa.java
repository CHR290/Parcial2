import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String direccion;
    private String nit;
    private List<Sucursal> sucursales;
    private List<Prenda> catalogo;
    private List<Cliente> clientes;

    public Empresa(String nombre, String direccion, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        sucursales = new ArrayList<>();
        catalogo = new ArrayList<>();
        clientes = new ArrayList<>();
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public Sucursal buscarSucursal(int codigoUnico) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getCodigoUnico() == codigoUnico) {
                return sucursal;
            }
        }
        return null;
    }

    public boolean verificarPrenda(int codigo) {
        return buscarPrenda(codigo) != null;
    }

    public Prenda buscarPrenda(int codigo) {
        for (Prenda prenda : catalogo) {
            if (prenda.getCodigoUnico() == codigo) {
                return prenda;
            }
        }
        return null;
    }

    public boolean agregarPrenda(Prenda prenda) {
        if (verificarPrenda(prenda.getCodigoUnico())) {
            return false;
        }
        catalogo.add(prenda);
        return true;
    }

    public void mostrarCatalogo() {
        for (Prenda prenda : catalogo) {
            System.out.println(prenda);
        }
    }

    public boolean verificarPersona(int documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                return true;
            }
        }
        for (Sucursal sucursal : sucursales) {
            if (sucursal.buscarVendedor(documento) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarCliente(Cliente cliente) {
        if (verificarPersona(cliente.getDocumento())) {
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    public boolean agregarVendedor(Sucursal sucursal, Vendedor vendedor) {
        if (verificarPersona(vendedor.getDocumento())) {
            return false;
        }
        sucursal.agregarVendedor(vendedor);
        return true;
    }

    public Cliente buscarCliente(int documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                return cliente;
            }
        }
        return null;
    }

    public void eliminarCliente(int documento) {
        clientes.removeIf(cliente -> cliente.getDocumento() == documento);
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public boolean verificarVenta(int codigo) {
        for (Sucursal sucursal : sucursales) {
            for (Venta venta : sucursal.getRegistroVentas()) {
                if (venta.getCodigo() == codigo) {
                    return true;
                }
            }
        }
        return false;
    }

    public Prenda prendaMasVendida() {
        Prenda masVendida = null;
        int maximo = 0;
        for (Prenda prenda : catalogo) {
            int unidades = prenda.calcularUnidadesVendidas();
            if (unidades > maximo) {
                maximo = unidades;
                masVendida = prenda;
            }
        }
        return masVendida;
    }
}

