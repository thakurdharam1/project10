import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RiyaComponent } from './riya.component';

describe('RiyaComponent', () => {
  let component: RiyaComponent;
  let fixture: ComponentFixture<RiyaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RiyaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RiyaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
