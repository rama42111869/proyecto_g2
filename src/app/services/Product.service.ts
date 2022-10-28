import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { Category } from '../models/Category';

@Injectable({
    providedIn: 'root'
  })
  
export class ProductService {
    Product!: Product;

   url = 'http://localhost:8081/middle/products';
    constructor(private http : HttpClient) { }

    public getAllProducts():Observable<Product[]>{
        return this.http.get<Product[]>(this.url);
    }

    deleteProduct(): Observable<any>{
      return this.http.delete('http://localhost:8081/middle/products');
    }

    createProduct(producto: Product): Observable<any>{
      return this.http.post('http://localhost:8081/middle/products', producto);
    }

    editProduct(producto: Product): Observable<any>{
      return this.http.put('http://localhost:8081/middle/products', producto);
    }

    public getByNameBuzo(name:string):Observable<Product []>{
      return this.http.get<Product []>('http://localhost:8081/middle/products/category'+'/'+name);
  }


  public findProduct(name:String):Observable<Product[]>{
    return this.http.get<Product[]>(this.url+"/search/"+name);
  }

}