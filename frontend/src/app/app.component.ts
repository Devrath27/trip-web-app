import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from './api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  isLogedin=false;
  constructor(private router: Router,private apiService:ApiService){

  }

  ngOnInit(): void {
    if(localStorage.getItem('authToken')) this.isLogedin=true,this.apiService.logedIn$.next(true);
    else this.isLogedin=false,this.apiService.logedIn$.next(false);
    this.apiService.logedIn$.subscribe(data=>this.isLogedin=data);
    if(this.isLogedin)
    this.router.navigate(['/navigation'])
    else this.router.navigate(['/authenticate'])
  }
}
