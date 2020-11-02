import { Component, OnInit } from '@angular/core';
import { Libro } from './libro';
import { LibroService } from './libro.service';
import swal from 'sweetalert2'
@Component({
  selector: 'app-biblioteca',
  templateUrl: './biblioteca.component.html',
  styleUrls: ['./biblioteca.component.css']
})
export class BibliotecaComponent implements OnInit {

libros: Libro[];
libro: Libro;
librosAlquilados: Libro[];

  constructor(private libroService: LibroService) { }

  ngOnInit(): void {
    this.libroService.getLibros().subscribe(
      libros => this.libros = libros.filter(lib => lib.alquilado == "DISPONIBLE")
    );
    this.libroService.getLibrosForState().subscribe(
      librosAlquilados => this.librosAlquilados = librosAlquilados.filter(lib => lib.alquilado == "ALQUILADO")
    );
  }

  public alquilar(libro: Libro): void{
    swal.fire({
    title: '¿Quieres alquilar este libro?',
    text: "",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Sí, alquilar'
  }).then((result) => {
    if (result.value) {
      this.libroService.getLibrosForState();
      this.libroService.alquilar(libro).subscribe(
        response => {
          this.libros = this.libros.filter(lib => lib !== libro) // Quita el libro alquilado de la lista y se añade a alquilados.
          swal.fire(
            'Alquilado!',
            'El libro a sido alquilado con éxito',
            'success'
          )
        }
      )
    }
  })
  }

  public delete(libro: Libro): void{
    swal.fire({
    title: 'Estas seguro?',
    text: "¡Una vez borrado no hay vuelta atras!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Sí, borrar'
  }).then((result) => {
    if (result.value) {

      this.libroService.delete(libro.id).subscribe(
        response => {
          this.libros = this.libros.filter(lib => lib !== libro)
          swal.fire(
            'Borrado!',
            'El libro a sido borrado con éxito',
            'success'
          )
        }
      )
    }
  })
  }
  }
