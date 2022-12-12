import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { AppRoutingModule } from './app-routing.module';

const routes: Routes = [ { path: 'universite', loadChildren: () => import('./universite/universite.module').then(m => m.UniversiteModule  ) }, { path: 'departement', loadChildren: () => import('./departement/departement.module').then(m => m.DepartementModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
