import { TestBed } from '@angular/core/testing';

import { ScannerqrService } from './scannerqr.service';

describe('ScannerqrService', () => {
  let service: ScannerqrService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScannerqrService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
