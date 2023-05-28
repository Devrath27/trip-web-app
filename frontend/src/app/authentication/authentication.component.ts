import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements  OnInit {
  type=false;
  isAll=false;
  errorMsg='all fields are required!!!!';
  msg='';
  isOtp=false;
  curretOtp='';
  popUpType=false;
  constructor(private apiService:ApiService)
  {

  }
  ngOnInit() {
   
  }

  loginForm = new FormGroup({
    email:new FormControl(null, [Validators.required,Validators.minLength(5)]),
    password: new FormControl(null, [Validators.required,Validators.minLength(8)])
  });

  signUpForm = new FormGroup({
    firstName:new FormControl(null, [Validators.required,Validators.minLength(1)]),
    lastName: new FormControl(null, [Validators.required,Validators.minLength(1)]),
    email:new FormControl(null, [Validators.required,Validators.minLength(5)]),
    password: new FormControl(null, [Validators.required,Validators.minLength(8)])
  });

  generateOTP(): string {
    const digits = '0123456789';
    let otp = '';

    
    for (let i = 0; i < 6; i++) {
      otp += digits[Math.floor(Math.random() * digits.length)];
    }
    
    return otp;
  }
 
  
  

  loginUser(){
    if(this.signUpForm.invalid){
      this.isAll=true;
      return;
    }

  }
  sendOtp()
  {  if(this.signUpForm.controls.email.invalid){
     this.msg='Please enter a valid email address!!!'
     this.popUpType=true;
    }
    else{
      let otp=this.generateOTP();
      this.curretOtp=otp;
      console.log(otp)
      this.apiService.verifyEmail(this.signUpForm.value.email?this.signUpForm.value.email:'',this.curretOtp).subscribe((d)=>{
      console.log(d)
      },(e)=>{
        console.log(e);
      })
      this.msg=`Otp has been send you to your email ${this.signUpForm.value.email}`
      this.popUpType=false;

    }
    this.isOtp=true;
    setTimeout(()=>{
      this.isOtp=false;
      this.msg='';
    },2000)
  }
   change(n:boolean)
   {
    this.isAll=false;
   }
  signUpUser(x:string){
    if(x!=this.curretOtp){
      this.isOtp=true;
      this.msg='Your OTP is incorrect! '
      this.popUpType=true;
      setTimeout(()=>{
        this.isOtp=false;
        this.msg='';
      },2000)
      return;
    }
    if(this.signUpForm.invalid){
      this.isOtp=true;
      this.msg='all fields are required!!!'
      this.popUpType=true;
      return;

    }
  }


}
