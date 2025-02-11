import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-asset',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.CUSTOMER, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.firstName);
    flag = flag && validator.isNotNullObject(form.location);
    flag = flag && validator.isNotNullObject(form.number);
    flag = flag && validator.isNotNullObject(form.importance);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.firstName = data.firstName;
    form.location = data.location;
    form.number = data.number;
    form.importance = data.importance;
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