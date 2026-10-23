
package UMG.modelo;

import java.sql.Date;

public class CamioneroCamion {

    private String dniCamionero;
    private String matricula;
    private Date fecha;

    public CamioneroCamion(String dniCamionero, String matricula, Date fecha) {
        this.dniCamionero = dniCamionero;
        this.matricula = matricula;
        this.fecha = fecha;
    }

    public String getDniCamionero() {
        return dniCamionero;
    }

    public void setDniCamionero(String dniCamionero) {
        this.dniCamionero = dniCamionero;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
