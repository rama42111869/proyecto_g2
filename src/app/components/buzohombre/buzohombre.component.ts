import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-buzohombre',
  templateUrl: './buzohombre.component.html',
  styleUrls: ['./buzohombre.component.css']
})
export class BuzohombreComponent implements OnInit {

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router){

  }
  ngOnInit(): void {
    this.getP();
  }

  getP():void{
    this.ServiceP.getAllProducts()
    .subscribe(data=>{
      this.productos=data;
    }); 
  }

}
