package teaching.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion(){
        Connection conexion = null;

        var baseDatos = "bd_docentes";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "mysql";

        try {
            //1. cargamos la clase del driver de mysql en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Ocurrio un error en la conexion: " + ex.getMessage());
        }

        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();

        if(conexion != null){
            System.out.println("Conexion exitosa");
        }else {
            System.out.println("Ocurrio un error al conectarse");
        }
    }



}
