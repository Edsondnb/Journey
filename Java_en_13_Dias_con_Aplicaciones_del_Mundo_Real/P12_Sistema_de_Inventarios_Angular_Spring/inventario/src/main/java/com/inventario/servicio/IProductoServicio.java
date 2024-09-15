package com.inventario.servicio;

import com.inventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto> listadoProductos();

    public Producto bucsarProductoPorId (Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProcutoPorId (Integer idProducto);
}
