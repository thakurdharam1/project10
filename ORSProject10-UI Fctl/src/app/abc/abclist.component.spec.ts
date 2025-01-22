import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbclistComponent } from './abclist.component';

describe('AbclistComponent', () => {
  let component: AbclistComponent;
  let fixture: ComponentFixture<AbclistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbclistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbclistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
