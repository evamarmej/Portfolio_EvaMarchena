package vo;

public class TallerVo { //Declaración de las variables de trabajos + getter + setter
    
    private Integer idtr;
    private String descripcion;
    private Float numhoras;
    private Float precio;
    private Float preciomaterial;
    private String tipotrabajo;
    private String estado;
    private String fechacomienzo;
    private String fechafin;
    private Integer idopt;


    public Integer getIdtr() {return idtr;}

    public void setIdtr(Integer idtr) {this.idtr = idtr;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Float getNumhoras() {return numhoras;}

    public void setNumhoras(Float numhoras) {this.numhoras = numhoras;}

    public Float getPrecio() {return precio;}

    public void setPrecio(Float precio) {this.precio = precio;}

    public Float getPreciomaterial() {return preciomaterial;}

    public void setPreciomaterial(Float preciomaterial) {this.preciomaterial = preciomaterial;}

    public String getTipotrabajo() {return tipotrabajo;}

    public void setTipotrabajo(String tipotrabajo) {this.tipotrabajo = tipotrabajo;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public String getFechacomienzo() {return fechacomienzo;}

    public void setFechacomienzo(String fechacomienzo) {this.fechacomienzo = fechacomienzo;}

    public String getFechafin() {return fechafin;}

    public void setFechafin(String fechafin) {this.fechafin = fechafin;}

    public Integer getIdopt() {return idopt;}

    public void setIdopt(Integer idopt) {this.idopt = idopt;}

}
