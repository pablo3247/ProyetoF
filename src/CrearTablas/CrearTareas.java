package CrearTablas;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTareas {
    static java.sql.Connection con = null;

    public static void main(String[] args) {


        Statement st = null;
        String sql = "CREATE TABLE Tareas (" +
                " id INTEGER CONSTRAINT pk_Tareas PRIMARY KEY AUTOINCREMENT," +
                " titulo VARCHAR(100), " +
                " Descripcion VARCHAR(245), " +
                "Acabada INTEGER check (Acabada in (0,1)) default 0, " +
                "fechaCreacion text default current_timestamp, " +
                "fechaFinal text)";

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
