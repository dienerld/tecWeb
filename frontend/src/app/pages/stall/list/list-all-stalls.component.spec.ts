import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllStallsComponent } from './list-all-stalls.component';

describe('ListAllStallsComponent', () => {
  let component: ListAllStallsComponent;
  let fixture: ComponentFixture<ListAllStallsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAllStallsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListAllStallsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
