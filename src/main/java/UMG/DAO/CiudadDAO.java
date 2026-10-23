
package UMG.DAO;

import UMG.modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CiudadDAO {

    public void insertar(Ciudad ciudad) throws SQLException {

        String sql = "INSERT INTO ciudad (nombre) VALUES (?)";

        try (Connection cn = conexionDB.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, ciudad.getNombre());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new SQLException(
                    "No se pudo insertar el registro."
                );
            }
        }
    }
}
