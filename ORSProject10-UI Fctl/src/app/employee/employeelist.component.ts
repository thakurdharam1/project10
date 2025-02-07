import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-assetlist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent extends BaseListCtl implements OnInit {
  myKey = "";

  public form = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: {},
    searchMessage: null,
    list: [],
    pageNo: 0
  };

  base64Data: any;
  retrieveResonse: any;
  message: string;

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.EMPLOYEE, locator, route);
  }
  filterInput(event: KeyboardEvent, errorMessageField: string, maxLength: number, allowedType: string) {
    const pattern = /^[a-zA-Z\s]*$/; 
    const inputChar = event.key;
  
    
    if (!pattern.test(inputChar) && event.key !== 'Backspace') {
      event.preventDefault(); 
      this[errorMessageField] = 'Only letters are allowed!'; 
      return;
    }
  
   
    const target = event.target as HTMLInputElement;
    if (target.value.length >= maxLength && event.key !== 'Backspace') {
      event.preventDefault(); 
      this[errorMessageField] = `Only ${maxLength} characters are allowed!`; 
    } else {
      this[errorMessageField] = ''; 
    }
  }
}