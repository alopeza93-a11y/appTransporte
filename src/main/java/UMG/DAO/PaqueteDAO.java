
package UMG.DAO;

import UMG.modelo.Paquete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaqueteDAO {

    public boolean insertar(Paquete paquete) throws SQLException {
        String sql = "INSERT INTO paquete "
                + "(descripcion, destinatario, direccion_destinatario, dni_camionero) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, paquete.getDescripcion());
            ps.setString(2, paquete.getDestinatario());
            ps.setString(3, paquete.getDireccionDestinatario());
            ps.setString(4, paquete.getDniCamionero());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Paquete> listar() throws SQLException {
        List<Paquete> lista = new ArrayList<>();
        String sql = "SELECT * FROM paquete";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paquete paquete = new Paquete(
                        rs.getInt("codigo_paquete"),
                        rs.getString("descripcion"),
                        rs.getString("destinatario"),
                        rs.getString("direccion_destinatario"),
                        rs.getString("dni_camionero")
                );

                lista.add(paquete);
            }
        }

        return lista;
    }

    public Paquete buscar(int codigoPaquete) throws SQLException {
        String sql = "SELECT * FROM paquete WHERE codigo_paquete = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigoPaquete);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Paquete(
                            rs.getInt("codigo_paquete"),
                            rs.getString("descripcion"),
                            rs.getString("destinatario"),
                            rs.getString("direccion_destinatario"),
                            rs.getString("dni_camionero")
                    );
                }
            }
        }

        return null;
    }

    public boolean actualizar(Paquete paquete) throws SQLException {
        String sql = "UPDATE paquete SET descripcion = ?, "
                + "destinatario = ?, direccion_destinatario = ?, "
                + "dni_camionero = ? WHERE codigo_paquete = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, paquete.getDescripcion());
            ps.setString(2, paquete.getDestinatario());
            ps.setString(3, paquete.getDireccionDestinatario());
            ps.setString(4, paquete.getDniCamionero());
            ps.setInt(5, paquete.getCodigoPaquete());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int codigoPaquete) throws SQLException {
        String sql = "DELETE FROM paquete WHERE codigo_paquete = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codigoPaquete);
            return ps.executeUpdate() > 0;
        }
    }
}
