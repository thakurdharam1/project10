import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-asset',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.VEHICLE, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.ownerName);
    flag = flag && validator.isNotNullObject(form.dateOfRegistration);
    flag = flag && validator.isNotNullObject(form.number);
    flag = flag && validator.isNotNullObject(form.type);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.ownerName = data.ownerName;
    form.dateOfRegistration = data.dateOfRegistration;
    form.number = data.number;
    form.type = data.type;
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