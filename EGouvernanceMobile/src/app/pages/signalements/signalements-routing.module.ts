import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignalementsPage } from './signalements.page';
import { SignalementsCreationComponent } from 'src/app/components/signalements-creation/signalements-creation.component';

const routes: Routes = [
  {
    path: '',
    component: SignalementsPage
  }, {
    path: 'new',
    component: SignalementsCreationComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SignalementsPageRoutingModule { }
