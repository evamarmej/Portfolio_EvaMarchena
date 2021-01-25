package vo;

public class OperarioVo { //Declaración de las variables de operarios + getter + setter
    
    private Integer idop;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;

    public Integer getIdop() {return idop;}

    public void setIdop(Integer idop) {this.idop = idop;}

    public String getDni() {return dni;}

    public void setDni(String dni) {this.dni = dni;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

}
