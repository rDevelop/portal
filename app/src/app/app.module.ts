import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app.routing.module';
import { UserService } from './user/user.service';
import { TradeService } from './trade/trade.service';
import { HttpClientModule } from '@angular/common/http';
import { AddUserComponent } from './user/add-user.component';
import { TradeComponent } from './trade/trade.component';
import { AddTradeComponent } from './trade/add-trade.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    TradeComponent,
    AddTradeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserService,
    TradeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
