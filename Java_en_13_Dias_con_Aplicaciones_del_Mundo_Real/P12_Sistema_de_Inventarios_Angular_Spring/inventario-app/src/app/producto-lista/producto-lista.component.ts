import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html',
})
export class ProductoListaComponent {

  productos: Producto[];

  constructor(private productoServicio: ProductoService, private enrutador: Router) {}

  ngOnInit(): void {
    //cargar todos lo producto
    this.obtenerProductos();
  
  }

  private obtenerProductos() {
    //consumir los datos observable (suscribirnos)
    this.productoServicio.obtenerProductosLista().subscribe(
      (datos => {
        this.productos = datos;  
      })
    );
  }

  editarProducto(id: number){
    this.enrutador.navigate(['editar-producto', id]);
  }

  eliminarProducto(id: number){
    this.productoServicio.eliminarProducto(id).subscribe({
      next: (data) => this.obtenerProductos(),
      error: (errores) => console.log(errores)
    });
  }

}
