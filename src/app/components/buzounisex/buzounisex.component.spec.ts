import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuzounisexComponent } from './buzounisex.component';

describe('BuzounisexComponent', () => {
  let component: BuzounisexComponent;
  let fixture: ComponentFixture<BuzounisexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuzounisexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuzounisexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
