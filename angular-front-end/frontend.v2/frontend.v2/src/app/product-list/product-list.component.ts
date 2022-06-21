import { Component } from '@angular/core';
import { Product, products } from '../product';


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



