package com.tienda_libros.vista;

import com.tienda_libros.modelo.Libro;
import com.tienda_libros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LibroForm extends JFrame {

    private JPanel panel;
    private JTable tablaLibros;
    private JTextField txtId;
    private JTextField txtLibro;
    private JTextField txtAutor;
    private JTextField txtPrecio;
    private JTextField txtExistencias;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton bntEliminar;
    private DefaultTableModel tablaModeloLibros;


    LibroServicio libroServicio;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregrarLibro();
            }
        });


        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSelecionado();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarLibro();
            }
        });
        bntEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
    }


    private void iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //para centrar
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //creamos el elemnto txtId oculto
        txtId = new JTextField("");
        txtId.setVisible(false);

        this.tablaModeloLibros = new DefaultTableModel(0, 5){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabeceros = {"id", "Libro", "Autor", "precio", "Existencia"};
        this.tablaModeloLibros.setColumnIdentifiers(cabeceros);

        //creando objeto Jtable
        this.tablaLibros = new JTable(tablaModeloLibros);

        //evitar que se seleccionen varios registros de la tabla
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listarLibros();

    }

    private void cargarLibroSelecionado(){
        //Los inidices de las columnas inician en 0
        var renglon = tablaLibros.getSelectedRow();

        if(renglon != -1){//Regresa -1 si no se selecciono un registro
            String idLibro =
                    tablaLibros.getModel().getValueAt(renglon,0).toString();
            txtId.setText(idLibro);

            String nombreLibro =
                    tablaLibros.getModel().getValueAt(renglon, 1).toString();
            txtLibro.setText(nombreLibro);

            String autor =
                    tablaLibros.getModel().getValueAt(renglon, 2).toString();
            txtAutor.setText(autor);

            String precio =
                    tablaLibros.getModel().getValueAt(renglon, 3).toString();
            txtPrecio.setText(precio);

            String existencias =
                    tablaLibros.getModel().getValueAt(renglon, 4).toString();
            txtExistencias.setText(existencias);


        }
    }

    /*********************FUNCIONALIDAD*****************************/
    private void listarLibros(){
        //Limpiar la tabla
        tablaModeloLibros.setRowCount(0);
        //Obtener los libros
        var libros = libroServicio.listarLibros();
        libros.forEach((libro) -> {
            Object[] reglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(reglonLibro);
        });
    }

    public void agregrarLibro(){
        //leer los valores del formulario
        if(txtLibro.getText().equals("")){
            mostrarMensaje("Proporciona el nombre del libro");
            txtLibro.requestFocusInWindow();
            return;
        }

        var nombreLibro = txtLibro.getText();
        var autor = txtAutor.getText();
        var precio = Double.parseDouble(txtPrecio.getText());
        var existencias = Integer.parseInt(txtExistencias.getText());

        //creando el nuevo libro
        var libro = new Libro();
        libro.setNombreLibro(nombreLibro);
        libro.setAutor(autor);
        libro.setPrecio(precio);
        libro.setExistencias(existencias);

        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agrego el libro!!");
        limpiarFormulario();

        //actualziar la tabla
        listarLibros();
    }

    private void modificarLibro(){
        if(txtId.getText().equals("")){
            mostrarMensaje("Ddebe selecionar un registro...");
        }else {
             //verificar que el nombre del libro no sea nulo
            if(txtLibro.getText().equals("Proporcionar el nombre del libro")){
                txtLibro.requestFocusInWindow();
                return;
            }

            //llenamos el objeto a actulizar
            int idLibro = Integer.parseInt(txtId.getText());
            var nombreLibro = txtLibro.getText();
            var autor = txtAutor.getText();
            var precio = Double.parseDouble(txtPrecio.getText());
            var existencias = Integer.parseInt(txtExistencias.getText());

            var libro = new Libro(idLibro, nombreLibro, autor, precio, existencias);
            libroServicio.guardarLibro(libro);

            mostrarMensaje("Se modifico el libro...");
            limpiarFormulario();
            listarLibros();

        }
    }

    private void eliminarLibro(){
        var renglon = tablaLibros.getSelectedRow();
        if(renglon != 1){
            String idLibro = tablaLibros.getModel().getValueAt(renglon, 0).toString();
            var libro = new Libro();
            libro.setIdLibro(Integer.parseInt(idLibro));
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro eliminado");
            limpiarFormulario();
            listarLibros();
        }else{
            mostrarMensaje("No se ha seleccionado ningun libro a elimina");
        }
    }


    void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    void limpiarFormulario(){
        txtLibro.setText("");
        txtAutor.setText("");
        txtPrecio.setText("");
        txtExistencias.setText("");
    }

}
