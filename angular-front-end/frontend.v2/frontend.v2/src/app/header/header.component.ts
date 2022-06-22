import { Component, OnInit } from '@angular/core';
import { Product, products } from '../product';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  toggleDarkTheme(): void{
    document.body.classList.toggle('dark-theme');
}

dataset = [products];


}
