import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemerahombreComponent } from './remerahombre.component';

describe('RemerahombreComponent', () => {
  let component: RemerahombreComponent;
  let fixture: ComponentFixture<RemerahombreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemerahombreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemerahombreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
