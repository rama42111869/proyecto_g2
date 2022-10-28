import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Purchase } from '../models/Purchase';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  url = 'http://localhost:8080/middle/purchase';

  constructor(private http : HttpClient) { }

  public getAllCategory():Observable<Purchase[]>{
    return this.http.get<Purchase[]>(this.url+'/carrouselCategory');
  }

  deletePurchase(): Observable<any>{
  return this.http.delete('http://localhost:8080/middle/purchase');
  }


createPurchase(purchase: Purchase): Observable<any>{
  return this.http.post('http://localhost:8080/middle/purchase', purchase);
}

editPurchase(purchase: Purchase): Observable<any>{
  return this.http.put('http://localhost:8080/middle/purchase', purchase);
}


}
