import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { RxwebValidators } from '@rxweb/reactive-form-validators';
import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';
registerLocaleData(localeEs);

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { PriceListComponent } from './views/price-list/price-list.component';
import { PriceRegisterComponent } from './views/price-register/price-register.component';



@NgModule({
  declarations: [
    AppComponent,
    PriceListComponent,
    PriceRegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
  {
    provide: LOCALE_ID,
    useValue: 'es-ES',
  },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
