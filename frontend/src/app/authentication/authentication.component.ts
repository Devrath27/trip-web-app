import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements  OnInit {
  type=false;
  constructor()
  {

  }
  ngOnInit(): void {
   
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

  loginUser(){

  }

  signUpUser(){

  }


}
