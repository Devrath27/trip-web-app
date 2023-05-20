import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './authentication/authentication.component';
import { NavigationComponent } from './navigation/navigation.component';

const routes: Routes = [
  {
  path: 'navigation', 
  loadChildren: () => import('./navigation/navigation.module').then(m => m.NavigationModule),
  
  },
  {
    path:'authenticate',
    component:AuthenticationComponent
  },
  {
    path:'navigation/chat/:id',
    loadChildren: () => import('./navigation/navigation.module').then(m => m.NavigationModule),
 }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
