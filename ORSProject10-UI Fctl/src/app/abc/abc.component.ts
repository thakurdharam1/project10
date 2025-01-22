import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-asset',
  templateUrl: './abc.component.html',
  styleUrls: ['./abc.component.css']
})
export class AbcComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.ABC, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.dateOfBirth);
    flag = flag && validator.isNotNullObject(form.lastName);
    flag = flag && validator.isNotNullObject(form.Branch);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.dateOfBirth = data.dateOfBirth;
    form.lastName = data.lastName;
    form.Branch = data.Branch;
  }
}