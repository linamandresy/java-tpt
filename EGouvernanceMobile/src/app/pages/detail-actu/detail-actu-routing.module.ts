import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DetailActuPage } from './detail-actu.page';

const routes: Routes = [
  {
    path: '',
    component: DetailActuPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DetailActuPageRoutingModule {}
