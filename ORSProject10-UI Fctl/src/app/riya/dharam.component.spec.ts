import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DharamComponent } from './dharam.component';

describe('DharamComponent', () => {
  let component: DharamComponent;
  let fixture: ComponentFixture<DharamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DharamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DharamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
