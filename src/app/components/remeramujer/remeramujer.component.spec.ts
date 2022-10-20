import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemeramujerComponent } from './remeramujer.component';

describe('RemeramujerComponent', () => {
  let component: RemeramujerComponent;
  let fixture: ComponentFixture<RemeramujerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemeramujerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemeramujerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
