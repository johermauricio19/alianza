import { RenderMode, ServerRoute } from '@angular/ssr';
import { ClientesComponent } from './clientes/clientes.component';

export const serverRoutes: ServerRoute[] = [
  {
    path: '**',
    renderMode: RenderMode.Prerender, 
    
  }
];
