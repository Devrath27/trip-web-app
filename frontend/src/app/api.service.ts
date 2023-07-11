import { Injectable } from '@angular/core';
import { environment } from 'src/enviroment';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  logedIn$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  myname='parveen'
 baseUrl='';
  constructor(private http : HttpClient) { 
    this.baseUrl=environment.baseUrl;
  }
  headers = {
    "content-type": "application/json",
    
  }
  verifyEmail(email:string, otp:string){
    let url = this.baseUrl+'/users/verifyEmail/'+email;
   
    return this.http.post(url,{"otp":otp},{headers:this.headers});
   }

   signUp(formDetails:any):Observable<{token:string}>
   {
     let url = this.baseUrl+'/users/register';
     let body={
      "name" : formDetails.firstName+' '+formDetails.lastName,
      "email" : formDetails.email,
      "password" : formDetails.password,
      "profileImage" : "",
      "mobileNumber" :0
         }
         return this.http.post<{token:string}>(url,body,{headers:this.headers});
   }

   login(formDetails:any)
   {
     let url = this.baseUrl+'/users/login';
     let  body={
      "email":formDetails.email,
      "password":formDetails.password
     }
    return this.http.post<{token:string}>(url,body,{headers:this.headers});
   }
}
