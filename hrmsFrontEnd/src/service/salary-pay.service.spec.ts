import { TestBed } from '@angular/core/testing';

import { SalaryPayService } from './salary-pay.service';

describe('SalaryPayService', () => {
  let service: SalaryPayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalaryPayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
