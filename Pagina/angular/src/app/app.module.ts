import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BodyComponent } from './body/body.component';
import { AsComponent } from './as/as.component';
import { ProfileComponent } from './profile/profile.component';
import { ProductComponent } from './product/product.component';
import { PurchaseHistoryComponent } from './purchaseHistory/purchaseHistory.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [				
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BodyComponent,
    AsComponent,
      ProfileComponent,
      ProductComponent,
      PurchaseHistoryComponent,
      PaymentComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
