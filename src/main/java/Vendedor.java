public class Vendedor extends Persona{
    private int codigo;
    private String fechaContratacion;
    private  double salario;

    public Vendedor(int documentoIdentidad, String nombre, String correo, String telefono, int codigo, String fechaContratacion, double salario) {
        super(documentoIdentidad, nombre, correo, telefono);
        this.codigo = codigo;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  "codigo: " + codigo +
                "\nfecha de contratacion:" + fechaContratacion +
                "\nsalario: " +salario +
                super.toString();
    }
}
