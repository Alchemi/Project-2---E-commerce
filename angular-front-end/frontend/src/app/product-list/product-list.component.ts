import { Component } from '@angular/core';
import { Product, products } from '../models/products';


@Component({
    selector: 'app-product-list',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

    Product = products;
   


    share() {
        window.alert('This product has been shared!');
    }
}












// product alerts. how and would we like to do that?? things dont go here, this is just my thinks


