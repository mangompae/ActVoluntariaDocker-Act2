import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../../services/persona.service';


@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {
  personas: any[] = [];
  nuevaPersona = { nombre: '', edad: '' };

  constructor(private personaService: PersonaService) {}

  ngOnInit() {
    this.getPersonas();
  }

  getPersonas() {
    this.personaService.getPersonas().subscribe(data => {
      this.personas = data;
    });
  }

  addPersona() {
    this.personaService.addPersona(this.nuevaPersona).subscribe(() => {
      this.getPersonas();
      this.nuevaPersona = { nombre: '', edad: '' };
    });
  }
}