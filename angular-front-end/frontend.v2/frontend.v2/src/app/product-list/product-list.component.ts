import { Component, OnInit } from '@angular/core';
import { Product, products } from '../product';
import { ApiService } from '../service/api.service';


@Component({
    selector: 'app-product-list',
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

    public productList : any ;
    constructor(private api : ApiService) {}
   
    ngOnInit(): void {
        this.api.getProduct()
        .subscribe(res=>{
            this.productList = res;
        })
    
    }


    share() {
        window.alert('This product has been shared!');
    }
}



