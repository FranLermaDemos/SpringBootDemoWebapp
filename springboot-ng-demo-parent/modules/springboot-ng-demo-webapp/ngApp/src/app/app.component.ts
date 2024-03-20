import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Demo Precios';
  
  constructor(private router: Router) { }
  
  goToPriceRegister() : void {
	this.router.navigateByUrl('/price-register');
  }
  
  goToPricesList() : void {
	this.router.navigateByUrl('/price-list');
  }
}
