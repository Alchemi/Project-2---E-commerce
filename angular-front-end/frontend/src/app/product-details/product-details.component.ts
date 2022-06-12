import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Product, products } from '../products';

@Component({
    selector: 'app-product-details',
    templateUrl: './product-details.component.html',
    styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

    product: Product | undefined;
    
    constructor(private route: ActivatedRoute) { }
    ngOnInit(): void {
    //get the product id from the current route
    const routeParams = this.route.snapshot.paramMap;
    const productIdFromRoute = Number(routeParams.get('productId'));

    //find the product that correspond w the id that is in the route
    this.product = products.find(product => product.Id === productIdFromRoute);
    }
}
