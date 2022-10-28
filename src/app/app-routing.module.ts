import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { canActivate, redirectUnauthorizedTo } from '@angular/fire/auth-guard';
import { InicioComponent } from './components/inicio/inicio.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AsComponent } from './components/as/as.component';

///Unisex-components
import { RemeraunisexComponent } from './components/remeraunisex/remeraunisex.component';
import { BuzounisexComponent } from './components/buzounisex/buzounisex.component';
import { JeanunisexComponent } from './components/jeanunisex/jeanunisex.component';
import { CamisaunisexComponent } from './components/camisaunisex/camisaunisex.component';
import { CamperaunisexComponent } from './components/camperaunisex/camperaunisex.component';
import { ChombaunisexComponent } from './components/chombaunisex/chombaunisex.component';
import { JogginunisexComponent } from './components/jogginunisex/jogginunisex.component';
import { BermudaunisexComponent } from './components/bermudaunisex/bermudaunisex.component';
import { TodosComponent } from './components/todos/todos.component';

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
  ///Unisex-components
  {path: 'remeraunisex',component: RemeraunisexComponent},
  {path: 'buzounisex',component: BuzounisexComponent},
  {path: 'jeanunisex',component: JeanunisexComponent},
  {path: 'camisaunisex',component: CamisaunisexComponent},
  {path: 'camperaunisex',component: CamperaunisexComponent},
  {path: 'chombaunisex',component: ChombaunisexComponent},
  {path: 'jogginunisex',component: JogginunisexComponent},
  {path: 'bermudaunisex',component: BermudaunisexComponent},
  {path: 'todos',component: TodosComponent},

  {path: 'as',component: AsComponent},
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
