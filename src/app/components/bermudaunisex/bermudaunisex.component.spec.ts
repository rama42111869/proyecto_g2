import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BermudaunisexComponent } from './bermudaunisex.component';

describe('BermudaunisexComponent', () => {
  let component: BermudaunisexComponent;
  let fixture: ComponentFixture<BermudaunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BermudaunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BermudaunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
