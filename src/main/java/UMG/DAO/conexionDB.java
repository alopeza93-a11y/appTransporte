
package UMG.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {

    private static final String URL =
        "jdbc:mysql://localhost:3306/db_paqueteria"
        + "?useSSL=false"
        + "&allowPublicKeyRetrieval=true"
        + "&serverTimezone=America/Guatemala";

private static final String USER = "user";
private static final String PASS = "angel123/45";

    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
