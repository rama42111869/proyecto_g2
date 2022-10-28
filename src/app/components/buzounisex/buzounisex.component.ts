import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-buzounisex',
  templateUrl: './buzounisex.component.html',
  styleUrls: ['./buzounisex.component.css']
})
export class BuzounisexComponent implements OnInit {
  
  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Buzo").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  
  

}
