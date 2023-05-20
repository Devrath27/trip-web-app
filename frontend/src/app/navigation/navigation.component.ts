import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, Route, Router } from '@angular/router';

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
  constructor(private router: Router,private route: ActivatedRoute){
    
  }
  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        let x = this.route.snapshot.paramMap.get('id');
        if(x!=null  && x.length>0)
        {
         this.chatId=x;
         console.log(x);
         this.isOpenChat=true;
        }
      }
    });
  }
 collaps(e:any,t:boolean)
  {
  this.hovered=t;
  e.stopPropagation()
  }
  openChat(x:string)
  {  let url=`navigation/chat/${x}`;
     this.router.navigate([url])
     this.isOpenChat=true;
  }
  

}
