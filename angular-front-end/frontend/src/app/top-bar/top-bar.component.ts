import { Component } from "@angular/core";
import { Data } from "@angular/router";

@Component({
    selector: 'app-top-bar',
    templateUrl: './top-bar.component.html',
    styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent{
    toggleDarkTheme(): void{
        document.body.classList.toggle('dark-theme');
}

dataset = [];

public searchText: Data['items'];
}