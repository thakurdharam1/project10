import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-asset',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.EMPLOYEE, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.dateOfJoining);
    flag = flag && validator.isNotNullObject(form.lastName);
    flag = flag && validator.isNotNullObject(form.department);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.dateOfJoining = data.dateOfJoining;
    form.lastName = data.lastName;
    form.department = data.department;
  }
}