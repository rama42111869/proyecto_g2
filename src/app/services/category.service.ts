import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url = 'http://localhost:8081/middle/category';

  constructor(private http : HttpClient) { }

  public getAllCategory():Observable<Category[]>{
    return this.http.get<Category[]>(this.url);
  }

  public getByName(name:string):Observable<Category []>{
    return this.http.get<Category []>('http://localhost:8081/middle/category'+'/'+name);
}

  deleteCategory(): Observable<any>{
  return this.http.delete('http://localhost:8081/middle/category');
  }


createCategory(category: Category): Observable<any>{
  return this.http.post('http://localhost:8081/middle/category', category);
}

editCategory(category: Category): Observable<any>{
  return this.http.put('http://localhost:8081/middle/category', category);
}

}
