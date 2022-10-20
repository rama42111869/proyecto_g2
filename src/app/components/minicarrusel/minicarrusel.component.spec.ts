import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MinicarruselComponent } from './minicarrusel.component';

describe('MinicarruselComponent', () => {
  let component: MinicarruselComponent;
  let fixture: ComponentFixture<MinicarruselComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MinicarruselComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MinicarruselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
