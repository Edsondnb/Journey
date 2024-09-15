package com.empleados.servicio;

import com.empleados.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {

    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorID(Integer idEmpleado);

    public void agregarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);



}
