import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private int codigoUnico;
    private String nombre;
    private String direccion;
    private String ciudad;
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<RegistrosInventario> inventario;
    private List<Venta> registroVentas;

    public Sucursal(int codigoUnico, String ciudad, String direccion, String nombre) {
        this.codigoUnico = codigoUnico;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        clientes = new ArrayList<>();
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<RegistrosInventario> getInventario() {
        return inventario;
    }

    public void setInventario(List<RegistrosInventario> inventario) {
        this.inventario = inventario;
    }

    public List<Venta> getRegistroVentas() {
        return registroVentas;
    }

    public void setRegistroVentas(List<Venta> registroVentas) {
        this.registroVentas = registroVentas;
    }

    public boolean verificarPersona(int documento) {
        boolean existe = false;
        for (Persona persona : clientes) {
            if (persona.getDocumento() == documento) {
                existe = true;
                break;
            }
        }
        for (Persona persona : vendedores) {
            if (persona.getDocumento() == documento) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void agregarCliente(Cliente cliente) {
        if (!verificarPersona(cliente.getDocumento())) {
            clientes.add(cliente);
            System.out.println("se ha agragado al cliente");
        } else {
            System.out.println("esta persona ya esta registrada");
        }
    }

    public void actualizarCliente(int documento, Cliente clienteActualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setCorreo(clienteActualizado.getCorreo());
                cliente.setTelefono(clienteActualizado.getTelefono());
                cliente.setCodigoAfiliacion(clienteActualizado.getCodigoAfiliacion());
                cliente.setCategoria(clienteActualizado.getCategoria());
            }
        }
    }

    public void eliminarCliente(int documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                clientes.remove(cliente);
                break;
            }
        }
    }

    public Cliente buscarCliente(int documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                return cliente;
            }
        }
        return null;
    }

    public void agregarVendedor(Vendedor vendedor) {
        if (!verificarPersona(vendedor.getDocumento())) {
            vendedores.add(vendedor);
            System.out.println("se ha agragado al vendedor");
        } else {
            System.out.println("esta persona ya esta registrada");
        }
    }

    public void actualizarVendedor(int documento, Vendedor vendedorActualizado) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getDocumento() == documento) {
                vendedor.setNombre(vendedorActualizado.getNombre());
                vendedor.setCorreo(vendedorActualizado.getCorreo());
                vendedor.setTelefono(vendedorActualizado.getTelefono());
                vendedor.setCodigo(vendedorActualizado.getCodigo());
                vendedor.setFechaContratacion(vendedorActualizado.getFechaContratacion());
                vendedor.setSalario(vendedorActualizado.getSalario());
            }
        }
    }

    public void eliminarVendedor(int documento) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getDocumento() == documento) {
                vendedores.remove(vendedor);
                break;
            }
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

    public boolean verificarRegistro(RegistrosInventario nuevoRegistro){
        boolean existe = false;
        for(RegistrosInventario registro:inventario){
            if(registro.getTalla().equalsIgnoreCase(nuevoRegistro.getTalla())
            &&registro.getColor().equalsIgnoreCase(nuevoRegistro.getColor())
            &&registro.getCodigo()==nuevoRegistro.getCodigo()){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void agregarRegistro(RegistrosInventario registro){
        inventario.add(registro);
        System.out.println("se ha agregado el registro al inventario");
    }

    public void mostrarInventario(){
        for(RegistrosInventario registro: inventario){
            System.out.println(registro);
        }
    }

}
