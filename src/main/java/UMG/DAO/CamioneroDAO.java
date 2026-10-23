
package UMG.DAO;

import UMG.modelo.Camionero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CamioneroDAO {

    // Registrar un camionero
    public boolean insertar(Camionero camionero) throws SQLException {
        String sql = "INSERT INTO camionero "
                + "(dni, nombre, telefono, direccion, salario, poblacion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

try (Connection con = conexionDB.abrir();
     PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, camionero.getDni());
            ps.setString(2, camionero.getNombre());
            ps.setString(3, camionero.getTelefono());
            ps.setString(4, camionero.getDireccion());
            ps.setDouble(5, camionero.getSalario());
            ps.setString(6, camionero.getPoblacion());

            return ps.executeUpdate() > 0;
        }

    }

    // Consultar todos los camioneros
    public List<Camionero> listar() throws SQLException {
        List<Camionero> lista = new ArrayList<>();

        String sql = "SELECT dni, nombre, telefono, direccion, salario, poblacion "
                + "FROM camionero ORDER BY dni";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Camionero camionero = new Camionero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getDouble("salario"),
                        rs.getString("poblacion")
                );

                lista.add(camionero);
            }
        }

        return lista;
    }

    // Buscar un camionero por DNI
    public Camionero buscar(String dni) throws SQLException {
        String sql = "SELECT dni, nombre, telefono, direccion, salario, poblacion "
                + "FROM camionero WHERE dni = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Camionero(
                            rs.getString("dni"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("direccion"),
                            rs.getDouble("salario"),
                            rs.getString("poblacion")
                    );
                }
            }
        }

        return null;
    }

    // Actualizar datos de un camionero
    public boolean actualizar(Camionero camionero) throws SQLException {
        String sql = "UPDATE camionero SET nombre = ?, telefono = ?, "
                + "direccion = ?, salario = ?, poblacion = ? WHERE dni = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, camionero.getNombre());
            ps.setString(2, camionero.getTelefono());
            ps.setString(3, camionero.getDireccion());
            ps.setDouble(4, camionero.getSalario());
            ps.setString(5, camionero.getPoblacion());
            ps.setString(6, camionero.getDni());

            return ps.executeUpdate() > 0;
        }
    }

    // Eliminar un camionero por DNI
    public boolean eliminar(String dni) throws SQLException {
        String sql = "DELETE FROM camionero WHERE dni = ?";

        try (Connection con = conexionDB.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);

            return ps.executeUpdate() > 0;
        }
    }
}

