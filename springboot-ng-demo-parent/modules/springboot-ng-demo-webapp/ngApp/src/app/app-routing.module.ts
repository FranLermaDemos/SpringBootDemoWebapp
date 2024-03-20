import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {PriceListComponent} from './views/price-list/price-list.component';
import {PriceRegisterComponent} from './views/price-register/price-register.component';


const routes: Routes = [
	{ path: '', redirectTo: '/price-list', pathMatch: 'full' },
	{ path: 'price-list', component: PriceListComponent },
	{ path: 'price-register', component: PriceRegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
