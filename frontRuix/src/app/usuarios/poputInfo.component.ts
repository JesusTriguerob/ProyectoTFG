import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService } from './usuario.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './poputInfo.component.html'
})
export class PoputInfoComponent implements OnInit {

usuario: Usuario = new Usuario()
titulo:string = "Crear/Modificar Usuario"

  constructor(private usuarioService: UsuarioService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarUsuario();
  }

  cargarUsuario():void{
    this.activatedRoute.params.subscribe(params => {
    let id = params['id']
    if(id){
    this.usuarioService.getUsuario(id).subscribe( (usuario) => this.usuario = usuario)
    }
    })
  }

  public create(): void{
    this.usuarioService.create(this.usuario)
    .subscribe(usuario => {
        this.router.navigate(['/listadoUsuarios'])
        swal.fire('Usuario creado' , `El usuario ${usuario.nombre} ha sido creado con éxito!`, 'success' )
      }
    );
  }

  public update(): void{
    this.usuarioService.update(this.usuario)
    .subscribe(usuario =>{
      this.router.navigate(['/listadoUsuarios'])
      swal.fire('Usuario actualizado' , `El usuario ${usuario.nombre} ha sido actualizado con éxito!`, 'success' )
    })
  }
}
