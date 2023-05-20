import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatSectionRoutingModule } from './chat-section-routing.module';
import { ChatSectionComponent } from './chat-section.component';
import { ChatHeaderComponent } from './chat-header/chat-header.component';
import { ChatFooterComponent } from './chat-footer/chat-footer.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    ChatSectionComponent,
    ChatHeaderComponent,
    ChatFooterComponent
  ],
  imports: [
    CommonModule,
    ChatSectionRoutingModule,
    SharedModule
  ],
  exports:[
     ChatSectionComponent
  ]
})
export class ChatSectionModule { }
