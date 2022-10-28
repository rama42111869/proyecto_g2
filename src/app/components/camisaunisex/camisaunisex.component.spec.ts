import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CamisaunisexComponent } from './camisaunisex.component';

describe('CamisaunisexComponent', () => {
  let component: CamisaunisexComponent;
  let fixture: ComponentFixture<CamisaunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CamisaunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CamisaunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
