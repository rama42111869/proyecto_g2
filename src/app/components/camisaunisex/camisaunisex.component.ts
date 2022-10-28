import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';


@Component({
  selector: 'app-camisaunisex',
  templateUrl: './camisaunisex.component.html',
  styleUrls: ['./camisaunisex.component.css']
})
export class CamisaunisexComponent implements OnInit {

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Camisa").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  

}
