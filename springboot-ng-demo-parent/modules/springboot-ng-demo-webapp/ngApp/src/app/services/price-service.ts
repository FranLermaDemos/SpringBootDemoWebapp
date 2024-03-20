import { Injectable } from '@angular/core';
import { Price } from '../model/price-model';

import { Observable } from 'rxjs';
import { ajax, AjaxResponse } from 'rxjs/ajax';

@Injectable({
	providedIn: 'root'
})

export class PricesService {

	constructor() { }

	getPrices(): Observable<AjaxResponse<Price[]>> {
		return ajax('/api/v1/price/findAll');
	}

	sendPrice(price: Price): Observable<AjaxResponse<void>> {
		return ajax({
			url: '/api/v1/price',
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: price
		})
	}
}