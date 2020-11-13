import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from '../app/header/header.component';
import { FooterComponent } from '../app/footer/footer.component';
import { UsuarioComponent } from '../app/usuarios/usuarios.component';
import { UsuarioService } from '../app/usuarios/usuario.service';
import { RouterModule, Routes  } from '@angular/router' ;
import { HttpClientModule } from '@angular/common/http';
import { FormComponent } from './usuarios/form.component';
import { PoputInfoComponent } from './usuarios/poputInfo.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BibliotecaComponent } from './biblioteca/biblioteca.component';
import { LibroService } from '../app/biblioteca/libro.service';
import { FormLibroComponent } from './biblioteca/formLibro.component';


const routes: Routes = [
  {path: '', redirectTo: '/usuarios', pathMatch: 'full'},
  {path: 'listadoUsuarios', component: UsuarioComponent},
  {path: 'usuarios/form', component: FormComponent},
  {path: 'usuarios/form/:id', component: FormComponent},
  {path: 'usuarios/poputInfo/:id', component: PoputInfoComponent},
  {path: 'api/usuarios/:id', component: UsuarioComponent},
  {path: 'biblioteca', component: BibliotecaComponent},
  {path: 'biblioteca/formLibro', component: FormLibroComponent},
  {path: 'biblioteca/formLibro/:id', component: FormLibroComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UsuarioComponent,
    FormComponent,
    FormLibroComponent,
    PoputInfoComponent,
    BibliotecaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule ,
    RouterModule.forRoot(routes),
    FormsModule,
    NgbModule,
    MatTableModule,
    MatPaginatorModule,
    BrowserAnimationsModule
  ],
  providers: [UsuarioService,LibroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
