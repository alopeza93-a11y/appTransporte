package UMG.modelo;
public class Ciudad {
 private int idCiudad;
 private String nombre;
 
 public Ciudad(int idCiudad, String nombre){
     this.idCiudad = idCiudad;
     this.nombre = nombre;
 }
 public Ciudad(){
     
 }

    public int getIdCiudad() {
        return idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
}
