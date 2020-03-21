import { Injectable } from '@angular/core';
import { ALUMNOS } from './alumnos.json';
import { Alumno } from './alumno';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable()
export class AlumnoService {

  private urlEndPoint:string = 'http://localhost:8080/api/alumnos';

  constructor(private http: HttpClient) { }

  getAlumnos(): Observable<Alumno[]> {
    return this.http.get(this.urlEndPoint).pipe(
      map( response => response as Alumno[] )
    )
  }

}
