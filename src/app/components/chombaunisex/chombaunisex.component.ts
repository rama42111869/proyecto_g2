import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
@Component({
  selector: 'app-chombaunisex',
  templateUrl: './chombaunisex.component.html',
  styleUrls: ['./chombaunisex.component.css']
})
export class ChombaunisexComponent implements OnInit {

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Chomba").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  

}
