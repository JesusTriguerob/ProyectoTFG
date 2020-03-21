import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from '../app/header/header.component';
import { FooterComponent } from '../app/footer/footer.component';
import { AlumnosComponent } from '../app/alumnos/alumnos.component';

import { AlumnoService } from '../app/alumnos/alumno.service';
import { RouterModule, Routes  } from '@angular/router' ;

const routes: Routes = [
  {path: '', redirectTo: '/alumnos', pathMatch: 'full'},
  {path: 'listadoAlumnos', component: AlumnosComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AlumnosComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [AlumnoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
