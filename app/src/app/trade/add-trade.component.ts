import { Component } from '@angular/core';
import { Router } from '@angular/router';


import { Trade } from '../models/trade.model';
import { TradeService } from './trade.service';


@Component({
  templateUrl: './add-trade.component.html'
})
export class AddTradeComponent {

  trade: Trade = new Trade();

  constructor(private router: Router, private tradeService: TradeService) {

  }

  createTrade(): void {
    this.tradeService.createTrade(this.trade)
      .subscribe( data => {
        alert('Status: ' + data.status);
      });

  };

}
