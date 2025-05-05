import java.sql.*;
import java.util.Scanner;

public class Trabajadores {


    public static void selectTrabajador(){

        Scanner sc = new Scanner(System.in);

        String cod ="";

        while(!cod.equals("exit")){
            System.out.println("SELECCIONA UNA OPCION:\n1.Agregar un nuevo elemento\n2.Consultar elemento por ID\n3.Actualizar elemento por ID\n4.Eliminar elemento por ID\n5.Mostrar todos elementos\nexit.Volver al menu principal");
            cod = sc.nextLine();

            switch (cod){
                case "1":
                    System.out.println("Dime el nombre y la fecha de nacimiento:");
                    addTrabajador(sc.nextLine(),sc.nextLine());
                    break;

                case "2":
                    System.out.println("Dime la ID del elemento a consultar");
                    verTrabajador(Integer.valueOf( sc.nextLine()));
                    break;

                case "3":
                    System.out.println("Selecciona el CAMPO a modificar:\n1.Nombre\n2.Fecha de nacimiento.");
                    String select="";
                    String campo="";
                    select = sc.nextLine();
                    switch (select){
                        case "1":
                            campo = "nombre";
                            break;

                        case "2":
                            campo="fecha_nacimiento";
                            break;
                        default:
                            System.out.println("Ingresa un valor valido");
                            break;
                    }

                    System.out.println("Dime el nuevo valor:");
                    String nuevoValor = sc.nextLine();

                    System.out.println("Dime la ID");
                    String id = sc.nextLine();
                    updateTrabajador(campo,nuevoValor,Integer.valueOf(id));

                    break;

                case "4":

                    System.out.println("1.Eliminar los registros asociados.\n2.Anular operacion");
                    String confirmacion = sc.nextLine();
                    if(confirmacion.equals("1")){
                        System.out.println("Dime la ID del autor a eliminar.");
                        deleteTrabajador(Integer.valueOf(sc.nextLine()));
                    }else {
                        System.out.println("OPERACION ANULADA CON EXITO");
                    }


                    break;
                case "5":
                    verTrabajadores();
                    break;

                default :
                    break;


            }

        }


    }




    public static void addTrabajador(String nombre,String FechaNacimiento) {
        PreparedStatement st = null;
        Connection con = null;

        String sql = "INSERT INTO Trabajadores(dni,nombre,puesto) VALUES(?,?,?)";

        try {
            con = DatabaseConnection.getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1, 1234567);
            st.setString(2, "Paco");
            st.setString(3, "Gerente");

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println("NO SE HA PODIDO CERRAR el statement!");
            }
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("NO se ha podido cerrar la conexion");
            }


        }


    }

    public static void deleteTrabajador(int id_autor){
        PreparedStatement st = null;
        Connection con = null;

        String sql = "DELETE FROM Trabajadores WHERE id_autor = ?";

        try {
            con = DatabaseConnection.getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1, id_autor);
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println("NO SE HA PODIDO CERRAR el statement!");
            }
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("NO se ha podido cerrar la conexion");
            }


        }

    }

    public static void verTrabajadores(){

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DatabaseConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Trabajadores");

            System.out.println("id_autor \tNombre \tFecha_Nacimiento");
            System.out.println("-----------------------------------------");

            while(rs.next()){
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.println(rs.getString(3)+"\t");
            }

        }catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.out.println("NO SE HA PODIDO CERRAR el statement!");
            }
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("NO se ha podido cerrar la conexion");
            }
            try{
                if(con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex){
                System.out.println("Lamento informarte que ha habido un error al cerrar la conexion: "+ex.getMessage());
            }


        }



    }
    public static void updateTrabajador(String campo,String nuevoValor,int id_autor){
        {
            PreparedStatement st = null;
            Connection con = null;

            String sql = "UPDATE Trabajadores SET "+campo+" = ? WHERE id_autor = ?";

            try {
                con = DatabaseConnection.getConnection();
                st = con.prepareStatement(sql);


                st.setString(1,nuevoValor);
                st.setInt(2,id_autor);
                st.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            } finally {
                try {
                    if (st != null && !st.isClosed()) {
                        st.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("NO SE HA PODIDO CERRAR el statement!");
                }
                try {
                    if (con != null && !con.isClosed()) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("NO se ha podido cerrar la conexion");
                }


            }

        }


    }

    public static void verTrabajador(int id_autor){
        {

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            try {
                con = DatabaseConnection.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM Trabajadores where id_autor = '"+id_autor+"'");

                System.out.println("id_autor \tNombre \tFecha_Nacimiento");
                System.out.println("-----------------------------------------");

                while(rs.next()){
                    System.out.print(rs.getInt(1)+"\t");
                    System.out.print(rs.getString(2)+"\t");
                    System.out.println(rs.getString(3)+"\t");
                }

            }catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            } finally {
                try {
                    if (st != null && !st.isClosed()) {
                        st.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("NO SE HA PODIDO CERRAR el statement!");
                }
                try {
                    if (con != null && !con.isClosed()) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("NO se ha podido cerrar la conexion");
                }
                try{
                    if(con != null && !con.isClosed()){
                        con.close();
                    }
                }catch (SQLException ex){
                    System.out.println("Lamento informarte que ha habido un error al cerrar la conexion: "+ex.getMessage());
                }


            }



        }
    }




}





