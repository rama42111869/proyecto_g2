import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JogginunisexComponent } from './jogginunisex.component';

describe('JogginunisexComponent', () => {
  let component: JogginunisexComponent;
  let fixture: ComponentFixture<JogginunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JogginunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JogginunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
