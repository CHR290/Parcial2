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

    public boolean verificarPersona(int documento){
        boolean existe = false;
        for(Persona persona: clientes){
            if(persona.getDocumento()==documento){
                existe = true;
                break;
            }
        }
        for(Persona persona: vendedores){
            if(persona.getDocumento()==documento){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void agregarCliente(Cliente cliente){
        if(!verificarPersona(cliente.getDocumento())){
            clientes.add(cliente);
            System.out.println("se ha agragado al cliente");
        }else{
            System.out.println("esta persona ya esta registrada");
        }
    }

    public void agregarVendedor(Vendedor vendedor){
        if(!verificarPersona(vendedor.getDocumento())){
            vendedores.add(vendedor);
            System.out.println("se ha agragado al vendedor");
        }else{
            System.out.println("esta persona ya esta registrada");
        }
    }



}
