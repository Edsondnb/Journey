package school.dao;

import school.conexion.Conexion;
import school.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static school.conexion.Conexion.getConexion;

//DAO . DATA ACCESS Object
public class EstudianteDAO {

    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement preparaSentencia;
        ResultSet almacenaResultadoBD;

        Connection cn = getConexion();
        String sql = "Select * from estudiante ORDER BY id_estudiante";

        try {
            preparaSentencia = cn.prepareStatement(sql);
            almacenaResultadoBD = preparaSentencia.executeQuery();
            while (almacenaResultadoBD.next()){
                //recuperando registro de la tabla
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(almacenaResultadoBD.getInt("id_estudiante"));
                estudiante.setNombre(almacenaResultadoBD.getString("nombre"));
                estudiante.setApellido(almacenaResultadoBD.getString("apellido"));
                estudiante.setTelefono(almacenaResultadoBD.getString("telefono"));
                estudiante.setEmail(almacenaResultadoBD.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un erro al seleccionar datos: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Erro al cerrar conexion con BD: " + ex.getMessage());
            }
        }

        return estudiantes;
    }

    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement prepararSentencia;
        ResultSet almacenaResultadoBD;
        Connection conexion = getConexion();

        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try {
            prepararSentencia = conexion.prepareStatement(sql);
            prepararSentencia.setInt(1, estudiante.getIdEstudiante());

            almacenaResultadoBD = prepararSentencia.executeQuery();

            if(almacenaResultadoBD.next()){
                estudiante.setNombre(almacenaResultadoBD.getString("nombre"));
                estudiante.setApellido(almacenaResultadoBD.getString("apellido"));
                estudiante.setTelefono(almacenaResultadoBD.getString("telefono"));
                estudiante.setEmail(almacenaResultadoBD.getString("email"));
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Erro al buscar un estudiante" + e.getMessage());
        }finally {
            try {
                conexion.close();
            }catch (Exception ex){
                System.out.println("Error al cerra conexion " + ex.getMessage());
            }
        }
        return false;

    }


    public boolean agregarEstudiante (Estudiante estudiante){
        PreparedStatement ps;
        Connection cn = getConexion();
        String sql = "INSERT INTO estudiante(nombre,apellido,telefono,email) " +
                    "VALUES(?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar estudiandte " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar bd " +  ex.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEstudiante (Estudiante estudiante){

        ResultSet rs;
        PreparedStatement ps;
        Connection cn = getConexion();

        String sql = "UPDATE estudiante set nombre=?,apellido=?,telefono=?,email=?" +
                "WHERE id_estudiante = ?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.setInt(5,estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actulizar estudiante: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println("error al cerrar coneccion " + e.getMessage());
            }
        }

        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection cn = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println("error al cerrar la bd: " + e.getMessage());
            }
        }

        return false;
    }




    public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();

        //agregar estudiante

        /*var nuevoEstudiante = new Estudiante("Carlos","Perez","9851520653","c@gmail.com");
        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        if(agregado){
            System.out.println("Estudiante agregado: " + nuevoEstudiante);
        }else {
            System.out.println("No se agrego elñ estudiante " + nuevoEstudiante);
        }*/

        //modificar un estudiante
        /*var estudianteModificar = new Estudiante(2, "Katte", "Geraldine", "9851562062", "gmunoz@gmail.com");
        var moficado = estudianteDao.modificarEstudiante(estudianteModificar);
        if(moficado){
            System.out.println("Estudiante mofiicado");
        }else {
            System.out.println("Error al modificar estudiante");
        }*/

        //Eliminar estudiante
        var estudadianteEliminar = new Estudiante(3);
        var eliminado = estudianteDao.eliminarEstudiante(estudadianteEliminar);
        if (eliminado)
            System.out.println("Estudainte eliminado: " + estudadianteEliminar);
        else
            System.out.println("NO SE ELIMINO ESTUDIANTE");


        //listar los estudiantes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        //buscar por id
        /*var estudiante1 = new Estudiante(2);
        System.out.println("Estuadnte antes de la busqueda: " +estudiante1);
        var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);

        if(encontrado){
            System.out.println("Estudnate encontrado " + estudiante1);
        }else {
            System.out.println("Estaudnte no encontrado " + estudiante1.getIdEstudiante());
        }*/
    }


}
