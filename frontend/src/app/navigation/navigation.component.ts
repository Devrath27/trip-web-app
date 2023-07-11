import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, Route, Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit{
  hovered=false;
  arr=["1","2","3","4","5"];
  openCreateChat=false;
  openGroupChat=false;
  isOpenChat=false;
chatId=""
  constructor(private router: Router,private route: ActivatedRoute, private apiService:ApiService){
    
  }
  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        let x = this.route.snapshot.paramMap.get('id');
        console.log(x)
        if(x!=null  && x.length>0)
        {
         this.chatId=x;
         console.log(x);
         this.isOpenChat=true;
        }
      }
    });
  }
 
 collaps(e:any)
  {
  this.hovered=!this.hovered;
  e.stopPropagation()
  }
  openChat(x:string)
  {  let url=`navigation/chat/${x}`;

     this.router.navigate([url])
       //this.isOpenChat=true;
    
  }
  logOut()
  {
    localStorage.removeItem('authToken');
    window.location.reload();
  }
  

}
