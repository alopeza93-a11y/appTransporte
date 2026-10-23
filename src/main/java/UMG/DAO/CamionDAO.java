
package UMG.DAO;

import UMG.modelo.Camion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CamionDAO {

    // Registrar un camion
    public boolean insertar(Camion camion) throws SQLException {
        String sql = "INSERT INTO camion "
                + "(matricula, modelo, tipo, potencia) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, camion.getMatricula());
            ps.setString(2, camion.getModelo());
            ps.setString(3, camion.getTipo());
            ps.setInt(4, camion.getPotencia());

            return ps.executeUpdate() > 0;
        }
    }

    // Consultar todos los camiones
    public List<Camion> listar() throws SQLException {
        List<Camion> lista = new ArrayList<>();
        String sql = "SELECT matricula, modelo, tipo, potencia "
                + "FROM camion ORDER BY matricula";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Camion camion = new Camion(
                        rs.getString("matricula"),
                        rs.getString("modelo"),
                        rs.getString("tipo"),
                        rs.getInt("potencia")
                );

                lista.add(camion);
            }
        }

        return lista;
    }
    
    // Actualizar los datos de un camion
    public boolean actualizar(Camion camion) throws SQLException {
        String sql = "UPDATE camion SET modelo = ?, tipo = ?, potencia = ? "
                + "WHERE matricula = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, camion.getModelo());
            ps.setString(2, camion.getTipo());
            ps.setInt(3, camion.getPotencia());
            ps.setString(4, camion.getMatricula());

            return ps.executeUpdate() > 0;
        }
    }

    // Eliminar un camion por matricula
    public boolean eliminar(String matricula) throws SQLException {
        String sql = "DELETE FROM camion WHERE matricula = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricula);

            return ps.executeUpdate() > 0;
        }
    }

    // Buscar un camion por matricula
    public Camion buscar(String matricula) throws SQLException {
        String sql = "SELECT matricula, modelo, tipo, potencia "
                + "FROM camion WHERE matricula = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricula);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Camion(
                            rs.getString("matricula"),
                            rs.getString("modelo"),
                            rs.getString("tipo"),
                            rs.getInt("potencia")
                    );
                }
            }
        }

        return null;
    }

}
