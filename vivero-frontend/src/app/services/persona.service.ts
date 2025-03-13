import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  private apiUrl = 'http://localhost:9999/persona';

  constructor(private http: HttpClient) { }

  getPersonas(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  addPersona(persona: any): Observable<any> {
    return this.http.post(this.apiUrl, persona);
  }
}

