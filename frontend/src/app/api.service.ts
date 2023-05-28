import { Injectable } from '@angular/core';
import { environment } from 'src/enviroment';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApiService {
 baseUrl='';
  constructor(private http : HttpClient) { 
    this.baseUrl=environment.baseUrl;
  }
  verifyEmail(email:string, otp:string){
    let url = this.baseUrl+'/users/verifyEmail/'+email;
    let headers = {
      "content-type": "application/json",
      
    }
    return this.http.post(url,{"otp":otp},{headers:headers});
   }
}
