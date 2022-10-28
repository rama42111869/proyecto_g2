import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
@Component({
  selector: 'app-remeraunisex',
  templateUrl: './remeraunisex.component.html',
  styleUrls: ['./remeraunisex.component.css']
})
export class RemeraunisexComponent implements OnInit {
 
  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Remera").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  
}
