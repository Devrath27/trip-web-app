import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationComponent } from './navigation.component';
import { RouterModule, Routes } from '@angular/router';
import { CreateChatComponent } from './create-chat/create-chat.component';
import { CreateGroupComponent } from './create-group/create-group.component';


const routes: Routes = [
  { path: '', component: NavigationComponent }
];

@NgModule({
  declarations: [
    NavigationComponent,
    CreateChatComponent,
    CreateGroupComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    
  ],
  exports: [RouterModule]
})
export class NavigationModule { }
