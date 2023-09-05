import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FilDActuPageRoutingModule } from './fil-dactu-routing.module';

import { FilDActuPage } from './fil-dactu.page';
import { CardActuComponent } from 'src/app/components/card-actu/card-actu.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FilDActuPageRoutingModule,
  ],
  declarations: [
    FilDActuPage,
    CardActuComponent
  ]
})
export class FilDActuPageModule {}
