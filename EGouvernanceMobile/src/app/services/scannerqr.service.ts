import { Injectable } from '@angular/core';
import { Barcode, BarcodeScanner } from '@capacitor-mlkit/barcode-scanning';

@Injectable({
  providedIn: 'root'
})
export class ScannerqrService {

  constructor() { }

  async scan(){
    let data = await BarcodeScanner.scan();
    return data.barcodes[0].displayValue;
  }

}
