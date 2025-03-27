import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private apiUrl = 'http://localhost:8080/api/clientes';  // Cambia a la URL de tu API

  constructor(private http: HttpClient) { }

  // Método para obtener la lista de clientes
  getClientes(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  // Método para exportar los clientes a CSV
  exportarClientes(): Observable<Blob> {
    return this.http.get(`${this.apiUrl}/exportar`, { responseType: 'blob' });
  }
}
