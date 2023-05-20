import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationComponent } from './navigation.component';
import { RouterModule, Routes } from '@angular/router';
import { CreateChatComponent } from './create-chat/create-chat.component';
import { CreateGroupComponent } from './create-group/create-group.component';
import { SharedModule } from '../shared/shared.module';
import { ChatSectionModule } from '../chat-section/chat-section.module';
import { NavigationRoutingModule } from './navigation-routing.module';


const routes: Routes = [
  { path: '', component: NavigationComponent }
];

@NgModule({
  declarations: [
    NavigationComponent,
    CreateChatComponent,
    CreateGroupComponent,
    
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    SharedModule,
    ChatSectionModule,
    NavigationRoutingModule
    
  ],
  exports: [RouterModule,NavigationComponent]
})
export class NavigationModule { }
