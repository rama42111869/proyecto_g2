import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CamperaunisexComponent } from './camperaunisex.component';

describe('CamperaunisexComponent', () => {
  let component: CamperaunisexComponent;
  let fixture: ComponentFixture<CamperaunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CamperaunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CamperaunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
