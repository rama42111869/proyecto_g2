import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuzohombreComponent } from './buzohombre.component';

describe('BuzohombreComponent', () => {
  let component: BuzohombreComponent;
  let fixture: ComponentFixture<BuzohombreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuzohombreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuzohombreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
