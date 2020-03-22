import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { AlumnoService } from './alumno.service';
import { Router } from '@angular/router';
import swal from 'sweetalert2'
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

alumno: Alumno = new Alumno()
titulo:string = "Crear Alumno"

  constructor(private alumnoService: AlumnoService, private router: Router) { }

  ngOnInit() {
  }

  public create(): void{
    this.alumnoService.create(this.alumno)
    .subscribe(alumno => {
        this.router.navigate(['/listadoAlumnos'])
        swal.fire('Nuevo alumno' , `Alumno ${alumno.nombre} creado con éxito!`, 'success' )
      }
    );
}

}
