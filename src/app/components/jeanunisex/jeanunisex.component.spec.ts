import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JeanunisexComponent } from './jeanunisex.component';

describe('JeanunisexComponent', () => {
  let component: JeanunisexComponent;
  let fixture: ComponentFixture<JeanunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JeanunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JeanunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
