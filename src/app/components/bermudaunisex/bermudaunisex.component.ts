import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-bermudaunisex',
  templateUrl: './bermudaunisex.component.html',
  styleUrls: ['./bermudaunisex.component.css']
})
export class BermudaunisexComponent implements OnInit {

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Bermuda").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  

}
