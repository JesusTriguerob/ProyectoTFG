import { Injectable } from '@angular/core';
import { Libro } from './libro';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable()
export class LibroService {

  private urlEndPoint:string = 'http://localhost:8080/api/biblioteca';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }

  getLibros(): Observable<Libro[]> {

    return this.http.get(this.urlEndPoint).pipe(
      map( (response) => response as Libro[] )
    );
  }

  create(libro: Libro) : Observable<Libro>{
    return this.http.post<Libro>(this.urlEndPoint, libro, {headers: this.httpHeaders})
  }

  getLibro(id): Observable<Libro>{
    return this.http.get<Libro>(`${this.urlEndPoint}/${id}`)
  }

  update(libro: Libro) : Observable<Libro>{
    return this.http.put<Libro>(`${this.urlEndPoint}/${libro.id}`,libro,{headers: this.httpHeaders} )
  }

  delete(id: number) : Observable<Libro>{
    return this.http.delete<Libro>(`${this.urlEndPoint}/${id}`,{headers: this.httpHeaders})
  }

  info(id) : Observable<Libro>{
      return this.http.get<Libro>(`/biblioteca/infoLibro/${id}`)
  }

  alquilar(libro: Libro) : Observable<Libro>{
    return this.http.post<Libro>(this.urlEndPoint, libro, {headers: this.httpHeaders})
  }
}
