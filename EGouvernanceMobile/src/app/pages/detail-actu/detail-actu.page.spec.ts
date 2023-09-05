import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DetailActuPage } from './detail-actu.page';

describe('DetailActuPage', () => {
  let component: DetailActuPage;
  let fixture: ComponentFixture<DetailActuPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(DetailActuPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
