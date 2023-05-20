import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-create-chat',
  templateUrl: './create-chat.component.html',
  styleUrls: ['./create-chat.component.scss']
})
export class CreateChatComponent implements OnInit {
  
  @Output() openCreateChat=new EventEmitter<boolean>();
  constructor(){

  }
  ngOnInit(): void {
   
  }
  search(e:any)
  {

  }
  onCross()
  {
    this.openCreateChat.emit();
  }

}
