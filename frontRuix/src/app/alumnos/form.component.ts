import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

alumno: Alumno = new Alumno()
titulo:string = "Crear Alumno"

  constructor() { }

  ngOnInit() {
  }

  public create():void{
    console.log("Creado!");
    console.log(this.alumno);
  }
}
