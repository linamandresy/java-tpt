import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SignalementsPageRoutingModule } from './signalements-routing.module';

import { SignalementsPage } from './signalements.page';
import { SignalementsCreationComponent } from 'src/app/components/signalements-creation/signalements-creation.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { SwipableCardComponent } from 'src/app/components/swipable-card/swipable-card.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    SignalementsPageRoutingModule
  ],
  declarations: [
    SignalementsPage,
    SignalementsCreationComponent,
    SwipableCardComponent
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class SignalementsPageModule {}
