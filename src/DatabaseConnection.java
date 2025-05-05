import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:Tareas.db";



    public static Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(URL);
        // Habilitar claves foráneas
        habilitarClavesForaneas(conn);
        return conn;
    }


    private static void habilitarClavesForaneas(Connection conn) {
        try (Statement st = conn.createStatement()) {
            // Ejecutar PRAGMA foreign_keys = ON
            st.execute("PRAGMA foreign_keys = ON;");

        } catch (SQLException e) {
            System.err.println("Error al habilitar claves foráneas: " + e.getMessage());
        }
    }

}
