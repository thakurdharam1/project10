import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { XyzlistComponent } from './xyzlist.component';

describe('XyzlistComponent', () => {
  let component: XyzlistComponent;
  let fixture: ComponentFixture<XyzlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ XyzlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(XyzlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
