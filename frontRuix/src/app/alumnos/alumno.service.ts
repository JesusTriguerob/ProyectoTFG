import { Injectable } from '@angular/core';
import { ALUMNOS } from './alumnos.json';
import { Alumno } from './alumno';
import { Observable, of } from 'rxjs';

@Injectable()
export class AlumnoService {

  constructor() { }

  getAlumnos(): Observable<Alumno[]> {
    return of(ALUMNOS);
  }

}
