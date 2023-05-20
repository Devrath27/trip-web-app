import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  isLogedin=true;
  constructor(private router: Router){

  }
  ngOnInit(): void {
    if(this.isLogedin)
    this.router.navigate(['/navigation'])
    else this.router.navigate(['/authenticate'])
  }
}
