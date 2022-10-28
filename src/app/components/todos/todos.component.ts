import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/Product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit {
  name!: String;
  search=new FormControl('');

  productos:Product[]=[];
  constructor(private ServiceP: ProductService, private router: Router,
   ){
  }

  ngOnInit(): void {
    this.ServiceP.getAllProducts().subscribe(data=>{
      console.log(data);
      this.productos=data;
    })
  }  

  onSearch(){
    console.log(this.name);
    this.ServiceP.findProduct(this.name).subscribe(data => 
      {console.log("se busco bien");
      this.productos = data;
      
  })
}
  
  

}
