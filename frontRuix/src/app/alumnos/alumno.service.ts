import { Injectable } from '@angular/core';
import { Alumno } from './alumno';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable()
export class AlumnoService {

  private urlEndPoint:string = 'http://localhost:8080/api/alumnos';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }

  getAlumnos(): Observable<Alumno[]> {
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Alumno[])
    )
  }

  create(alumno: Alumno) : Observable<Alumno>{
    return this.http.post<Alumno>(this.urlEndPoint, alumno, {headers: this.httpHeaders})
  }

  getAlumno(id): Observable<Alumno>{
    return this.http.get<Alumno>(`${this.urlEndPoint}/${id}`)
  }

  update(alumno: Alumno) : Observable<Alumno>{
    return this.http.put<Alumno>(`${this.urlEndPoint}/${alumno.id}`,alumno,{headers: this.httpHeaders} )
  }

  delete(id: number) : Observable<Alumno>{
    return this.http.delete<Alumno>(`${this.urlEndPoint}/${id}`,{headers: this.httpHeaders})
  }
}
