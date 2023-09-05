import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FilDActuPage } from './fil-dactu.page';

const routes: Routes = [
  {
    path: '',
    component: FilDActuPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FilDActuPageRoutingModule {}
