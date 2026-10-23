
package UMG.modelo;

public class Paquete {

    private int codigoPaquete;
    private String descripcion;
    private String destinatario;
    private String direccionDestinatario;
    private String dniCamionero;

    public Paquete() {
    }

    public Paquete(int codigoPaquete, String descripcion,
                   String destinatario, String direccionDestinatario,
                   String dniCamionero) {
        this.codigoPaquete = codigoPaquete;
        this.descripcion = descripcion;
        this.destinatario = destinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.dniCamionero = dniCamionero;
    }

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getDniCamionero() {
        return dniCamionero;
    }

    public void setDniCamionero(String dniCamionero) {
        this.dniCamionero = dniCamionero;
    }
}
