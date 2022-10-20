import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { canActivate, redirectUnauthorizedTo } from '@angular/fire/auth-guard';
import { InicioComponent } from './components/inicio/inicio.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BuzohombreComponent } from './components/buzohombre/buzohombre.component';
import { BuzomujerComponent } from './components/buzomujer/buzomujer.component';
import { BuzoninioComponent } from './components/buzoninio/buzoninio.component';
import { RemerahombreComponent } from './components/remerahombre/remerahombre.component';
import { RemeramujerComponent } from './components/remeramujer/remeramujer.component';
import { RemeraninioComponent } from './components/remeraninio/remeraninio.component';
import { PantalonhombreComponent } from './components/pantalonhombre/pantalonhombre.component';
import { PantalonninioComponent } from './components/pantalonninio/pantalonninio.component';
import { PantalonmujerComponent } from './components/pantalonmujer/pantalonmujer.component';
import { AsComponent } from './components/as/as.component';
const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/inicio' },
  {
    path: 'main',
    component: MainComponent,
    ...canActivate(() => redirectUnauthorizedTo(['/inicio']))
  },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  {path: 'inicio',component: InicioComponent},
  {path: 'buzohombre',component: BuzohombreComponent},
  {path: 'buzomujer',component: BuzomujerComponent},
  {path: 'buzoninio',component: BuzoninioComponent},
  {path: 'remerahombre',component: RemerahombreComponent},
  {path: 'remeramujer',component: RemeramujerComponent},
  {path: 'remeraninio',component: RemeraninioComponent},
  {path: 'pantalonhombre',component: PantalonhombreComponent},
  {path: 'pantalonninio',component: PantalonninioComponent},
  {path: 'pantalonmujer',component: PantalonmujerComponent},
  {path: 'as',component: AsComponent},
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
