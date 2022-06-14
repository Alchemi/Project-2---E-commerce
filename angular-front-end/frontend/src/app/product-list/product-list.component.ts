import { Component } from '@angular/core';
import { products } from '../products';
import { products2 } from '../products2';
import{ products3} from '../products3';

@Component({
    selector: 'app-product-list',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
    products = products;
    products2 = products2;
    products3= products3;

    share() {
        window.alert('This product has been shared!');
    }
}












// product alerts. how and would we like to do that?? things dont go here, this is just my thinks


