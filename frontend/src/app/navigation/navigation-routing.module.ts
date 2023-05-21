import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavigationComponent } from './navigation.component';


const routes: Routes = [
   {
    path:'navigation',
    component:NavigationComponent

   },
   {
    path:'navigation/chat/:id',
    component:NavigationComponent

   }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NavigationRoutingModule { }
