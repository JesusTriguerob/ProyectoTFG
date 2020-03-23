import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { AlumnoService } from './alumno.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html'
})
export class AlumnosComponent implements OnInit {

alumnos: Alumno[];

constructor(private alumnoService: AlumnoService) { }

ngOnInit() {
  this.alumnoService.getAlumnos().subscribe(
    alumnos => this.alumnos = alumnos
  );
}

public delete(alumno: Alumno): void{
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

    this.alumnoService.delete(alumno.id).subscribe(
      response => {
        this.alumnos = this.alumnos.filter(alu => alu !== alumno)
        swal.fire(
          'Borrado!',
          'El alumno a sido borrado con éxito',
          'success'
        )
      }
    )
  }
})
}
}
