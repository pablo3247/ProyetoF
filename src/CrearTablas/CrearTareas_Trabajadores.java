package CrearTablas;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTareas_Trabajadores {
    static java.sql.Connection con = null;

    public static void main(String[] args) {


        Statement st = null;
        String sql = "CREATE TABLE Tareas_Trabajadores (" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " id_Tarea INTEGER NOT NULL," +
                " dni integer NOT NULL," +
                " fechaAsignacion TEXT DEFAULT CURRENT_TIMESTAMP," +
                " FOREIGN KEY (id_Tarea) REFERENCES Tareas(id) ON DELETE CASCADE," +
                " FOREIGN KEY (dni) REFERENCES Trabajadores(dni) ON DELETE CASCADE," +
                " UNIQUE (id_Tarea, dni) ON CONFLICT REPLACE)";

        try{
            //Conexion
            con =DatabaseConnection.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }finally {
            try{
                if(st != null && !st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex){
                System.out.println("NO SE HA PODIDO CERRAR el statement!");
            }
            try{
                if(con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex){
                System.out.println("NO se ha podido cerrar la conexion");
            }
        }
    }
}
