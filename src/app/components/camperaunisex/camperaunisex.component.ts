import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';

@Component({
  selector: 'app-camperaunisex',
  templateUrl: './camperaunisex.component.html',
  styleUrls: ['./camperaunisex.component.css']
})
export class CamperaunisexComponent implements OnInit {

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Campera").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  
}
