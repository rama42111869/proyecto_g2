import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenumainComponent } from './menumain.component';

describe('MenumainComponent', () => {
  let component: MenumainComponent;
  let fixture: ComponentFixture<MenumainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenumainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenumainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
