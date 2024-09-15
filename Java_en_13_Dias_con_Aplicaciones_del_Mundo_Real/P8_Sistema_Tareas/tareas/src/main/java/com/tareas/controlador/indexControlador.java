package com.tareas.controlador;

import com.tareas.modelo.Tarea;
import com.tareas.servicio.TareaServicio;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class indexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(indexControlador.class);

    //integrar el servicio de spring
    @Autowired
    private TareaServicio tareaServicio;

    //mapeando los elementos de de javafx
    @FXML
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea, Integer> idTareaColumna;
    @FXML
    private TableColumn<Tarea, String> nombreTareaColumna;
    @FXML
    private TableColumn<Tarea, String> responsableTareaColumna;
    @FXML
    private TableColumn<Tarea, String> estatusTareaColumna;


    //refrescar la lista en caso de actulizacion
    private final ObservableList<Tarea> tareaList  = FXCollections.observableArrayList();

    @FXML
    private TextField txtTarea;
    @FXML
    private TextField txtResponsable;
    @FXML
    private TextField txtEstatus;
    private Integer idTareaInterno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //SOLO SE SELECCIONE UN ELELMENTO
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //configurar las colimnas para cargar info de la BD
        configurarColumnas();

        listarTareas();


    }


    private void configurarColumnas(){
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableTareaColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusTareaColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }

    private void listarTareas(){
        logger.info("Ejecutando listado de tareas");

        tareaList.clear();
        tareaList.addAll(tareaServicio.listarTareas());

        //relacionanado el objeto lista agregar la info a la tabla
        tareaTabla.setItems(tareaList);

    }

    /************Agregar tareas************/
    public void agregarTarea(){
        if(txtTarea.getText().isEmpty()){
            mostrarMensaje("Error de validacion","Debe proporcionar una tarea");
            txtTarea.requestFocus();
        } else if (txtResponsable.getText().isEmpty()) {
            mostrarMensaje("Error de validacion","Debe proporcionar un responsable");
            txtResponsable.requestFocus();
        } else if (txtEstatus.getText().isEmpty()) {
            mostrarMensaje("Error de validacion","Agrege un estatus");
            txtEstatus.requestFocus();
        }else {
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);

            tarea.setIdTarea(null);

            tareaServicio.guardarTarea(tarea);
            mostrarMensaje("Informacion", "Tarea agregada");
            limpiarFormulario();
            listarTareas();

        }

    }

    /************MODIFICAR tareas************/

    public void cargarTareaFormulario(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if(tarea != null){
            idTareaInterno = tarea.getIdTarea();
            txtTarea.setText(tarea.getNombreTarea());
            txtResponsable.setText(tarea.getResponsable());
            txtEstatus.setText(tarea.getEstatus());
        }
    }

    public void modificarTarea(){
        if(idTareaInterno == null){
            mostrarMensaje("Informacion", "Debe selecionar una tarea");
            return;
        }

        if(txtTarea.getText().isEmpty()){
            mostrarMensaje("Error de validacion","Debe proporcionar una tarea");
            txtTarea.requestFocus();
        } else if (txtResponsable.getText().isEmpty()) {
            mostrarMensaje("Error de validacion","Debe proporcionar un responsable");
            txtResponsable.requestFocus();
        } else if (txtEstatus.getText().isEmpty()) {
            mostrarMensaje("Error de validacion","Agrege un estatus");
            txtEstatus.requestFocus();
        }else {
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            tareaServicio.guardarTarea(tarea);

            mostrarMensaje("Informacion", "Tarea modificada");
            limpiarFormulario();
            listarTareas();
        }
    }

    /************Eliminar tareas************/
    public void eliminarTarea(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if(tarea != null){
            logger.info("Registro a eliminar " + tarea.toString());
            tareaServicio.eliminarTarea(tarea);
            mostrarMensaje("Info", "Tarea eliminada: " + tarea.getIdTarea());
            limpiarFormulario();
            listarTareas();
        }else {
            mostrarMensaje("Error", "No se ha seleecionado ninguna tarea");
        }
    }



    private void mostrarMensaje(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void recolectarDatosFormulario(Tarea tarea){

        if(idTareaInterno != null){
            tarea.setIdTarea(idTareaInterno);
        }

        tarea.setNombreTarea(txtTarea.getText());
        tarea.setResponsable(txtResponsable.getText());
        tarea.setEstatus(txtEstatus.getText());


    }

    public void limpiarFormulario(){
        idTareaInterno = null;
        txtTarea.clear();
        txtResponsable.clear();
        txtEstatus.clear();
    }


}
