import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from '../app/header/header.component';
import { FooterComponent } from '../app/footer/footer.component';
import { AlumnosComponent } from '../app/alumnos/alumnos.component';

import { AlumnoService } from '../app/alumnos/alumno.service';
import { RouterModule, Routes  } from '@angular/router' ;
import { HttpClientModule } from '@angular/common/http';
import { FormComponent } from './alumnos/form.component';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {path: '', redirectTo: '/alumnos', pathMatch: 'full'},
  {path: 'listadoAlumnos', component: AlumnosComponent},
  {path: 'alumnos/form', component: FormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AlumnosComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule ,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [AlumnoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
