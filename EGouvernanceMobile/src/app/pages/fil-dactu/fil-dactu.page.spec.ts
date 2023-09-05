import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FilDActuPage } from './fil-dactu.page';

describe('FilDActuPage', () => {
  let component: FilDActuPage;
  let fixture: ComponentFixture<FilDActuPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(FilDActuPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
