import { Component, OnInit, } from '@angular/core';
import { products } from '../products';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
//implements OnInit {

  products = [...products];

  share() {
    window.alert('the product has been shared');
  }

  onNotify() {
    window.alert("say less");
  }
}
  //constructor() { }

  //ngOnInit(): void {
  //}

//}

