import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-asset',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.CART, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.customerName);
    flag = flag && validator.isNotNullObject(form.dateOfTransction);
    flag = flag && validator.isNotNullObject(form.quantity);
    flag = flag && validator.isNotNullObject(form.product);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.customerName = data.customerName;
    form.dateOfTransction = data.dateOfTransction;
    form.quantity = data.quantity;
    form.product = data.product;
  }
}