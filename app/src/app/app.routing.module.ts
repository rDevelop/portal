import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import { AddUserComponent} from './user/add-user.component';
import { TradeComponent } from './trade/trade.component';
import { AddTradeComponent} from './trade/add-trade.component';

const routes: Routes = [
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'trades', component: TradeComponent },
  { path: 'addTrade', component: AddTradeComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
