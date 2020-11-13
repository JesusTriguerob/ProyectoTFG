import { Injectable } from '@angular/core';
import { Usuario } from './usuario';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable()
export class UsuarioService {

  private urlEndPoint:string = 'http://localhost:8080/api/usuarios';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]> {

    return this.http.get(this.urlEndPoint).pipe(
      map( (response) => response as Usuario[] )
    );
  }

  create(usuario: Usuario) : Observable<Usuario>{
    return this.http.post<Usuario>(this.urlEndPoint, usuario, {headers: this.httpHeaders})
  }

  getUsuario(id): Observable<Usuario>{
    return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`)
  }

  update(usuario: Usuario) : Observable<Usuario>{
    return this.http.put<Usuario>(`${this.urlEndPoint}/${usuario.id}`,usuario,{headers: this.httpHeaders} )
  }

  delete(id: number) : Observable<Usuario>{
    return this.http.delete<Usuario>(`${this.urlEndPoint}/${id}`,{headers: this.httpHeaders})
  }

  info(id) : Observable<Usuario>{
    // return this.http.put<Usuario>(`infoUsuario/info/${usuario.id}`,usuario,{headers: this.httpHeaders} )
      return this.http.get<Usuario>(`/usuarios/infoUsuario/info/${id}`)
  }
}
