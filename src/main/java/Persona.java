public abstract class Persona {
    private int documentoIdentidad;
    private String nombre;
    private String correo;
    private String telefono;
    private String historial;

    public Persona(int documentoIdentidad, String nombre, String correo, String telefono, String historial) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.historial = historial;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }
}
