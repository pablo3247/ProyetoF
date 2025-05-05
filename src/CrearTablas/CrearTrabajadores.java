package CrearTablas;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTrabajadores {
    static java.sql.Connection con = null;

    public static void main(String[] args) {


        Statement st = null;
        String sql = "CREATE TABLE Trabajadores (" +
                " dni INTEGER CONSTRAINT pk_Trabajadores PRIMARY KEY ," +
                " nombre VARCHAR(200), " +
                " Puesto VARCHAR(245))";

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