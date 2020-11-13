import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService } from './usuario.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UsuarioComponent implements OnInit {

usuarios: Usuario[];

constructor(private usuarioService: UsuarioService) { }

ngOnInit() {
  this.usuarioService.getUsuarios().subscribe(
    usuarios => this.usuarios = usuarios
  );
}

public delete(usuario: Usuario): void{
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

    this.usuarioService.delete(usuario.id).subscribe(
      response => {
        this.usuarios = this.usuarios.filter(usu => usu !== usuario)
        swal.fire(
          'Borrado!',
          'El usuario a sido borrado con éxito',
          'success'
        )
      }
    )
  }
})
}
}
