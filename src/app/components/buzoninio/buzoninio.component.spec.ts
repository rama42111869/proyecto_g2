import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuzoninioComponent } from './buzoninio.component';

describe('BuzoninioComponent', () => {
  let component: BuzoninioComponent;
  let fixture: ComponentFixture<BuzoninioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuzoninioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuzoninioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
