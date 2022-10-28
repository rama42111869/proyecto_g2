import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChombaunisexComponent } from './chombaunisex.component';

describe('ChombaunisexComponent', () => {
  let component: ChombaunisexComponent;
  let fixture: ComponentFixture<ChombaunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChombaunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChombaunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
