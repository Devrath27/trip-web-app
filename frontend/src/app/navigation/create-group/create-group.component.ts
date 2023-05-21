import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {
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
