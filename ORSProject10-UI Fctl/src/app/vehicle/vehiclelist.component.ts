import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-assetlist',
  templateUrl: './vehiclelist.component.html',
  styleUrls: ['./vehiclelist.component.css']
})
export class VehiclelistComponent extends BaseListCtl implements OnInit {
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
    super(locator.endpoints.VEHICLE, locator, route);
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