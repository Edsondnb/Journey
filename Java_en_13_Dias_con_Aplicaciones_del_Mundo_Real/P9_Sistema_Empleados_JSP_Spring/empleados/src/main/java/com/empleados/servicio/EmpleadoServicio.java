package com.empleados.servicio;

import com.empleados.modelo.Empleado;
import com.empleados.repositorio.EmpleadoRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private EmpleadoRespositorio empleadoRespositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRespositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorID(Integer idEmpleado) {
        Empleado empleado = empleadoRespositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        empleadoRespositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRespositorio.delete(empleado);
    }
}
