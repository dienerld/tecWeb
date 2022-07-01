import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStallComponent } from './add-stall.component';

describe('AddStallComponent', () => {
  let component: AddStallComponent;
  let fixture: ComponentFixture<AddStallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStallComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddStallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
