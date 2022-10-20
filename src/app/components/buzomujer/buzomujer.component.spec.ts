import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuzomujerComponent } from './buzomujer.component';

describe('BuzomujerComponent', () => {
  let component: BuzomujerComponent;
  let fixture: ComponentFixture<BuzomujerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuzomujerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuzomujerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
