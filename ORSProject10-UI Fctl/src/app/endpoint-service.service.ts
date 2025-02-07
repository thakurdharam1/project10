import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EndpointServiceService {

  constructor() { }

  public SERVER_URL = "http://localhost:8084";
  public MESSAGE = this.SERVER_URL + "/Message";
  public USER = this.SERVER_URL + "/User";
  public ROLE = this.SERVER_URL + "/Role";
  public COLLEGE = this.SERVER_URL + "/College";
  public MARKSHEET = this.SERVER_URL + "/Marksheet";
  public STUDENT = this.SERVER_URL + "/Student";
  public SUBJECT = this.SERVER_URL+ "/Subject";
  public FACULTY = this.SERVER_URL+ "/Faculty";
  public COURSE = this.SERVER_URL + "/Course";
  public TIMETABLE = this.SERVER_URL+ "/TimeTable";
  public JASPERREPORT = this.SERVER_URL+ "/Jasper";

  public ASSET = this.SERVER_URL + "/Asset";
  public CUSTOMER = this.SERVER_URL + "/Customer";
  public EMPLOYEE = this.SERVER_URL+ "/Employee";
  public CART = this.SERVER_URL+ "/Cart";
  public ABC = this.SERVER_URL+ "/Abc";
  public VEHICLE = this.SERVER_URL+ "/Vehicle";
  public XYZ = this.SERVER_URL+ "/Xyz";
  public BANK = this.SERVER_URL+ "/Bank";





}
