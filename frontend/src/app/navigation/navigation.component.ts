import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit{
  hovered=true;
  arr=[1,1,1,1,1,1,1,1];
  openCreateChat=false;
  openGroupChat=false;
  constructor(private router: Router){

  }
  ngOnInit(): void {
    // this.router.navigate(['/navigation'])
  }
 collaps(e:any,t:boolean)
  {
  this.hovered=t;
  e.stopPropagation()
  }
  

}
