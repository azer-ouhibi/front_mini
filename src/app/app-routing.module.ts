import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [ { path: 'rendezVous', loadChildren: () => import('./rendez-vous/rendez-vous.module').then(m => m.RendezVousModule) }, { path: 'departement', loadChildren: () => import('./departement/departement.module').then(m => m.DepartementModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
