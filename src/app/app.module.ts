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
import { BuzohombreComponent } from './components/buzohombre/buzohombre.component';
import { MenumainComponent } from './components/menumain/menumain.component';
import { RemerahombreComponent } from './components/remerahombre/remerahombre.component';
import { PantalonhombreComponent } from './components/pantalonhombre/pantalonhombre.component';
import { BuzomujerComponent } from './components/buzomujer/buzomujer.component';
import { RemeramujerComponent } from './components/remeramujer/remeramujer.component';
import { PantalonmujerComponent } from './components/pantalonmujer/pantalonmujer.component';
import { BuzoninioComponent } from './components/buzoninio/buzoninio.component';
import { RemeraninioComponent } from './components/remeraninio/remeraninio.component';
import { PantalonninioComponent } from './components/pantalonninio/pantalonninio.component';
import { LineComponent } from './components/line/line.component';
import { HeaderComponent } from './components/header/header.component';
import { WhasappComponent } from './components/whasapp/whasapp.component';
import { PaginationComponent } from './components/pagination/pagination.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ProductService } from './services/Product.service';
import { CardsComponent } from './components/cards/cards.component';
import { AsComponent } from './components/as/as.component';

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
    BuzohombreComponent,
    MenumainComponent,
    RemerahombreComponent,
    PantalonhombreComponent,
    BuzomujerComponent,
    RemeramujerComponent,
    PantalonmujerComponent,
    BuzoninioComponent,
    RemeraninioComponent,
    PantalonninioComponent,
    LineComponent,
    HeaderComponent,
    WhasappComponent,
    PaginationComponent,
    CardsComponent,
    AsComponent,
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
