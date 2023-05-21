import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-chat-footer',
  templateUrl: './chat-footer.component.html',
  styleUrls: ['./chat-footer.component.scss']
})
export class ChatFooterComponent implements OnInit {
  @Output() onSend=new EventEmitter<string>();
  ngOnInit(): void {
   
  }
  constructor(){}
  @ViewChild('message', { static: true }) myDiv!: ElementRef;

  removeAllChildElements(): void {
    let x=document.getElementById('message');
    if(x && x.innerHTML) x.innerHTML='';
  //   const childElements = document.getElementById('message')?.childNodes
  //   if(childElements){
  //   childElements.forEach((child:any) => {
     
  //     if(x)
  //     x.removeChild(child);
  //   });
  // }
  }
  sendMessage(e:any)
  { 
    if(e==0) {
      let x=document.getElementById('message');
    if(x)
      this.onSend.emit(x.innerHTML);
      this.removeAllChildElements();
    }
    else if(e.shiftKey && e.keyCode === 13) return;
    else if(e.key=='Enter'){ 
      e.preventDefault();
     let x=document.getElementById('message');
    if(x)
      this.onSend.emit(x.innerHTML);
      this.removeAllChildElements();
     
      }
  }


}
