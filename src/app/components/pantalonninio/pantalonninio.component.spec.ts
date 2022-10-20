import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantalonninioComponent } from './pantalonninio.component';

describe('PantalonninioComponent', () => {
  let component: PantalonninioComponent;
  let fixture: ComponentFixture<PantalonninioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PantalonninioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PantalonninioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
