import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { initializeApp,provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { provideAuth,getAuth } from '@angular/fire/auth';
import { InicioComponent } from './components/inicio/inicio.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FooterComponent } from './components/footer/footer.component';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { CarrouselComponent } from './components/carrousel/carrousel.component';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MinicarruselComponent } from './components/minicarrusel/minicarrusel.component';
import { MenumainComponent } from './components/menumain/menumain.component';
import { LineComponent } from './components/line/line.component';
import { HeaderComponent } from './components/header/header.component';
import { WhasappComponent } from './components/whasapp/whasapp.component';
import { PaginationComponent } from './components/pagination/pagination.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { CardsComponent } from './components/cards/cards.component';
import { AsComponent } from './components/as/as.component';
import { RemeraunisexComponent } from './components/remeraunisex/remeraunisex.component';
import { ChombaunisexComponent } from './components/chombaunisex/chombaunisex.component';
import { CamisaunisexComponent } from './components/camisaunisex/camisaunisex.component';
import { BuzounisexComponent } from './components/buzounisex/buzounisex.component';
import { CamperaunisexComponent } from './components/camperaunisex/camperaunisex.component';
import { JogginunisexComponent } from './components/jogginunisex/jogginunisex.component';
import { JeanunisexComponent } from './components/jeanunisex/jeanunisex.component';
import { BermudaunisexComponent } from './components/bermudaunisex/bermudaunisex.component';
import { TodosComponent } from './components/todos/todos.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    RegisterComponent,
    LoginComponent,
    InicioComponent,
    PageNotFoundComponent,
    FooterComponent,
    CarrouselComponent,
    MinicarruselComponent,
    MenumainComponent,
    LineComponent,
    HeaderComponent,
    WhasappComponent,
    PaginationComponent,
    CardsComponent,
    AsComponent,
    RemeraunisexComponent,
    ChombaunisexComponent,
    CamisaunisexComponent,
    BuzounisexComponent,
    CamperaunisexComponent,
    JogginunisexComponent,
    JeanunisexComponent,
    BermudaunisexComponent,
    TodosComponent,
  ],
  imports: [
    NgxPaginationModule,
    MdbCarouselModule,
    MdbCollapseModule,
    FormsModule,
    MatSliderModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,

    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideAuth(() => getAuth()),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
