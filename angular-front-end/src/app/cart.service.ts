import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from './products';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public items : any=[]
  public product = new BehaviorSubject<any>([]);
 
  constructor() { }
  getItems(){
    return this.items.asObservable();
  }
  addToCart(product: any) {
  this.items.push(product);
  this.items.next(this.items);
  this.getTotalPrice();
}
getTotalPrice(){
  let grandTotal = 0;
  this.items.map((a:any)=>{
    grandTotal += a.total;

  })
}
removeCartItem(product: any){
  this.items.map((a:any, index:any)=>{
    if(product.id===a.id){
      this.items.splice(index, 1);

    }
  })
}
removeAllCart(){
  this.items = []
  this.product.next(this.items);
}
}




//addToCart(product: Product) {
  //this.items.push(product);
//}
//getItems() {
  //return this.items;
//}
//clearCart() {
  //this.items = [];
  //return this.items;
//}