import { Component, OnInit } from "@angular/core";
import { CartService } from "../cart.service";

@Component({
    selector: 'app-top-bar',
    templateUrl: './top-bar.component.html',
    styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {
    public totalItem : number = 0;
    constructor(private cartService : CartService) { }
    ngOnInit(): void {
        this.cartService.getProducts()
        .subscribe(res=>{
            this.totalItem = res.length;
        })
    }
    
}