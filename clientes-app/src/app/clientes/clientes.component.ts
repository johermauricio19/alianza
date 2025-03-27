import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';

interface Cliente {
  id: number;
  nombre: string;
  telefono: string;
  correo: string;
  fechaInicio: string;
  fechaFin: string;
}

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[] = [];

  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe((data) => {
      this.clientes = data;
    });
  }

  exportar() {
    this.clienteService.exportarClientes().subscribe((response) => {
      const url = window.URL.createObjectURL(response);
      const link = document.createElement('a');
      link.href = url;
      link.download = 'clientes.csv';
      link.click();
    });
  }
}
