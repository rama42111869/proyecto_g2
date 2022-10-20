import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

@Injectable({
    providedIn: 'root'
  })
  
export class ProductService {
   url = 'https://localhost:8081/middle/products';

    constructor(private http : HttpClient) { }

    public getAllProducts():Observable<Product[]>{
        return this.http.get<Product[]>(this.url+'/carrouselProducts');
      }
}