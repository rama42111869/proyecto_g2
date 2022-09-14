import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent implements OnInit {
  array:any=[
    {
    id: 0,
    class: "myButton",
    name: "Log in"
  },
  {
    id: 1,
    class: "myButton",
    name: "Sign in"
  }
  ]



  contentDropdown:boolean = false;
  dropdownOpen(){
    this.contentDropdown = !this.contentDropdown;
  }

  constructor() {}

  ngOnInit(): void {
  }



}
