import { Component, OnInit } from '@angular/core';

import { PricesService } from "../../services/price-service";
import { Price } from '../../model/price-model';

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.css']
})
export class PriceListComponent implements OnInit {

	prices : Price[] = [];
	
	constructor(private pricesService:PricesService) {}
	
	ngOnInit() {
		var me = this;
		this.pricesService.getPrices().subscribe(
			(res) => { me.prices = res.response; },
			(error: any) => { console.error(error)});
	}
		
}
