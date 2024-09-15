package teaching.dao;

import teaching.dominio.Docente;
import teaching.conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static teaching.conexion.Conexion.getConexion;

public class DocenteDAO {

    public List<Docente> listarDocente(){
        List<Docente> docentes = new ArrayList<>();

        PreparedStatement prepararSentencia;
        ResultSet alamcenBD;

        Connection cn = getConexion();
        String sql = "select * from docentes where estado = 1";

        try {
            prepararSentencia = cn.prepareStatement(sql);
            alamcenBD = prepararSentencia.executeQuery();

            while (alamcenBD.next()){
                var docente = new Docente();
                docente.setIdDocente(alamcenBD.getInt("id_docente"));
                docente.setNombre(alamcenBD.getString("nombre"));
                docente.setApellido(alamcenBD.getString("apellido"));
                docente.setTelefono(alamcenBD.getString("telefono"));
                docente.setEmail(alamcenBD.getString("email"));
                docentes.add(docente);
            }

        } catch (Exception e) {
            System.out.println("Erro al listar Docentes: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar conexion con BD: " + ex.getMessage());
            }
        }

        return docentes;
    }

    public boolean agregarDocente (Docente docente){
        PreparedStatement prepararSentencia;
        Connection cn = getConexion();

        String sql = "insert into docentes (nombre, apellido, telefono, email) values (?,?,?,?)";

        try {
            prepararSentencia = cn.prepareStatement(sql);

            prepararSentencia.setString(1,docente.getNombre());
            prepararSentencia.setString(2,docente.getApellido());
            prepararSentencia.setString(3,docente.getTelefono());
            prepararSentencia.setString(4,docente.getEmail());

            prepararSentencia.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar docente: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Error cerrar BD: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean buscarDocenteId (Docente docente){
        PreparedStatement prepararSentencia;
        ResultSet alamcenBD;

        Connection cn = getConexion();

        String sql = "select * from docentes where id_docente = ? and estado = 1";

        try {
            prepararSentencia = cn.prepareStatement(sql);
            prepararSentencia.setInt(1,docente.getIdDocente());
            alamcenBD = prepararSentencia.executeQuery();

            if(alamcenBD.next()){
                docente.setNombre(alamcenBD.getString("nombre"));
                docente.setApellido(alamcenBD.getString("apellido"));
                docente.setTelefono(alamcenBD.getString("telefono"));
                docente.setEmail(alamcenBD.getString("email"));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar Docente: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar BD: " + ex.getMessage());
            }
        }

        return false;
    }

    public boolean modificarEstudiante (Docente docente){

        PreparedStatement prepararSentencia;
        ResultSet almacenBD;
        Connection cn = getConexion();

        String sql = "update docentes set nombre=?, apellido=?, telefono=?, email=?" +
                "where id_docente = ?";

        try {
            prepararSentencia = cn.prepareStatement(sql);
            prepararSentencia.setString(1,docente.getNombre());
            prepararSentencia.setString(2,docente.getApellido());
            prepararSentencia.setString(3,docente.getTelefono());
            prepararSentencia.setString(4,docente.getEmail());
            prepararSentencia.setInt(5,docente.getIdDocente());
            prepararSentencia.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al modificar docente: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar BD: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarDocente (Docente docente){

        PreparedStatement prepararSentencia;
        Connection cn = getConexion();

        String sql = "CALL usp_estadoDocente(?)";

        try {
            prepararSentencia = cn.prepareStatement(sql);
            prepararSentencia.setInt(1,docente.getIdDocente());
            prepararSentencia.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al Eliminar docente: " + e.getMessage());
        }finally {
            try {
                cn.close();
            } catch (Exception ex) {
                System.out.println("Error al cerrar BD: " + ex.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var docenteDao = new DocenteDAO();

        //agregar DOCENTE
        /*var nuevoDocente = new Docente("Cris","Martel","89563325","cm@gmail.com");
        var agregado = new DocenteDAO().agregarDocente(nuevoDocente);
        if(agregado)
            System.out.println("Docente agregado: " + nuevoDocente);
        else
            System.out.println("Error al agregar Docente");*/



        //listar DOCENTES
        /*System.out.println("Listado de Docentes: ");
        List<Docente> docentes = docenteDao.listarDocente();
        docentes.forEach(System.out::println);*/

        //Buscar Docente
        /*var buscarDocente = new Docente(5);
        var encontrado = docenteDao.buscarDocenteId(buscarDocente);

        if(encontrado){
            System.out.println("Docente encontrado: " + buscarDocente);
        }else{
            System.out.println("Docente no encontrado");
        }*/

        //modificar DOCENTES
        /*var modificarDocente = new Docente(2,"Nora","Inga","9222222220","ni@gmail.com");
        var modificado = docenteDao.modificarEstudiante(modificarDocente);
        if(modificado){
            System.out.println("Docente modificado: " + modificarDocente);
        }else {
            System.out.println("Docente no modificado");
        }*/

        //eliminar DOCENTES

        /*var eliminarDocente = new Docente(4);
        var eliminado = docenteDao.eliminarDocente(eliminarDocente);
        if(eliminado){
            System.out.println("Docente Eliminado: " + eliminarDocente);
        }else {
            System.out.println("Docente no ELIMINADO");
        }

        System.out.println("Listado de Docentes: ");
        List<Docente> docentes = docenteDao.listarDocente();
        docentes.forEach(System.out::println);*/


    }


}
