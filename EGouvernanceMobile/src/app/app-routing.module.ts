import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guard/auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'fil-dactu',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'fil-dactu',
    loadChildren: () => import('./pages/fil-dactu/fil-dactu.module').then( m => m.FilDActuPageModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'detail-actu/:id',
    loadChildren: () => import('./pages/detail-actu/detail-actu.module').then( m => m.DetailActuPageModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'signalements',
    loadChildren: () => import('./pages/signalements/signalements.module').then( m => m.SignalementsPageModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'votes',
    loadChildren: () => import('./pages/votes/votes.module').then( m => m.VotesPageModule),
    canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
