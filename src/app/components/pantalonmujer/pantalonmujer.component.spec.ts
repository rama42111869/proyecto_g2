import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantalonmujerComponent } from './pantalonmujer.component';

describe('PantalonmujerComponent', () => {
  let component: PantalonmujerComponent;
  let fixture: ComponentFixture<PantalonmujerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PantalonmujerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PantalonmujerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
