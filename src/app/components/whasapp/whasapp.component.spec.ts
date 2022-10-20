import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WhasappComponent } from './whasapp.component';

describe('WhasappComponent', () => {
  let component: WhasappComponent;
  let fixture: ComponentFixture<WhasappComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WhasappComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WhasappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
