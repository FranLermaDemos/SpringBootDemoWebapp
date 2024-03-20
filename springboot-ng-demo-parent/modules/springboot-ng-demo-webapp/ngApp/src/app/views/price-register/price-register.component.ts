import { Component } from '@angular/core';
import { AbstractControl, Validators, FormGroup, FormBuilder, ValidationErrors } from '@angular/forms';
import { PricesService } from "../../services/price-service";


function validateDecimal(control: AbstractControl): { [key: string]: boolean } | null {
  if (control.value && !/^\d+(\.\d{2})?$/.test(control.value)) {
    return { 'invalidDecimal': true };
  }
  return null;
}


@Component({
	selector: 'app-product-register',
	templateUrl: './price-register.component.html',
	styleUrls: ['./price-register.component.css']
})

export class PriceRegisterComponent {

	priceSubmitForm: FormGroup;
	serviceError? : string = undefined;

	constructor(
		private pricesService: PricesService,
		private formBuilder: FormBuilder
	) {
		this.priceSubmitForm = this.formBuilder.group({
			productId: ['', [ Validators.required, Validators.min(10000), Validators.max(999999999) ] ],
			brandId: ['', Validators.required],
			priority: ['', [ Validators.required, Validators.min(0), Validators.max(9) ] ],
			startDate: ['', Validators.required ],
			endDate: ['', [ Validators.required ] ],
			price: ['', [ Validators.required, validateDecimal ] ],
			currencyISO : 'EUR'
		});
	}

	onSubmitPrice() {
		if (this.priceSubmitForm.valid) {
			this.priceSubmitForm.get('currencyISO')?.patchValue('EUR');
			this.pricesService.sendPrice(this.priceSubmitForm.value)
				.subscribe({
					next: (response) => {
						this.serviceError=undefined;
						console.log('¡Precio dado de alta!', response);
						this.priceSubmitForm.reset();
						
					},
					error: (error) => {
						console.error('Error al dar de alta el precio:', error);
						this.serviceError=error.response.message
					}
				});
		} else {
			console.error("Datos no validos");
		}

	}


}
