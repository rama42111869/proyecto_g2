import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemeraunisexComponent } from './remeraunisex.component';

describe('RemeraunisexComponent', () => {
  let component: RemeraunisexComponent;
  let fixture: ComponentFixture<RemeraunisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemeraunisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemeraunisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
