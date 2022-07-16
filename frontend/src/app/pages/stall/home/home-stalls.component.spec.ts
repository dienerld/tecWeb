import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeStallsComponent } from './home-stalls.component';

describe('HomeStallsComponent', () => {
  let component: HomeStallsComponent;
  let fixture: ComponentFixture<HomeStallsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeStallsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeStallsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
