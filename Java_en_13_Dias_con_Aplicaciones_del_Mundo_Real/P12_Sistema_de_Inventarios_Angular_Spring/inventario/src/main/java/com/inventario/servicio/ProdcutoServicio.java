package com.inventario.servicio;

import com.inventario.modelo.Producto;
import com.inventario.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdcutoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listadoProductos() {
        return this.productoRepositorio.findAll();
    }

    @Override
    public Producto bucsarProductoPorId(Integer idProducto) {
        Producto producto = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        this.productoRepositorio.save(producto);
        return producto;
    }

    @Override
    public void eliminarProcutoPorId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }


}
