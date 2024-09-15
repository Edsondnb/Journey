import { Component } from '@angular/core';
import { Producto } from '../producto';
import { Route, Router } from '@angular/router';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-agregar-producto',
  templateUrl: './agregar-producto.component.html',
  styleUrl: './agregar-producto.component.css'
})
export class AgregarProductoComponent {

  producto: Producto = new Producto();

  constructor(private productoServicio: ProductoService, private enrutador: Router) {}

  onSubmit() {
    this.guardarProducto();
  }

  guardarProducto() {
    this.productoServicio.agregarProducto(this.producto).subscribe(
      {
        next: (datos) => {
          this.irListaProducto();
        },
        error: (error:any) => {
          console.log(error)
        }
      }
    );
  }

  irListaProducto() {
    this.enrutador.navigate(['/productos']);
  }

}
