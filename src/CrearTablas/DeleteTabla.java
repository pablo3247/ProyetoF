package CrearTablas;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTabla {
    static java.sql.Connection con = null;

    public static void main(String[] args) {


        Statement st = null;
        String sql = "DROP TABLE Trabajadores";

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
                System.out.println("NO SE HA PODIDO CERRAR!");
            }
        }
    }
}