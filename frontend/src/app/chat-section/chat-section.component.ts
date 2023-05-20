import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-chat-section',
  templateUrl: './chat-section.component.html',
  styleUrls: ['./chat-section.component.scss']
})
export class ChatSectionComponent implements OnInit {
message:Array<string>=["d","f","d","f","d","f","d","f","d","f","d","f","d","f","d","f","d","f","d","f","d","f","d","f"]
@Input() chatId='';
  constructor(){

  }
  @ViewChild('chatSection') chatSectionRef!: ElementRef<HTMLDivElement>;
 
  ngOnInit(): void {
    setTimeout(() => this.scrollToBottom(), 0);
  }
  
  addMessage(message: string): void {
    // Add message to chat section
    this.message.push(message);
    setTimeout(() => this.scrollToBottom(), 100);
    // Scroll to bottom of chat section
    this.scrollToBottom();
  }
  ngAfterViewInit(){
    this.scrollToBottom();
  }

  private scrollToBottom(): void {
    const chatSection = this.chatSectionRef.nativeElement;
    chatSection.scrollTop = chatSection.scrollHeight;
  const lastChild = chatSection.lastElementChild;
  if (lastChild) {
    lastChild.scrollIntoView({ behavior: 'smooth', block: 'end' });
  }
  }
}
