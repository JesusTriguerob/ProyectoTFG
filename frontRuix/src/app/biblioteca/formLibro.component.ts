import { Component, OnInit } from '@angular/core';
import { Libro } from './libro';
import { LibroService } from './libro.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './formLibro.component.html'
})
export class FormLibroComponent implements OnInit {

libro: Libro = new Libro();
titulo:string = "Crear/Modificar Libro";

  constructor(private libroService: LibroService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarLibro();
  }

  cargarLibro():void{
    this.activatedRoute.params.subscribe(params => {
    let id = params['id']
    if(id){
    this.libroService.getLibro(id).subscribe( (libro) => this.libro = libro)
    }
    })
  }

  public create(): void{
    this.libroService.create(this.libro)
    .subscribe(libro => {
        this.router.navigate(['/biblioteca'])
        swal.fire('Libro creado' , `El libro ${libro.nombre} ha sido creado con éxito!`, 'success' )
      }
    );
  }

  public update(): void{
    this.libroService.update(this.libro)
    .subscribe(libro =>{
      this.router.navigate(['/biblioteca'])
      swal.fire('Libro actualizado' , `El libro ${libro.nombre} ha sido actualizado con éxito!`, 'success' )
    })
  }
}
