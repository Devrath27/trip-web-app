import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { ButtonComponent } from './button/button.component';
import { PopUpComponent } from './pop-up/pop-up.component';



@NgModule({
  declarations: [
    UserComponent,
    ButtonComponent,
    PopUpComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    UserComponent,
    ButtonComponent,
    PopUpComponent
  ]
})
export class SharedModule { }
