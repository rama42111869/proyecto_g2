import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantalonhombreComponent } from './pantalonhombre.component';

describe('PantalonhombreComponent', () => {
  let component: PantalonhombreComponent;
  let fixture: ComponentFixture<PantalonhombreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PantalonhombreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PantalonhombreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
