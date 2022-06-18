import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { products } from '../products';


@Injectable({
  providedIn: 'root'
})
export class Product {

  constructor() { }


  getProduct(type: string): Observable<Product> {
    const product = products.find(p => p.type === type)!; 
    return of(product);
}
}
