import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-menumain',
  templateUrl: './menumain.component.html',
  styleUrls: ['./menumain.component.css']
})
export class MenumainComponent implements OnInit {

  constructor(    private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }
  onClick() {
    this.userService.logout()
      .then(() => {
        this.router.navigate(['/inicio']);
      })
      .catch(error => console.log(error));
  }

}
