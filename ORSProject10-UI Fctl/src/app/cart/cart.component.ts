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
  filterInput(event: KeyboardEvent, errorMessageField: string, maxLength: number, type: string) {
    const inputChar = event.key;
    const target = event.target as HTMLInputElement;
  
    let pattern;
    if (type === 'char') {
      // Allow only letters and space
      pattern = /^[a-zA-Z\s]*$/;
      if (!pattern.test(inputChar) && event.key !== 'Backspace') {
        event.preventDefault();
        this[errorMessageField] = 'Only letters are allowed!';
        return;
      }
    } else if (type === 'int') {
      // Allow only numbers
      pattern = /^[0-9]*$/;
      if (!pattern.test(inputChar) && event.key !== 'Backspace') {
        event.preventDefault();
        this[errorMessageField] = 'Only numbers are allowed!';
        return;
      }
    }
  
    // Enforce max length
    if (target.value.length >= maxLength && event.key !== 'Backspace') {
      event.preventDefault();
      this[errorMessageField] = `Maximum ${maxLength} characters allowed!`;
    } else {
      this[errorMessageField] = ''; // Clear error message
    }
  }
  
  
  
}