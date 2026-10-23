
package UMG.DAO;

import UMG.modelo.CamioneroCamion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CamioneroCamionDAO {

    public boolean insertar(CamioneroCamion asignacion) throws SQLException {
        String sql = "INSERT INTO camionero_camion "
                + "(dni_camionero, matricula, fecha) VALUES (?, ?, ?)";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, asignacion.getDniCamionero());
            ps.setString(2, asignacion.getMatricula());
            ps.setDate(3, asignacion.getFecha());

            return ps.executeUpdate() > 0;
        }
    }

    public List<CamioneroCamion> listar() throws SQLException {
        List<CamioneroCamion> lista = new ArrayList<>();

        String sql = "SELECT dni_camionero, matricula, fecha "
                + "FROM camionero_camion ORDER BY fecha DESC";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CamioneroCamion asignacion = new CamioneroCamion(
                        rs.getString("dni_camionero"),
                        rs.getString("matricula"),
                        rs.getDate("fecha")
                );

                lista.add(asignacion);
            }
        }

        return lista;
    }

    public boolean eliminar(
            String dniCamionero,
            String matricula,
            java.sql.Date fecha) throws SQLException {

        String sql = "DELETE FROM camionero_camion "
                + "WHERE dni_camionero = ? AND matricula = ? AND fecha = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dniCamionero);
            ps.setString(2, matricula);
            ps.setDate(3, fecha);

            return ps.executeUpdate() > 0;
        }
    }
}
