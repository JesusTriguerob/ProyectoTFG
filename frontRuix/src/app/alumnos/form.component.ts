import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { AlumnoService } from './alumno.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

alumno: Alumno = new Alumno()
titulo:string = "Crear Alumno"

  constructor(private alumnoService: AlumnoService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarAlumno();
  }

  cargarAlumno():void{
    this.activatedRoute.params.subscribe(params => {
    let id = params['id']
    if(id){
    this.alumnoService.getAlumno(id).subscribe( (alumno) => this.alumno = alumno)
    }
    })
  }

  public create(): void{
    this.alumnoService.create(this.alumno)
    .subscribe(alumno => {
        this.router.navigate(['/listadoAlumnos'])
        swal.fire('Alumno creado' , `El alumno ${alumno.nombre} ha sido creado con éxito!`, 'success' )
      }
    );
  }

  public update(): void{
    this.alumnoService.update(this.alumno)
    .subscribe(alumno =>{
      this.router.navigate(['/listadoAlumnos'])
      swal.fire('Alumno actualizado' , `El alumno ${alumno.nombre} ha sido actualizado con éxito!`, 'success' )
    })
  }
}
