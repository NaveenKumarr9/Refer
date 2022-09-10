import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaryslipDetailsComponent } from './salaryslip-details.component';

describe('SalaryslipDetailsComponent', () => {
  let component: SalaryslipDetailsComponent;
  let fixture: ComponentFixture<SalaryslipDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalaryslipDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SalaryslipDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
