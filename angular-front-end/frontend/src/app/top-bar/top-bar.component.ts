
import { Component, OnInit } from "@angular/core";
import { CartService } from "../cart.service";
=======
import { Component } from "@angular/core";
import { Data } from "@angular/router";


@Component({
    selector: 'app-top-bar',
    templateUrl: './top-bar.component.html',
    styleUrls: ['./top-bar.component.css']
})

export class TopBarComponent implements OnInit {
    public totalItem : number = 0;
    constructor(private cartService : CartService) { }
    ngOnInit(): void {
        this.cartService.getProduct()
        .subscribe((res: string | any[])=>{
            this.totalItem = res.length;
        })
    }
    
=======
export class TopBarComponent{
    toggleDarkTheme(): void{
        document.body.classList.toggle('dark-theme');
}

dataset = [];

public searchText: Data['items'];

}