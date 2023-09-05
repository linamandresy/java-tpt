import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { DetailActuPageRoutingModule } from './detail-actu-routing.module';

import { DetailActuPage } from './detail-actu.page';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    DetailActuPageRoutingModule
  ],
  declarations: [DetailActuPage],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class DetailActuPageModule {}
