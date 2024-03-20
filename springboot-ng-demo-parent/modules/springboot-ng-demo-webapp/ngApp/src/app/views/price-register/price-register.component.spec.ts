import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriceRegisterComponent } from './price-register.component';

describe('PriceRegisterComponent', () => {
  let component: PriceRegisterComponent;
  let fixture: ComponentFixture<PriceRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriceRegisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PriceRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
