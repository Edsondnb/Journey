package com.contactos.controlador;


import com.contactos.modelo.Contacto;
import com.contactos.servicio.ContactoServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ContactoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    ContactoServicio contactoServicio;

    /************************************************/
    /***********lISTASDO DE CONTACTOS****************/
    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Contacto> contactos = contactoServicio.listarContactos();
        contactos.forEach((contacto -> logger.info(contacto.toString())));
        modelo.put("contactos", contactos);
        return "index";
    }

    /********************Mostrar pagina Agrega*********************/
    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar"; //agregar.html
    }


    /************************************************/
    /***********AGREGAR CONTACTOS****************/
    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto){
        logger.info("Contacto agregado: " + contacto);
        contactoServicio.agregarContacto(contacto);
        return "redirect:/"; //redirigir al controlador el path "/" (inicio)
    }


    /***********Mostrar EDITAR CONTACTOS****************/
    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable( value = "id") int idContacto,
                                ModelMap modelo){
        Contacto contacto = contactoServicio.buscarContactoPorId(idContacto);
        logger.info("Contacto a editar: " + contacto);
        modelo.put("contacto", contacto);
        return "editar";
    }

    /************************************************/
    /***********EDITAR CONTACTOS****************/
    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") Contacto contacto){
        logger.info("Contacto editado: " + contacto);
        contactoServicio.agregarContacto(contacto);
        return "redirect:/"; //redirigir al controlador el path "/" (inicio)
    }




    /************************************************/
    /***********ELIMINAR CONTACTOS****************/
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable (value = "id") int idContacto){
        logger.info("Contacto editado: " + idContacto);
        Contacto contacto = new Contacto();
        contacto.setIdContacto(idContacto);
        contactoServicio.eliminarContacto(contacto);
        return "redirect:/"; //redirigir al controlador el path "/" (inicio)
    }

}
