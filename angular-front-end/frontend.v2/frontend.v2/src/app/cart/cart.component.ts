import { Component, OnInit } from "@angular/core";
import { CartService } from "../service/cart.service";
import { FormBuilder } from "@angular/forms";

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
public products : any = [];
public grandTotal !: number;
purchase(){
    console.warn('Congratulations! Please check your email for purchase confirmation!')
}
//this might be stupid delete comma in component and lines15-17 and 21  if needed
checkoutForm = this.formBuilder.group({
    name: "",
    address: "",
    email:""
    
})

constructor(private cartService : CartService,
    private formBuilder: FormBuilder
    ) {}

    ngOnInit(): void{
        this.cartService.getProducts()
        .subscribe(res=>{
            this.products = res;
            this.grandTotal = this.cartService.getTotalPrice();
        })
    }     
    removeItem(item: any){
        this.cartService.removeCartItem(item);
        
    }
    emptycart(){
        this.cartService.removeAllCart();
    }
    
//this also might be stupid 39-44
onSubmit(): void{
    this.products = this.cartService.removeAllCart();
    console.warn('Your order has been submitted', this.checkoutForm.value);
    this.checkoutForm.reset();

}
}
