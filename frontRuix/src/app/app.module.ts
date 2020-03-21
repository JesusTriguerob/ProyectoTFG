import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from '../app/header/header.component';
import { FooterComponent } from '../app/footer/footer.component';
import { AlumnosComponent } from '../app/alumnos/alumnos.component';

import { AlumnoService } from '../app/alumnos/alumno.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AlumnosComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [AlumnoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
