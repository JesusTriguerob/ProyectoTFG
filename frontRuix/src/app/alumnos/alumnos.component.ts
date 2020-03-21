import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { AlumnoService } from './alumno.service';

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

}
