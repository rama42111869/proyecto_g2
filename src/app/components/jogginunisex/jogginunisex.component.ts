import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
@Component({
  selector: 'app-jogginunisex',
  templateUrl: './jogginunisex.component.html',
  styleUrls: ['./jogginunisex.component.css']
})
export class JogginunisexComponent implements OnInit {

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getByNameBuzo("Joggin").subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  
}
