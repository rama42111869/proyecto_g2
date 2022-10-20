import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemeraninioComponent } from './remeraninio.component';

describe('RemeraninioComponent', () => {
  let component: RemeraninioComponent;
  let fixture: ComponentFixture<RemeraninioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemeraninioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemeraninioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
